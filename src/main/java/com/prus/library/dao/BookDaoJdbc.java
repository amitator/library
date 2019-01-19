package com.prus.library.dao;

import com.prus.library.domain.Author;
import com.prus.library.domain.Book;
import com.prus.library.domain.Publisher;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BookDaoJdbc implements BookDao {

    private final JdbcOperations jdbc;

    private final AuthorDao authorDao;

    private final PublisherDao publisherDao;

    public BookDaoJdbc(JdbcOperations jdbc, AuthorDao authorDao, PublisherDao publisherDao) {
        this.jdbc = jdbc;
        this.authorDao = authorDao;
        this.publisherDao = publisherDao;
    }

    @Override
    public void insert(Book book) {
        long publisherId;
        Publisher publisher = book.getPublisher();
        String publisherName = publisher.getName();
        String publisherCountry = publisher.getCountry();

        if (publisherDao.existInDatabase(publisher)){
            publisher = publisherDao.getByName(publisherName);
            publisherId = publisher.getPublisherId();
        } else {
            publisherDao.insert(new Publisher(publisherName, publisherCountry));
            publisherId = publisherDao.getByName(publisherName).getPublisherId();
        }

        long authorId = 0;
        Author author = book.getAuthor();
        String authorFirstName = author.getFirstName();
        String authorLastName = author.getLastName();

        if (authorDao.existInDatabase(author)){
            List<Author> temp = authorDao.getByLastName(authorLastName);
            for (Author a : temp){
                if (author.getFirstName().equalsIgnoreCase(authorFirstName)){
                    authorId = a.getAuthorId();
                }
            }
        } else {
            authorDao.insert(new Author(authorFirstName, authorLastName));
            List<Author> temp = authorDao.getByFirstName(authorFirstName);
            for (Author a : temp){
                if (a.getLastName().equalsIgnoreCase(authorLastName)){
                    authorId = a.getAuthorId();
                }
            }
        }

        jdbc.update("INSERT INTO books (`name`, isbn, year, `type`, publisher_id, author_id) VALUES (?, ?, ?, ?, ?, ?)",
                book.getName(),
                book.getIsbn(),
                book.getYear(),
                book.getType(),
                publisherId,
                authorId);
    }

    @Override
    public Book getById(long id) {
        Book book = jdbc.queryForObject("SELECT * " +
                "FROM books b " +
                "LEFT JOIN publishers p " +
                "ON b.publisher_id=p.publisher_id " +
                "LEFT JOIN authors a " +
                "ON b.author_id=a.author_id " +
                "WHERE id=?", new Object[] {id}, new BookMapper());
        return book;
    }

    @Override
    public List<Book> getByYear(int year) {
        List<Book> list = jdbc.query("SELECT * " +
                "FROM books b " +
                "LEFT JOIN publishers p " +
                "ON b.publisher_id=p.publisher_id " +
                "LEFT JOIN authors a " +
                "ON b.author_id=a.author_id " +
                "WHERE year=?", new Object[] {year}, new BookMapper());
        return list;
    }

    @Override
    public List<Book> getByType(String type) {
        List<Book> list = jdbc.query("SELECT * " +
                "FROM books b " +
                "LEFT JOIN publishers p " +
                "ON b.publisher_id=p.publisher_id " +
                "LEFT JOIN authors a " +
                "ON b.author_id=a.author_id " +
                "WHERE type=?", new Object[] {type}, new BookMapper());
        return list;
    }

    @Override
    public List<Book> getByAuthor(Author author) {
        return null;
    }

    @Override
    public List<Book> getByPublisher(String name) {
        List<Book> list = jdbc.query("SELECT * " +
                "FROM books b " +
                "LEFT JOIN publishers p " +
                "ON b.publisher_id=p.publisher_id " +
                "LEFT JOIN authors a " +
                "ON b.author_id=a.author_id " +
                "WHERE publisher_name=?", new Object[] {name}, new BookMapper());
        return list;
    }

    @Override
    public List<Book> getAll() {
        List<Book> list = jdbc.query("SELECT * " +
                "FROM books b " +
                "LEFT JOIN publishers p " +
                "ON b.publisher_id=p.publisher_id " +
                "LEFT JOIN authors a " +
                "ON b.author_id=a.author_id ", new BookMapper());
        return list;
    }

    private static class BookMapper implements RowMapper<Book>{

        @Override
        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int isbn = rs.getInt("isbn");
            int year = rs.getInt("year");
            String type = rs.getString("type");
            int publisherId = rs.getInt("publisher_id");
            int authorId = rs.getInt("author_id");
            String publisherName = rs.getString("publisher_name");
            String country = rs.getString("country");
            String authorFirstName = rs.getString("first_name");
            String authorLastName = rs.getString("last_name");

            return new Book(id, name, isbn, year, type, new Publisher(publisherName, country), new Author(authorFirstName, authorLastName));
        }
    }
}

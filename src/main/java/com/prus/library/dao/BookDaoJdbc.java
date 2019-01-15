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
        jdbc.update("INSERT INTO books (`name`, isbn, year, `type`, publisher_id, author_id) VALUES (?, ?, ?, ?, ?, ?)",
                book.getName(),
                book.getIsbn(),
                book.getYear(),
                book.getType(),
                book.getPublisherId(),
                book.getAuthorId());
    }

    @Override
    public Book getById(long id) {
        Book book = jdbc.queryForObject("SELECT * FROM books  WHERE id=?", new Object[] {id}, new BookMapper());
        getAuthor(book);
        return getPublisher(book);
    }

    @Override
    public List<Book> getByYear(int year) {
        List<Book> list = jdbc.query("SELECT * FROM books WHERE year=?", new Object[] {year}, new BookMapper());
        getPublisherList(list);
        return getAuthorsList(list);
    }

    @Override
    public List<Book> getByType(String type) {
        List<Book> list = jdbc.query("SELECT * FROM books WHERE type=?", new Object[] {type}, new BookMapper());
        getPublisherList(list);
        return getAuthorsList(list);
    }

    @Override
    public List<Book> getByAuthor(Author author) { return null; }

    @Override
    public Book getByPublisher(Publisher publisher) {
        return null;
    }

    @Override
    public List<Book> getAll() {
        List<Book> list = jdbc.query("SELECT * FROM books", new BookMapper());
        list = getPublisherList(list);
        return getAuthorsList(list);
    }

    private List<Book> getAuthorsList(List<Book> list){
        for(Book b: list){
            getAuthor(b);
        }
        return list;
    }

    private Book getAuthor(Book book){
        Author author = authorDao.getById(book.getAuthorId());
        book.setAuthor(author);
        return book;
    }

    private Book getPublisher(Book book){
        Publisher publisher = publisherDao.getById(book.getAuthorId());
        book.setPublisher(publisher);
        return book;
    }

    private List<Book> getPublisherList(List<Book> list){
        for (Book b : list) {
            Publisher publisher = publisherDao.getById(b.getPublisherId());
            b.setPublisher(publisher);
        }
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
            int publisher_id = rs.getInt("publisher_id");
            int author_id = rs.getInt("author_id");

            return new Book(id, name, isbn, year, type, publisher_id, author_id);
        }
    }
}

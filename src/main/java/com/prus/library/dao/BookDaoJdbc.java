package com.prus.library.dao;

import com.prus.library.entities.AuthorEntity;
import com.prus.library.entities.BookEntity;
import com.prus.library.entities.PublisherEntity;
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
    public void insert(BookEntity bookEntity) {
        PublisherEntity publisherEntity = bookEntity.getPublisherEntity();
        long publisherId = publisherDao.insert(publisherEntity);
        if (publisherId == -1L){
            publisherId = publisherDao.getByName(publisherEntity.getName()).getPublisherId();
        }

        AuthorEntity authorEntity = bookEntity.getAuthorEntity();
        long authorId = authorDao.insert(authorEntity);
        if (authorId == -1L){
            authorId = authorDao.getByFullName(authorEntity.getFirstName(), authorEntity.getLastName()).getAuthorId();
        }

        jdbc.update("INSERT INTO books (`name`, isbn, year, `type`, publisher_id, author_id) VALUES (?, ?, ?, ?, ?, ?)",
                bookEntity.getName(),
                bookEntity.getIsbn(),
                bookEntity.getYear(),
                bookEntity.getType(),
                publisherId,
                authorId);
    }

    @Override
    public BookEntity getById(long id) {
        BookEntity bookEntity = jdbc.queryForObject("SELECT * " +
                "FROM books b " +
                "LEFT JOIN publishers p " +
                "ON b.publisher_id=p.publisher_id " +
                "LEFT JOIN authors a " +
                "ON b.author_id=a.author_id " +
                "WHERE id=?", new Object[] {id}, new BookMapper());
        return bookEntity;
    }

    @Override
    public List<BookEntity> getByYear(int year) {
        List<BookEntity> list = jdbc.query("SELECT * " +
                "FROM books b " +
                "LEFT JOIN publishers p " +
                "ON b.publisher_id=p.publisher_id " +
                "LEFT JOIN authors a " +
                "ON b.author_id=a.author_id " +
                "WHERE year=?", new Object[] {year}, new BookMapper());
        return list;
    }

    @Override
    public List<BookEntity> getByType(String type) {
        List<BookEntity> list = jdbc.query("SELECT * " +
                "FROM books b " +
                "LEFT JOIN publishers p " +
                "ON b.publisher_id=p.publisher_id " +
                "LEFT JOIN authors a " +
                "ON b.author_id=a.author_id " +
                "WHERE type=?", new Object[] {type}, new BookMapper());
        return list;
    }

    @Override
    public List<BookEntity> getByAuthor(AuthorEntity authorEntity) {
        return null;
    }

    @Override
    public List<BookEntity> getByPublisher(String name) {
        List<BookEntity> list = jdbc.query("SELECT * " +
                "FROM books b " +
                "LEFT JOIN publishers p " +
                "ON b.publisher_id=p.publisher_id " +
                "LEFT JOIN authors a " +
                "ON b.author_id=a.author_id " +
                "WHERE publisher_name=?", new Object[] {name}, new BookMapper());
        return list;
    }

    @Override
    public List<BookEntity> getAll() {
        List<BookEntity> list = jdbc.query("SELECT * " +
                "FROM books b " +
                "LEFT JOIN publishers p " +
                "ON b.publisher_id=p.publisher_id " +
                "LEFT JOIN authors a " +
                "ON b.author_id=a.author_id ", new BookMapper());
        return list;
    }

    private static class BookMapper implements RowMapper<BookEntity>{

        @Override
        public BookEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
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

            return new BookEntity(id, name, isbn, year, type, new PublisherEntity(publisherName, country), new AuthorEntity(authorFirstName, authorLastName));
        }
    }
}

package com.prus.library.dao;

import com.prus.library.domain.Author;
import com.prus.library.domain.Book;
import com.prus.library.domain.Publisher;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BookDaoJdbc implements BookDao {

    private final JdbcOperations jdbc;

    public BookDaoJdbc(JdbcOperations jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public void insert(Book book) {
        jdbc.update("INSERT INTO books (id, `name`, isbn, year, `type`, publisher_id, author_id) VALUES (?, ?, ?, ?, ?, ?, ?)",
                book.getId(),
                book.getName(),
                book.getIsbn(),
                book.getYear(),
                book.getType(),
                book.getPublisher_id(),
                book.getAuthor_id());
    }

    @Override
    public Book getById(int id) {
        return jdbc.queryForObject("SELECT * FROM books WHERE id=?", new Object[] {id}, new BookMapper());
    }

    @Override
    public Book getByYear(int year) {
        return jdbc.queryForObject("SELECT * FROM books WHERE year=?", new Object[] {year}, new BookMapper());
    }

    @Override
    public Book getByType(String type) {
        return jdbc.queryForObject("SELECT * FROM books WHERE type=?", new Object[] {type}, new BookMapper());
    }

    @Override
    public Book getByAuthor(Author author) {
        return null;
    }

    @Override
    public Book getByPublisher(Publisher publisher) {
        return null;
    }

    @Override
    public List<Book> getAll() {
        return jdbc.queryForList("SELECT * FROM books", Book.class, new BookMapper());
    }

    private static class BookMapper implements RowMapper<Book>{

        @Nullable
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
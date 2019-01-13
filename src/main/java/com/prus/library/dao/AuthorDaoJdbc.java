package com.prus.library.dao;

import com.prus.library.domain.Author;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AuthorDaoJdbc implements AuthorDao {

    private final JdbcOperations jdbc;

    public AuthorDaoJdbc(JdbcOperations jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public List<Author> getAll() {
        return jdbc.query("SELECT * FROM authors", new AuthorMapper());
    }

    @Override
    public Author getById(int id) {
        return jdbc.queryForObject("SELECT * FROM authors WHERE author_id=?", new Object[] {id}, new AuthorMapper());
    }

    @Override
    public List<Author> getByFirstName(String firstName) {
        return jdbc.query("SELECT * FROM authors WHERE first_name=?", new Object[] {firstName}, new AuthorMapper());
    }

    @Override
    public List<Author> getByLastName(String lastName) {
        return jdbc.query("SELECT * FROM authors WHERE last_name=?", new Object[] {lastName}, new AuthorMapper());
    }

    @Override
    public void insert(Author author) {
        jdbc.update("INSERT INTO AUTHORS (FIRST_NAME, LAST_NAME) VALUES (?, ?)",
                author.getFirst_name(),
                author.getLast_name());
    }

    private static class AuthorMapper implements RowMapper<Author> {

        @Override
        public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
            int id = rs.getInt("author_id");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");

            return new Author(id, firstName, lastName);
        }
    }
}

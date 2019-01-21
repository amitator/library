package com.prus.library.dao;

import com.prus.library.domain.Author;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
    public Author getById(long id) {
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

    public Author getByFullName(String firstName, String lastName) {
        return jdbc.queryForObject("SELECT * FROM authors WHERE first_name=? AND last_name=?", new Object[] {firstName, lastName}, new AuthorMapper());
    }

    @Override
    public long insert(Author author) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        if (!existInDatabase(author)) {
            final String query = "INSERT INTO AUTHORS (FIRST_NAME, LAST_NAME) VALUES (?, ?)";
            jdbc.update(new PreparedStatementCreator() {
                @Override
                public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                    PreparedStatement ps = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
                    ps.setString(1, author.getFirstName());
                    ps.setString(2, author.getLastName());
                    return ps;
                }
            }, keyHolder);
        } else {
            return -1L;
        }
        return keyHolder.getKey().longValue();
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

    public boolean existInDatabase(Author author){
        try {
            Author temp = getByFullName(author.getFirstName(), author.getLastName());
        }catch (Exception e){
            return false;
        }
        return true;

    }

}

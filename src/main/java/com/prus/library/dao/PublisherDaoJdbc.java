package com.prus.library.dao;

import com.prus.library.domain.Publisher;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PublisherDaoJdbc implements PublisherDao{

    private final JdbcOperations jdbc;

    public PublisherDaoJdbc(JdbcOperations jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public List<Publisher> getAll() {
        return jdbc.query("SELECT * FROM publishers", new PublisherMapper());
    }

    @Override
    public Publisher getById(int id) {
        return jdbc.queryForObject("SELECT * FROM publishers WHERE publisher_id=?", new Object[] {id}, new PublisherMapper());
    }

    @Override
    public List<Publisher> getByName(String name) {
        return jdbc.query("SELECT * FROM publishers WHERE name=?", new Object[] {name}, new PublisherMapper());
    }

    @Override
    public List<Publisher> getByCountry(String country) {
        return jdbc.query("SELECT * FROM publishers WHERE country=?", new Object[] {country}, new PublisherMapper());
    }

    @Override
    public void insert(Publisher publisher) {
        jdbc.update("INSERT INTO publishers (ID, NAME, COUNTRY) VALUES (?, ?, ?)",
                publisher.getPublisher_id(),
                publisher.getName(),
                publisher.getCountry());
    }

    private static class PublisherMapper implements RowMapper<Publisher> {

        @Override
        public Publisher mapRow(ResultSet rs, int rowNum) throws SQLException {
            int id = rs.getInt("publisher_id");
            String name = rs.getString("name");
            String country = rs.getString("country");

            return new Publisher(id, name, country);
        }
    }

}
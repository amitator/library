package com.prus.library.dao;

import com.prus.library.entities.Publisher;
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
    public Publisher getById(long id) {
        return jdbc.queryForObject("SELECT * FROM publishers WHERE publisher_id=?", new Object[] {id}, new PublisherMapper());
    }

    @Override
    public Publisher getByName(String name) {
        return jdbc.queryForObject("SELECT * FROM publishers WHERE publisher_name=?", new Object[] {name}, new PublisherMapper());
    }

    @Override
    public List<Publisher> getByCountry(String country) {
        return jdbc.query("SELECT * FROM publishers WHERE country=?", new Object[] {country}, new PublisherMapper());
    }

    @Override
    public long insert(Publisher publisher) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        if (!existInDatabase(publisher)) {
            final String query = "INSERT INTO publishers (PUBLISHER_NAME, COUNTRY) VALUES (?, ?)";
            jdbc.update(new PreparedStatementCreator() {
                @Override
                public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                    PreparedStatement ps = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
                    ps.setString(1, publisher.getName());
                    ps.setString(2, publisher.getCountry());
                    return ps;
                }
            }, keyHolder);
        } else {
            return -1L;
        }
        return keyHolder.getKey().longValue();
    }

    private static class PublisherMapper implements RowMapper<Publisher> {

        @Override
        public Publisher mapRow(ResultSet rs, int rowNum) throws SQLException {
            int id = rs.getInt("publisher_id");
            String name = rs.getString("publisher_name");
            String country = rs.getString("country");

            return new Publisher(id, name, country);
        }
    }

    public boolean existInDatabase(Publisher publisher){
        String publisherName = publisher.getName();
        try {
            Publisher temp = getByName(publisherName);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}

package com.prus.library.dao;

import com.prus.library.domain.Publisher;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
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
    public void insert(Publisher publisher) {
        jdbc.update("INSERT INTO publishers (NAME, COUNTRY) VALUES (?, ?)",
                publisher.getName(),
                publisher.getCountry());
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
        System.out.println("TEMP: BEFORE QUERY");
        String publisherName = publisher.getName();
        System.out.println("Publisher Name: " + publisherName);
//        Publisher temp = jdbc.query("SELECT * FROM publishers WHERE publisher_name=?", new Object[] {publisherName}, new PublisherMapper());
        Publisher temp;
        try {
            temp = getByName(publisherName);
        }catch (Exception e){
//            System.out.println("TEMP: " + temp);
            return false;
        }
        System.out.println("TEMP: " + temp);
        return true;
    }
}

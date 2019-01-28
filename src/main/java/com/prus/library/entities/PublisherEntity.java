package com.prus.library.entities;

import javax.persistence.*;

@Entity
@Table(name = "publishers")
public class PublisherEntity {

//    @Id
//    @GeneratedValue
    private long publisherId;
    private final String name;
    private final String country;

    public PublisherEntity(String name, String country){
        this.name = name;
        this.country = country;
    }

    public PublisherEntity(int publisherId, String name, String country){
        this.publisherId = publisherId;
        this.name = name;
        this.country = country;
    }

    @Id
    @GeneratedValue
    @Column(name = "publisher_id", nullable = false)
    public long getPublisherId() {
        return publisherId;
    }

    @Column(name = "publisher_namre", nullable = false, length = 100)
    public String getName() {
        return name;
    }

    @Column(name = "country", length = 2)
    public String getCountry() {
        return country;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(publisherId).append("\n");
        sb.append("Name: ").append(name).append("\n");
        sb.append("Country: ").append(country).append("\n");

        return sb.toString();
    }

}

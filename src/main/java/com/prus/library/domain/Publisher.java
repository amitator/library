package com.prus.library.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Publisher {

    @Id
    @GeneratedValue
    private long publisherId;
    private final String name;
    private final String country;

    public Publisher(String name, String country){
        this.name = name;
        this.country = country;
    }

    public Publisher(int publisherId, String name, String country){
        this.publisherId = publisherId;
        this.name = name;
        this.country = country;
    }

    public long getPublisherId() {
        return publisherId;
    }

    public String getName() {
        return name;
    }

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

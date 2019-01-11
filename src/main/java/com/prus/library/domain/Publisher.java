package com.prus.library.domain;

public class Publisher {
    private final int publisher_id;
    private final String name;
    private final String country;

    public Publisher(int publisher_id, String name, String country){
        this.publisher_id = publisher_id;
        this.name = name;
        this.country = country;
    }

}

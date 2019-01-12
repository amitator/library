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

    public int getPublisher_id() {
        return publisher_id;
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
        sb.append("ID: ").append(publisher_id).append("\n");
        sb.append("Name: ").append(name).append("\n");
        sb.append("Country: ").append(country).append("\n");

        return sb.toString();
    }
}

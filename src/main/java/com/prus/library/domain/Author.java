package com.prus.library.domain;

public class Author {
    private long author_id;
    private final String first_name;
    private final String last_name;

    public Author(long author_id, String first_name, String last_name){
        this.author_id = author_id;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public long getAuthor_id() {
        return author_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(author_id).append("\n");
        sb.append("First name: ").append(first_name).append("\n");
        sb.append("Last name: ").append(last_name).append("\n");

        return sb.toString();
    }
}

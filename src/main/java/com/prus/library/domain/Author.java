package com.prus.library.domain;

public class Author {
    private final int author_id;
    private final String first_name;
    private final String last_name;

    public Author(int author_id, String first_name, String last_name){
        this.author_id = author_id;
        this.first_name = first_name;
        this.last_name = last_name;
    }
}

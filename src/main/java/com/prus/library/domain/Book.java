package com.prus.library.domain;

public class Book {
    private final int id;
    private final String name;
    private final int isbn;
    private final int year;
    private final String type;
    private final int publisher_id;
    private final int author_id;

    public Book(int id, String name, int isbn, int year, String type, int publisher_id, int author_id){
        this.id = id;
        this.name = name;
        this.isbn = isbn;
        this.year = year;
        this.type = type;
        this.publisher_id = publisher_id;
        this.author_id = author_id;
    }

}

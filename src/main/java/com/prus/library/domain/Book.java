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

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getIsbn() {
        return isbn;
    }

    public int getYear() {
        return year;
    }

    public String getType() {
        return type;
    }

    public int getPublisher_id() {
        return publisher_id;
    }

    public int getAuthor_id() {
        return author_id;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(id);
        sb.append("Book name: ").append(name);
        sb.append("ISBN: ").append(isbn);
        sb.append("Year: ").append(year);
        sb.append("Type: ").append(type);
        return sb.toString();
    }
}

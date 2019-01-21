package com.prus.library.domain;

public class Book {

    private long id;
    private final String name;
    private final int isbn;
    private final int year;
    private final String type;
    private Author author;
    private Publisher publisher;

    public Book(String name, int isbn, int year, String type, Publisher publisher, Author author){
        this.name = name;
        this.isbn = isbn;
        this.year = year;
        this.type = type;
        this.publisher = publisher;
        this.author = author;
    }

    public Book(int id, String name, int isbn, int year, String type, Publisher publisher, Author author){
        this.id = id;
        this.name = name;
        this.isbn = isbn;
        this.year = year;
        this.type = type;
        this.publisher = publisher;
        this.author = author;
    }

    public long getId() {
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

    public Author getAuthor() {
        return author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(id).append("\n");
        sb.append("Book name: ").append(name).append("\n");
        sb.append("ISBN: ").append(isbn).append("\n");
        sb.append("Year: ").append(year).append("\n");
        sb.append("Type: ").append(type).append("\n");
        sb.append("Author: ").append(author.getFirstName()).append(" ").append(author.getLastName()).append("\n");
        sb.append("Publisher: ").append(publisher.getName()).append("\n");
        sb.append("Publisher's Country: ").append(publisher.getCountry()).append("\n");
        return sb.toString();
    }
}

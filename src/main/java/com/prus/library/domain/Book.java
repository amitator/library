package com.prus.library.domain;

public class Book {

    private long id;
    private final String name;
    private final int isbn;
    private final int year;
    private final String type;
    private final long publisherId;
    private final long authorId;
    private Author author;
    private Publisher publisher;

    public Book(String name, int isbn, int year, String type, int publisherId, int authorId){
        this.name = name;
        this.isbn = isbn;
        this.year = year;
        this.type = type;
        this.publisherId = publisherId;
        this.authorId = authorId;
    }

    public Book(int id, String name, int isbn, int year, String type, int publisherId, int authorId){
        this.id = id;
        this.name = name;
        this.isbn = isbn;
        this.year = year;
        this.type = type;
        this.publisherId = publisherId;
        this.authorId = authorId;
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

    public long getPublisherId() {
        return publisherId;
    }

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthor(Author author){
        this.author = author;
    }

    public void setPublisher(Publisher publisher){
        this.publisher = publisher;
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
        return sb.toString();
    }
}

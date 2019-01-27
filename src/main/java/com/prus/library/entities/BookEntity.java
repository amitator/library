package com.prus.library.entities;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class BookEntity {

    @Id
    @GeneratedValue
    private long id;
    private final String name;
    private final int isbn;
    private final int year;
    private final String type;
    private AuthorEntity authorEntity;
    private PublisherEntity publisherEntity;

    public BookEntity(String name, int isbn, int year, String type, PublisherEntity publisherEntity, AuthorEntity authorEntity){
        this.name = name;
        this.isbn = isbn;
        this.year = year;
        this.type = type;
        this.publisherEntity = publisherEntity;
        this.authorEntity = authorEntity;
    }

    public BookEntity(int id, String name, int isbn, int year, String type, PublisherEntity publisherEntity, AuthorEntity authorEntity){
        this.id = id;
        this.name = name;
        this.isbn = isbn;
        this.year = year;
        this.type = type;
        this.publisherEntity = publisherEntity;
        this.authorEntity = authorEntity;
    }

    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    @Column(name = "name", nullable = false, length = 100)
    public String getName() {
        return name;
    }

    @Column(name = "isbn")
    public int getIsbn() {
        return isbn;
    }

    @Column(name = "year")
    public int getYear() {
        return year;
    }

    @Column(name = "type", length = 100)
    public String getType() {
        return type;
    }

//    @OneToMany(mappedBy = "author_id", cascade = CascadeType.PERSIST)
    @Column(name = "author_id")
    public AuthorEntity getAuthorEntity() {
        return authorEntity;
    }

//    @OneToMany(mappedBy = "publisher_id", cascade = CascadeType.PERSIST)
    @Column(name = "publisher_id")
    public PublisherEntity getPublisherEntity() {
        return publisherEntity;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(id).append("\n");
        sb.append("BookEntity name: ").append(name).append("\n");
        sb.append("ISBN: ").append(isbn).append("\n");
        sb.append("Year: ").append(year).append("\n");
        sb.append("Type: ").append(type).append("\n");
        sb.append("AuthorEntity: ").append(authorEntity.getFirstName()).append(" ").append(authorEntity.getLastName()).append("\n");
        sb.append("PublisherEntity: ").append(publisherEntity.getName()).append("\n");
        sb.append("PublisherEntity's Country: ").append(publisherEntity.getCountry()).append("\n");
        return sb.toString();
    }
}

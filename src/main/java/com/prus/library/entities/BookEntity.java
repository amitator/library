package com.prus.library.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor(force = true)
@Entity
@Table(name = "books")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "isbn")
    private int isbn;

    @Column(name = "year")
    private int year;

    @Column(name = "type", length = 100)
    private String type;

    @OneToOne//(cascade = CascadeType.PERSIST)
//    @JoinColumn(name = "author_id", referencedColumnName = "author_id")
    private AuthorEntity authorEntity;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_id")
    private PublisherEntity publisherEntity;

//    public BookEntity() {}

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

//    public long getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public int getIsbn() {
//        return isbn;
//    }
//
//    public int getYear() {
//        return year;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public AuthorEntity getAuthorEntity() {
//        return authorEntity;
//    }
//
//    public PublisherEntity getPublisherEntity() {
//        return publisherEntity;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setIsbn(int isbn) {
//        this.isbn = isbn;
//    }
//
//    public void setYear(int year) {
//        this.year = year;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public void setAuthorEntity(AuthorEntity authorEntity) {
//        this.authorEntity = authorEntity;
//    }
//
//    public void setPublisherEntity(PublisherEntity publisherEntity) {
//        this.publisherEntity = publisherEntity;
//    }

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

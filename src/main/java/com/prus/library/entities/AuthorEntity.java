package com.prus.library.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="authors")
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id", nullable = false)
    private long authorId;

    @Column(name = "first_name", nullable = false, length = 60)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 60)
    private String lastName;

    public AuthorEntity(){}

    public AuthorEntity(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public AuthorEntity(long authorId, String firstName, String lastName){
        this.authorId = authorId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(authorId).append("\n");
        sb.append("First name: ").append(firstName).append("\n");
        sb.append("Last name: ").append(lastName).append("\n");

        return sb.toString();
    }
}

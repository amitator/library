package com.prus.library.entities;

import javax.persistence.*;

@Entity
@Table(name="authors")
public class AuthorEntity {

    @Id
    @GeneratedValue
    @Column(name = "author_id", nullable = false)
    private long authorId;

    @Column(name = "first_name", nullable = false, length = 60)
    private final String firstName;

    @Column(name = "last_name", nullable = false, length = 60)
    private final String lastName;

    public AuthorEntity(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public AuthorEntity(long authorId, String firstName, String lastName){
        this.authorId = authorId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getAuthorId() {
        return authorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
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

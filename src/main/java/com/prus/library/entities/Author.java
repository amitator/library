package com.prus.library.entities;

import javax.persistence.*;

@Entity
@Table(name="authors")
public class Author {

    @Id
    @GeneratedValue
    private long authorId;
    private final String firstName;
    private final String lastName;

    public Author(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Author(long authorId, String firstName, String lastName){
        this.authorId = authorId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Column(name = "author_id", nullable = false, insertable = true, updatable = true)
    public long getAuthorId() {
        return authorId;
    }

    @Column(name = "first_name", nullable = false, insertable = true, updatable = true, length = 60)
    public String getFirstName() {
        return firstName;
    }

    @Column(name = "last_name", nullable = false, insertable = true, updatable = true, length = 60)
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

package com.prus.library.domain;

public class Author {
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

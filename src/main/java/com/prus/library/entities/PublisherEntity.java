package com.prus.library.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor(force = true)
@Entity
@Table(name = "publishers")
public class PublisherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisher_id", nullable = false, updatable = false)
    private long publisherId;

    @Column(name = "publisher_name", nullable = false, length = 100)
    private String name;

    @Column(name = "country", length = 2)
    private String country;

    public PublisherEntity(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public PublisherEntity(int publisherId, String name, String country) {
        this.publisherId = publisherId;
        this.name = name;
        this.country = country;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(publisherId).append("\n");
        sb.append("Name: ").append(name).append("\n");
        sb.append("Country: ").append(country).append("\n");

        return sb.toString();
    }

}

package com.example.db;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "author")
public class AuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AUTHOR_GEN")
    @SequenceGenerator(name = "AUTHOR_GEN", sequenceName = "author_seq", allocationSize = 1)
    private Long id;

    private String first_and_second_name;

    public AuthorEntity(String first_and_second_name) {
        this.first_and_second_name = first_and_second_name;
    }

    public AuthorEntity() {

    }
}

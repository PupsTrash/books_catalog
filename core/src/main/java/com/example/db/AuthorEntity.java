package com.example.db;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "author")
public class AuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AUTHOR_GEN")
    @SequenceGenerator(name = "AUTHOR_GEN", sequenceName = "author_seq", allocationSize = 1)
    private Long id;

    private String first_name;
    private String second_name;
}

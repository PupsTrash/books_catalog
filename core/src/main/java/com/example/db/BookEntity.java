package com.example.db;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOOK_GEN")
    @SequenceGenerator(name = "BOOK_GEN", sequenceName = "book_seq", allocationSize = 1)
    private Long id;

    private String title;
    private String author;
    private String codeISBN;
    private Short yearPublishing;

}

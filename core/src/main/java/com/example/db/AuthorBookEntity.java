package com.example.db;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "book_author")
@Setter
@Getter
public class AuthorBookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOOK_AUTHOR_GEN")
    @SequenceGenerator(name = "BOOK_AUTHOR_GEN", sequenceName = "book_author_seq", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private BookEntity book;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private AuthorEntity author;


}

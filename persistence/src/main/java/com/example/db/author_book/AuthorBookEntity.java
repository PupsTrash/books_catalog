package com.example.db.author_book;

import javax.persistence.*;

import com.example.db.author.AuthorEntity;
import com.example.db.book.BookEntity;
import lombok.Getter;
import lombok.Setter;

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

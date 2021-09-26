package com.example.db.book;

import com.example.db.author.AuthorEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "book")
@Getter
@Setter
@NoArgsConstructor
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOOK_GEN")
    @SequenceGenerator(name = "BOOK_GEN", sequenceName = "book_seq", allocationSize = 1)
    private Long id;

    private String title;
    private String isbn;
    private Short year;

    private OffsetDateTime created_at;
    private OffsetDateTime deleted_at;

    @PrePersist
    void prePersist() {
        created_at = OffsetDateTime.now();
    }


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private Set<AuthorEntity> authors = new HashSet<>();


}

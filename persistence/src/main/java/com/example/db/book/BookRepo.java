package com.example.db.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepo extends JpaRepository<BookEntity, Long>, JpaSpecificationExecutor<BookEntity> {

    /**
     * Find book by id and field deleted_at is null
     */
    @Query(value = "SELECT book from BookEntity book WHERE book.id = :id AND book.deleted_at is null")
    Optional<BookEntity> findNonDeletedBookById(Long id);
}

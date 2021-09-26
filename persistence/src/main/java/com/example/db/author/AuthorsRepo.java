package com.example.db.author;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorsRepo extends JpaRepository<AuthorEntity, Long> {
}

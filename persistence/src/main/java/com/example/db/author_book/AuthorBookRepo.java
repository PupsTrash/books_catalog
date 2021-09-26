package com.example.db.author_book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface AuthorBookRepo extends JpaRepository<AuthorBookEntity, Long> {
}

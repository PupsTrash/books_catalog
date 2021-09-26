package com.example.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface AuthorBookRepo extends JpaRepository<AuthorBookEntity, Long> {
}

package com.example.repositories;

import com.example.db.AuthorBookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorBookRepo extends JpaRepository<AuthorBookEntity, Long> {
}

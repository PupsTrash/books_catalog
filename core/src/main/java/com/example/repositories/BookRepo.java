package com.example.repositories;

import com.example.db.BookEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface BookRepo extends JpaRepository<BookEntity, Long>{
}

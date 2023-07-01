package com.example.bookshopsystem.repositories;

import com.example.bookshopsystem.models.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    @Query("Select a from Author a order by size(a.books) ")
    List<Author> findAllDistinctOrderByBooks();
}

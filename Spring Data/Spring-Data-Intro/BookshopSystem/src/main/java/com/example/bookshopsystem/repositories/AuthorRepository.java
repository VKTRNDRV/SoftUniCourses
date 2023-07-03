package com.example.bookshopsystem.repositories;

import com.example.bookshopsystem.models.entities.Author;
import com.example.bookshopsystem.models.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    @Query("Select a from Author a order by size(a.books) ")
    List<Author> findAllDistinctOrderByBooks();

    List<Author> findAllByFirstNameEndingWith(String end);

    List<Author> findAuthorByBooksContaining(Book book);

    @Query(value = "SELECT sum(b.copies) FROM Author a JOIN a.books b where a = :author")
    int getTotalBookCopiesByAuthor(Author author);
}

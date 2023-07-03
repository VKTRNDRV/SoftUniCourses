package com.example.bookshopsystem.services;

import com.example.bookshopsystem.models.entities.Author;
import com.example.bookshopsystem.models.entities.Book;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public interface AuthorService {

    boolean isDataSeeded();

    void seedAuthors(List<Author> authors);

    Author getRandomAuthor();

    List<Author> getAllAuthorsWithBooksBeforeYear(LocalDate date);

    List<Author> getAllAuthorsOrederByBooksDesc();

    List<Author> getAuthorsFirstNameEndsIn(String end);

    List<Author> findAuthorByBooksContaining(Book book);

    int getTotalBookCopiesByAuthor(Author author);
}

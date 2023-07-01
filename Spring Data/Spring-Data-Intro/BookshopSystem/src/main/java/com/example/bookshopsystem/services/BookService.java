package com.example.bookshopsystem.services;

import com.example.bookshopsystem.models.entities.Book;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public interface BookService {

    boolean isDataSeeded();

    void seedBooks(List<Book> books);

    Book getRandomBook();

    void saveBook(Book book);

    List<Book> getAllBooksAfterYear(LocalDate date);

    List<Book> getAllBooksBeforeYear(LocalDate date);

    List<Book> getAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(String firstName, String lastName);
}

package com.example.bookshopsystem.services;

import com.example.bookshopsystem.models.entities.Author;
import com.example.bookshopsystem.models.entities.Book;
import com.example.bookshopsystem.repositories.AuthorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService{

    private final AuthorRepository authorRepository;
    private final BookService bookService;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository, BookService bookService) {
        this.authorRepository = authorRepository;
        this.bookService = bookService;
    }

    @Override
    public boolean isDataSeeded() {
        return this.authorRepository.count() > 0;
    }

    @Override
    public void seedAuthors(List<Author> authors) {
        this.authorRepository.saveAllAndFlush(authors);
    }

    @Override
    public Author getRandomAuthor() {
        final int count = (int) this.authorRepository.count();

        if (count != 0) {
            int randomId = new Random().nextInt(1, count) + 1;
            return this.authorRepository.findById(randomId).orElseThrow();
        }

        throw new RuntimeException();
    }

    @Override
    public List<Author> getAllAuthorsWithBooksBeforeYear(LocalDate date) {
        final List<Author> authors = this.bookService.getAllBooksBeforeYear(date)
                .stream()
                .map(Book::getAuthor)
                .toList();

        System.out.println(authors.stream()
                .map(Author::getAuthorFullName)
                .collect(Collectors.joining("\n")));

        return authors;
    }

    @Override
    @Transactional
    public List<Author> getAllAuthorsOrederByBooksDesc() {
        return this.authorRepository.findAllDistinctOrderByBooks();
    }

    @Override
    public List<Author> getAuthorsFirstNameEndsIn(String end) {
        return this
                .authorRepository
                .findAllByFirstNameEndingWith(end);
    }

    @Override
    public List<Author> findAuthorByBooksContaining(Book book) {
        return this.authorRepository
                .findAuthorByBooksContaining(book);
    }

    @Override
    public int getTotalBookCopiesByAuthor(Author author) {
        return this
                .authorRepository
                .getTotalBookCopiesByAuthor(author);
    }
}

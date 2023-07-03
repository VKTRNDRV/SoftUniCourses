package com.example.bookshopsystem.services;

import com.example.bookshopsystem.models.entities.Book;
import com.example.bookshopsystem.models.enums.AgeRestriction;
import com.example.bookshopsystem.models.enums.EditionType;
import com.example.bookshopsystem.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public boolean isDataSeeded() {
        return this.bookRepository.count() > 0;
    }

    @Override
    public void seedBooks(List<Book> books) {
        this.bookRepository.saveAllAndFlush(books);
    }

    @Override
    public Book getRandomBook() {
        final int count = (int) this.bookRepository.count();

        if (count != 0) {
            int randomId = new Random().nextInt(1, count) + 1;
            return this.bookRepository.findById(randomId).orElseThrow();
        }

        throw new RuntimeException();
    }

    @Override
    public void saveBook(Book book) {
        this.bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooksAfterYear(LocalDate date) {
        List<Book> allByReleaseDateAfter = this.bookRepository.findAllByReleaseDateAfter(date).get();

        System.out.println(allByReleaseDateAfter.stream()
                .map(Book::getTitle)
                .collect(Collectors.joining("\n")));

        return allByReleaseDateAfter;
    }

    @Override
    public List<Book> getAllBooksBeforeYear(LocalDate date) {
        return this.bookRepository
                .findAllByReleaseDateBefore(date)
                .orElseThrow();
    }

    @Override
    public List<Book> getAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc
            (String firstName, String lastName) {
        return null;
    }

    @Override
    public List<Book> getAllBooksByAgeRestriction(String ageRestrictionString) {
        return this.bookRepository
                .findAllBooksByAgeRestriction(
                        AgeRestriction.valueOf(ageRestrictionString.toUpperCase()));
    }

    @Override
    public List<Book> getGoldenBooksWithUnder5000Copies() {
        return this.bookRepository
                .findAllByCopiesLessThanAndEditionTypeIs
                        (5000, EditionType.GOLD);
    }

    @Override
    public List<Book> getBooksWithPriceLessThan5OrGreaterThan40() {
        return this.bookRepository
                .findAllByPriceLessThanOrPriceGreaterThan
                (BigDecimal.valueOf(5), BigDecimal.valueOf(40));
    }

    @Override
    public List<Book> getBooksNotReleasedInYear(int year) {
        return this.bookRepository.findAllByYearNot(year);
    }

    @Override
    public List<Book> getBooksReleasedBeforeDateFormatDd_MM_yyyy(String date) {
        return this
                .bookRepository
                .findAllByReleaseDateBefore
                        (LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy")))
                .orElseThrow();
    }

    @Override
    public List<Book> getBooksWithTitleContainingIgnoreCasing(String substring) {
        substring = "%" + substring.toLowerCase() + "%";
        return this
                .bookRepository
                .findAllByLowercaseTitleContainingRegex(substring);
    }

    @Override
    public List<Book> getBooksWithAuthorsLastNameStartingWithIgnoreCasing(String beginning) {
        beginning = beginning.toLowerCase() + "%";
        return this
                .bookRepository
                .findAllByAuthorLastNameLowercaseStartingWith(beginning);
    }

    @Override
    public int findCountOfBooksWithTitleLongerThan(int maxLength) {
        return this
                .bookRepository
                .findCountOfBooksWithTitleLongerThan(maxLength);
    }

    @Override
    public Book findReducedBookById(long id) {
        return this.bookRepository.findReducedBookById(id);
    }


}

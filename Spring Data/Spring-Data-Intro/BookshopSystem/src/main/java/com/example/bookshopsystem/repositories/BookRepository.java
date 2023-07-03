package com.example.bookshopsystem.repositories;

import com.example.bookshopsystem.models.entities.Book;
import com.example.bookshopsystem.models.enums.AgeRestriction;
import com.example.bookshopsystem.models.enums.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    Optional<List<Book>> findAllByReleaseDateBefore(LocalDate date);
    Optional<List<Book>> findAllByReleaseDateAfter(LocalDate date);

    List<Book> findAllBooksByAgeRestriction(AgeRestriction ageRestriction);

    List<Book> findAllByCopiesLessThanAndEditionTypeIs(int copies, EditionType editionType);

    List<Book> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal minPrice, BigDecimal maxPrice);

    @Query(value = "SELECT b FROM Book b WHERE YEAR(b.releaseDate) <> :year")
    List<Book> findAllByYearNot(int year);

    @Query(value = "SELECT b FROM Book b WHERE lower(b.title) like :regex")
    List<Book> findAllByLowercaseTitleContainingRegex(String regex);

    @Query(value = "SELECT b FROM Book b JOIN b.author a WHERE lower(a.lastName) like :regex")
    List<Book> findAllByAuthorLastNameLowercaseStartingWith(String regex);

    @Query(value = "SELECT count(b) FROM Book b WHERE length(b.title) > :maxLength")
    int findCountOfBooksWithTitleLongerThan(int maxLength);

    @Query(value = "SELECT new com.example.bookshopsystem.models.entities.Book(b.title, b.editionType, b.ageRestriction, b.price) " +
            "FROM Book b WHERE b.id = :id")
    Book findReducedBookById(long id);
}

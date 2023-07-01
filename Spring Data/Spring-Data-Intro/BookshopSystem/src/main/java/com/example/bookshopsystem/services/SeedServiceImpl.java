package com.example.bookshopsystem.services;

import com.example.bookshopsystem.models.entities.Author;
import com.example.bookshopsystem.models.entities.Book;
import com.example.bookshopsystem.models.entities.Category;
import com.example.bookshopsystem.models.enums.AgeRestriction;
import com.example.bookshopsystem.models.enums.EditionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import static com.example.bookshopsystem.models.enums.FilePath.*;

@Service
public class SeedServiceImpl implements SeedService{

    private final CategoryService categoryService;
    private final BookService bookService;
    private final AuthorService authorService;

    @Autowired
    public SeedServiceImpl(CategoryService categoryService, BookService bookService, AuthorService authorService) {
        this.categoryService = categoryService;
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @Override
    public void seedAuthors() throws IOException {
        if (this.authorService.isDataSeeded()) return;
        List<String> fullNames = Files
                .readAllLines(Path.of(RESOURCE_URL + AUTHORS_FILE_NAME))
                .stream()
                .toList();

        List<Author> authors = new ArrayList<>();
        for(String name : fullNames){
            Author author = new Author();
            author.setFirstName(name.split("\\s+")[0]);
            author.setLastName(name.split("\\s+")[1]);
            authors.add(author);
        }

        this.authorService.seedAuthors(authors);
    }

    @Override
    public void seedBooks() throws IOException {
        if (this.bookService.isDataSeeded()) return;

        final List<Book> books = Files.readAllLines(Path.of(RESOURCE_URL + BOOK_FILE_NAME))
                .stream()
                .filter(s -> !s.isBlank())
                .map(row -> {
                    String[] args = row.split("\\s+");
                    String title = Arrays.stream(args)
                            .skip(5)
                            .collect(Collectors.joining());

                    return Book.builder()
                            .author(this.authorService.getRandomAuthor())
                            .categories(this.categoryService.getRandomCategories())
                            .title(title)
                            .editionType(EditionType.values()[Integer.parseInt(args[0])])
                            .ageRestriction(AgeRestriction.values()[Integer.parseInt(args[4])])
                            .releaseDate(LocalDate.parse(args[1], DateTimeFormatter.ofPattern("d/M/yyyy")))
                            .copies(Integer.parseInt(args[2]))
                            .price(new BigDecimal(args[3]))
                            .build();
                }).toList();

        this.bookService.seedBooks(books);
    }

    @Override
    public void seedCategories() throws IOException {
        if (this.categoryService.isDataSeeded()) return;

        this.categoryService.seedCategories(
                Files.readAllLines(Path.of(RESOURCE_URL + CATEGORY_FILE_NAME))
                        .stream()
                        .filter(s -> !s.isBlank())
                        .map(Category::new)
                        .toList());
    }
}

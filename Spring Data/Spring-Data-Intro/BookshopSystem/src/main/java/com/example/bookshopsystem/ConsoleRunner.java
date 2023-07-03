package com.example.bookshopsystem;

import com.example.bookshopsystem.models.entities.Author;
import com.example.bookshopsystem.models.entities.Book;
import com.example.bookshopsystem.services.AuthorService;
import com.example.bookshopsystem.services.BookService;
import com.example.bookshopsystem.services.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

// after suc compilation of our program run method will be run
@Component
public class ConsoleRunner implements CommandLineRunner {

    private final SeedService seedService;
    private final BookService bookService;
    private final AuthorService authorService;

    @Autowired
    public ConsoleRunner(SeedService seedService, BookService bookService, AuthorService authorService) {
        this.seedService = seedService;
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @Override
    public void run(String... args) throws Exception {
//        this.seedService.seedAllData();
//        this.bookService.getAllBooksAfterYear(LocalDate.of(1999, 1, 1));
//        this.authorService.getAllAuthorsWithBooksBeforeYear(LocalDate.of(1991, 1, 1));
//        this.authorService.getAllAuthorsOrederByBooksDesc();


        // 1. Books Titles by Age Restriction
//        List<Book> books = this.bookService.getAllBooksByAgeRestriction("aDuLt");
//        for(Book book : books){
//            System.out.println(book.getTitle());
//        }


        
        // 2. Golden Books
//        List<Book> books = this.bookService.getGoldenBooksWithUnder5000Copies();
//        for(Book book : books){
//            System.out.println(book.getTitle());
//        }



        // 3. Books by Price
//        List<Book> books = this.bookService.getBooksWithPriceLessThan5OrGreaterThan40();
//        for(Book book : books){
//            System.out.printf("%s = $%.2f\n"
//                    , book.getTitle()
//                    , book.getPrice());
//        }


        // 4. Not Released Books
//        List<Book> books = this.bookService.getBooksNotReleasedInYear(1998);
//        books.forEach(b -> System.out.println(b.getTitle()));



        // 5. Books Released Before Date
//        String inputDate = "30-12-1989";
//        List<Book> books = this.bookService.getBooksReleasedBeforeDateFormatDd_MM_yyyy(inputDate);
//        books.forEach(b ->
//                System.out.printf("%s %s %.2f\n",
//                b.getTitle(),
//                b.getEditionType(),
//                b.getPrice()));



        // 6. Authors Search
//        List<Author> authors = this.authorService.getAuthorsFirstNameEndsIn("a");
//        authors.forEach(a -> System.out.println(a.getAuthorFullName()));



        // 7. Books Search
//        List<Book> books = this.bookService.getBooksWithTitleContainingIgnoreCasing("WOR");
//        books.forEach(book -> System.out.println(book.getTitle()));



        // 8. Book Titles Search
//        List<Book> books = this.bookService.getBooksWithAuthorsLastNameStartingWithIgnoreCasing("gr");
//        for(Book book : books){
//            System.out.printf("%s (%s %s)\n"
//                    , book.getTitle()
//                    , book.getAuthor().getFirstName()
//                    , book.getAuthor().getLastName());
//        }



        // 9. Count Books
//        System.out.println(this
//                .bookService
//                .findCountOfBooksWithTitleLongerThan(40));



        // 10. Total Book Copies
//        Author author = this.authorService.getRandomAuthor();
//        System.out.printf("%s %s - %d\n"
//                , author.getFirstName()
//                , author.getLastName()
//                , this.authorService.getTotalBookCopiesByAuthor(author));



        // 11. Reduced Book
//        Book reducedBook = this.bookService.findReducedBookById(1L);
//        System.out.printf("%s %s %s %.2f\n"
//                , reducedBook.getTitle()
//                , reducedBook.getEditionType()
//                , reducedBook.getAgeRestriction()
//                , reducedBook.getPrice());
    }

}

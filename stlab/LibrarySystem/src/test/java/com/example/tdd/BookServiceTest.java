package com.example.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BookServiceTest {

    private BookService bookService;

    @BeforeEach
    public void setUp() {
        IBookRepository bookRepository = new FakeRepositoryForTest();
        bookService = new BookService(bookRepository);
    }

    // Test cases for getBooksByAuthor(String author)

    @Test
    public void testGetBooksByAuthor_OneBookFound() {
        List<Book> books = bookService.getBooksByAuthor("Kent Beck");
        System.out.println("testGetBooksByAuthor_OneBookFound: Found " + books.size() + " books");
        Assertions.assertEquals(1, books.size());
        Assertions.assertEquals("Test Driven Development", books.get(0).getTitle());
    }

    @Test
    public void testGetBooksByAuthor_MultipleBooksFound() {
        List<Book> books = bookService.getBooksByAuthor("Robert C. Martin");
        System.out.println("testGetBooksByAuthor_MultipleBooksFound: Found " + books.size() + " books");
        Assertions.assertEquals(2, books.size());
        Assertions.assertTrue(books.stream().anyMatch(book -> book.getTitle().equals("Clean Code")));
        Assertions.assertTrue(books.stream().anyMatch(book -> book.getTitle().equals("Clean Architecture")));
    }
    @Test
    public void testGetBooksByAuthor_NoBooksFound() {
        List<Book> books = bookService.getBooksByAuthor("Unknown Author");
        System.out.println("testGetBooksByAuthor_NoBooksFound: Found " + books.size() + " books");
        Assertions.assertEquals(0, books.size());
    }

    @Test
    public void testGetBooksByAuthor_EmptyAuthor() {
        List<Book> books = bookService.getBooksByAuthor("");
        System.out.println("testGetBooksByAuthor_EmptyAuthor: Found " + books.size() + " books");
        Assertions.assertEquals(0, books.size());
    }

    @Test
    public void testGetBooksByAuthor_NullAuthor() {
        List<Book> books = bookService.getBooksByAuthor(null);
        System.out.println("testGetBooksByAuthor_NullAuthor: Found " + books.size() + " books");
        Assertions.assertEquals(0, books.size());
    }

    // Test cases for getBooksByTitle(String title)

    @Test
    public void testGetBooksByTitle_OneBookFound() {
        List<Book> books = bookService.getBooksByTitle("Clean Code");
        System.out.println("testGetBooksByTitle_OneBookFound: Found " + books.size() + " books");
        Assertions.assertEquals(1, books.size());
        Assertions.assertEquals("Clean Code", books.get(0).getTitle());
    }

    @Test
    public void testGetBooksByTitle_MultipleBooksFound() {
        List<Book> books = bookService.getBooksByTitle("Unknown Title");
        System.out.println("testGetBooksByTitle_MultipleBooksFound: Found " + books.size() + " books");
        Assertions.assertEquals(0, books.size());
    }

    @Test
    public void testGetBooksByTitle_NoBooksFound() {
        List<Book> books = bookService.getBooksByTitle("Unknown Title");
        System.out.println("testGetBooksByTitle_NoBooksFound: Found " + books.size() + " books");
        Assertions.assertEquals(0, books.size());
    }

    @Test
    public void testGetBooksByTitle_EmptyTitle() {
        List<Book> books = bookService.getBooksByTitle("");
        System.out.println("testGetBooksByTitle_EmptyTitle: Found " + books.size() + " books");
        Assertions.assertEquals(0, books.size());
    }

    @Test
    public void testGetBooksByTitle_NullTitle() {
        List<Book> books = bookService.getBooksByTitle(null);
        System.out.println("testGetBooksByTitle_NullTitle: Found " + books.size() + " books");
        Assertions.assertEquals(0, books.size());
    }

    // Test cases for getBooksByAuthorAndTitle(String author, String title)

    @Test
    public void testGetBooksByAuthorAndTitle_ExactMatch() {
        List<Book> books = bookService.getBooksByAuthorAndTitle("Robert C. Martin", "Clean Code");
        System.out.println("testGetBooksByAuthorAndTitle_ExactMatch: Found " + books.size() + " books");
        Assertions.assertEquals(1, books.size());
        Assertions.assertEquals("Clean Code", books.get(0).getTitle());
    }

    @Test
    public void testGetBooksByAuthorAndTitle_AuthorMatchesTitleDoesNot() {
        List<Book> books = bookService.getBooksByAuthorAndTitle("Robert C. Martin", "Unknown Title");
        System.out.println("testGetBooksByAuthorAndTitle_AuthorMatchesTitleDoesNot: Found " + books.size() + " books");
        Assertions.assertEquals(0, books.size());
    }

    @Test
    public void testGetBooksByAuthorAndTitle_TitleMatchesAuthorDoesNot() {
        List<Book> books = bookService.getBooksByAuthorAndTitle("Unknown Author", "Clean Code");
        System.out.println("testGetBooksByAuthorAndTitle_TitleMatchesAuthorDoesNot: Found " + books.size() + " books");
        Assertions.assertEquals(0, books.size());
    }

    @Test
    public void testGetBooksByAuthorAndTitle_NoMatch() {
        List<Book> books = bookService.getBooksByAuthorAndTitle("Unknown Author", "Unknown Title");
        System.out.println("testGetBooksByAuthorAndTitle_NoMatch: Found " + books.size() + " books");
        Assertions.assertEquals(0, books.size());
    }

    @Test
    public void testGetBooksByAuthorAndTitle_EmptyAuthorAndTitle() {
        List<Book> books = bookService.getBooksByAuthorAndTitle("", "");
        System.out.println("testGetBooksByAuthorAndTitle_EmptyAuthorAndTitle: Found " + books.size() + " books");
        Assertions.assertEquals(0, books.size());
    }

    @Test
    public void testGetBooksByAuthorAndTitle_NullAuthorAndTitle() {
        List<Book> books = bookService.getBooksByAuthorAndTitle(null, null);
        System.out.println("testGetBooksByAuthorAndTitle_NullAuthorAndTitle: Found " + books.size() + " books");
        Assertions.assertEquals(0, books.size());
    }
}
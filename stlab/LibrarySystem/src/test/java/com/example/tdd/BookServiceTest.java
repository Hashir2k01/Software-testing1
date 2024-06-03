package com.example.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class BookServiceTest {

    private BookService bookService;

    @BeforeEach
public void setUp() {
    IBookRepository bookRepository = new FakeRepositoryForTest();
    bookService = new BookService(bookRepository);
}


    @Test
    public void testGetBooksByAuthor_AuthorExists_ReturnsMatchingBooks() {
        // Arrange
        FakeRepositoryForTest.booksList = new ArrayList<>();
        FakeRepositoryForTest.booksList.add(new Book("1", "Test Driven Development", "Kent Beck"));
        FakeRepositoryForTest.booksList.add(new Book("2", "Refactoring", "Martin Fowler"));

        // Act
        List<Book> books = bookService.getBooksByAuthor("Kent Beck");

        // Assert
        Assertions.assertEquals(1, books.size());
        Assertions.assertEquals("Test Driven Development", books.get(0).getTitle());
    }

    @Test
    public void testGetBooksByAuthor_AuthorDoesNotExist_ReturnsEmptyList() {
        // Arrange
        FakeRepositoryForTest.booksList = new ArrayList<>();

        // Act
        List<Book> books = bookService.getBooksByAuthor("Unknown Author");

        // Assert
        Assertions.assertTrue(books.isEmpty());
    }

    @Test
    public void testGetBooksByTitle_TitleExists_ReturnsMatchingBooks() {
        // Arrange
        FakeRepositoryForTest.booksList = new ArrayList<>();
        FakeRepositoryForTest.booksList.add(new Book("1", "Test Driven Development", "Kent Beck"));
        FakeRepositoryForTest.booksList.add(new Book("2", "Refactoring", "Martin Fowler"));

        // Act
        List<Book> books = bookService.getBooksByTitle("Test Driven Development");

        // Assert
        Assertions.assertEquals(1, books.size());
        Assertions.assertEquals("Test Driven Development", books.get(0).getTitle());
    }

    @Test
    public void testGetBooksByTitle_TitleDoesNotExist_ReturnsEmptyList() {
        // Arrange
        FakeRepositoryForTest.booksList = new ArrayList<>();

        // Act
        List<Book> books = bookService.getBooksByTitle("Unknown Title");

        // Assert
        Assertions.assertTrue(books.isEmpty());
    }

    @Test
    public void testGetBooksByAuthorAndTitle_AuthorAndTitleExist_ReturnsMatchingBooks() {
        // Arrange
        FakeRepositoryForTest.booksList = new ArrayList<>();
        FakeRepositoryForTest.booksList.add(new Book("1", "Test Driven Development", "Kent Beck"));
        FakeRepositoryForTest.booksList.add(new Book("2", "Refactoring", "Martin Fowler"));

        // Act
        List<Book> books = bookService.getBooksByAuthorAndTitle("Kent Beck", "Test Driven Development");

        // Assert
        Assertions.assertEquals(1, books.size());
        Assertions.assertEquals("Test Driven Development", books.get(0).getTitle());
    }

    @Test
    public void testGetBooksByAuthorAndTitle_AuthorAndTitleDoNotExist_ReturnsEmptyList() {
        // Arrange
        FakeRepositoryForTest.booksList = new ArrayList<>();

        // Act
        List<Book> books = bookService.getBooksByAuthorAndTitle("Unknown Author", "Unknown Title");

        // Assert
        Assertions.assertTrue(books.isEmpty());
    }

    @Test
    public void testGetBooksByAuthorAndTitle_AuthorExistsButTitleDoesNotExist_ReturnsEmptyList() {
        // Arrange
        FakeRepositoryForTest.booksList = new ArrayList<>();
        FakeRepositoryForTest.booksList.add(new Book("1", "Refactoring", "Martin Fowler"));

        // Act
        List<Book> books = bookService.getBooksByAuthorAndTitle("Martin Fowler", "Unknown Title");

        // Assert
        Assertions.assertTrue(books.isEmpty());
    }

    @Test
    public void testGetBooksByAuthorAndTitle_AuthorDoesNotExist_ReturnsEmptyList() {
        // Arrange
        FakeRepositoryForTest.booksList = new ArrayList<>();
        FakeRepositoryForTest.booksList.add(new Book("1", "Refactoring", "Martin Fowler"));

        // Act
        List<Book> books = bookService.getBooksByAuthorAndTitle("Unknown Author", "Refactoring");

        // Assert
        Assertions.assertTrue(books.isEmpty());
    }
}

package com.example.tdd;

import java.util.Arrays;
import java.util.List;

public class FakeRepositoryForTest extends BookRepository implements IBookRepository {
    public static List<Book> booksList;

    @Override
    public List<Book> findAllBooks() {
        return booksList = Arrays.asList(
                new Book("1", "Test Driven Development", "Kent Beck"),
                new Book("2", "Clean Code", "Robert C. Martin"),
                new Book("3", "Effective Java", "Joshua Bloch"),
                new Book("4", "Refactoring", "Martin Fowler"),
                new Book("5", "Clean Architecture", "Robert C. Martin")
        );
    }

}
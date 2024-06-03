package com.example.tdd;

import java.util.List;
import java.util.stream.Collectors;

public class BookService {
    private IBookRepository bookRepository;

    public BookService(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooksByAuthor(String author) {
        if (author == null || author.isEmpty()) {
            return List.of();
        }
        return bookRepository.findAllBooks().stream()
                .filter(book -> author.equals(book.getAuthor()))
                .collect(Collectors.toList());
    }

    public List<Book> getBooksByTitle(String title) {
        if (title == null || title.isEmpty()) {
            return List.of();
        }
        return bookRepository.findAllBooks().stream()
                .filter(book -> title.equals(book.getTitle()))
                .collect(Collectors.toList());
    }

    public List<Book> getBooksByAuthorAndTitle(String author, String title) {
        if ((author == null || author.isEmpty()) && (title == null || title.isEmpty())) {
            return List.of();
        }
        return bookRepository.findAllBooks().stream()
                .filter(book -> (author == null || author.isEmpty() || author.equals(book.getAuthor())) &&
                        (title == null || title.isEmpty() || title.equals(book.getTitle())))
                .collect(Collectors.toList());
    }
}
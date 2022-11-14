package com.example.firstweb.service;


import com.example.firstweb.exception.NotFoundExcepiton;
import com.example.firstweb.model.Book;
import com.example.firstweb.repository.BookRepository;
import com.example.firstweb.request.UpsertBookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(int id) {
//        Optional <Book> bookOptional = bookRepository.findById(id);
//        if (bookOptional.isPresent()){
//            return  bookOptional.get();
//        }throw new NotFoundExcepiton("NOT FOUND BOOK WITH ID = " + id);
        return bookRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundExcepiton("NOT FOUND BOOK WITH ID = " + id);
        });
//
    }

    public Book createBook(UpsertBookRequest request) {
        Random rd = new Random();
        int id = rd.nextInt(1000);

        Book book = new Book(
                id,
                request.getTitle(),
                request.getDescription(),
                request.getPublishYear());

        bookRepository.save(book);
        return book;

    }
    // exception
    // Lambda expressiton
    // Stream
    // Functional Interface

    //Method Reference
    //Generic

    public Book updateBook(int id, UpsertBookRequest request) {
    Book book = bookRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundExcepiton("NOT FOUND BOOK WITH ID = " + id);
        });
    book.setTitle(request.getTitle());
    book.setDescription(request.getDescription());
    book.setPublishYear(request.getPublishYear());

    return  book;
    }

    public void deleteBook(int id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundExcepiton("NOT FOUND BOOK WITH ID = " + id);
        });
        bookRepository.delete(book);


    }
}

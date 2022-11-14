package com.example.firstweb.database;

import com.example.firstweb.model.Book;

import java.util.ArrayList;
import java.util.List;

public class FakeDB {
    public static List<Book> books = new ArrayList<>(List.of(
            new Book(1, "Book1", "Des1", 2022),
            new Book(2, "Book2", "Des2", 2021),
            new Book(3, "Book3", "Des3", 2020)
    ));
}
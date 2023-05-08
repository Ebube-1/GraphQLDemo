package com.example.springgraphql;

import lombok.Data;

import java.util.Arrays;
import java.util.List;
@Data
public class Book {
    private String id;
    private String name;
    private int pageCount;
    private String authorId;

    public Book(String id, String name, int pageCount, String authorId){
        this.authorId = authorId;
        this.name = name;
        this.id = id;
        this.pageCount = pageCount;
    }

    private static List<Book> bookList = Arrays.asList(
            new Book("book-1", "Harry Potter and the Philosopher's Stone", 223, "author-1"),
            new Book("book-2", "Moby Dick", 635, "author-2"),
            new Book("book-3", "Interview with the vampire", 371, "author-3")
    );

    public static Book getById(String id){
        return bookList.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst().orElse(null);
    }

}

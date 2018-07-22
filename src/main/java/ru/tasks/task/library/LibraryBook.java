package ru.tasks.task.library;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
public class LibraryBook {

    private String title;
    private int year;
    private List<String> authors;

    public LibraryBook(String title, int year, List<String> authors) {
        this.title = title;
        this.year = year;
        this.authors = authors;
    }

}
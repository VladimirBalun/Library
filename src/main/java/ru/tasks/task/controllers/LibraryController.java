package ru.tasks.task.controllers;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.tasks.task.library.Library;
import ru.tasks.task.library.LibraryBook;

import java.util.Arrays;
import java.util.List;

@Log4j
@RestController
public class LibraryController {

    @Autowired
    private Library library;

    @RequestMapping(value = "/library/getAllBooks", method = RequestMethod.GET)
    public List<LibraryBook> getAllBooks() {
        log.debug("Request[/library/getAllBooks] on getting all the books from library.");
        return library.getAllBooks();
    }

    @RequestMapping(value = "/library/getAllAuthors", method = RequestMethod.GET)
    public List<String> getAllAuthors() {
        log.debug("Request[/library/getAllAuthors] on getting all the authors from library.");
        return library.getAllAuthors();
    }

    @RequestMapping(value = "/library/addBook", method = RequestMethod.POST)
    public boolean addNewBook(@RequestParam(value = "title") String title,
                              @RequestParam(value = "year") String year,
                              @RequestParam(value = "authors[]") String[] authors) {
        log.debug("Request[/library/addBook] on adding book with parameters: " +
                  "[title] : [" + title + "], [year] : [" + year + "], [authors[]] : [" + Arrays.toString(authors) + "].");
        return library.addNewBook(new LibraryBook(title, Integer.valueOf(year), Arrays.asList(authors)));
    }

    @RequestMapping(value = "/library/changeBook", method = RequestMethod.PUT)
    public boolean changeBook(@RequestParam(value = "oldTitle") String oldTitle,
                              @RequestParam(value = "newTitle") String newTitle,
                              @RequestParam(value = "newYear") String newYear,
                              @RequestParam(value = "newAuthors[]") String[] newAuthors) {
        log.debug("Request[/library/addBook] on changing book with parameters: " +
                  "[oldTitle] : [" + oldTitle + "], [newTitle] : [" + newTitle +
                  "], [newYear] : [" + newYear + "], [newAuthors[]] ; [" + Arrays.toString(newAuthors) + "].");
        return library.changeBookByTitle(oldTitle, new LibraryBook(newTitle, Integer.valueOf(newYear), Arrays.asList(newAuthors)));
    }

    @RequestMapping(value = "/library/deleteBook", method = RequestMethod.DELETE)
    public boolean removeBook(@RequestBody String[] titles) {
        log.debug("Request[/library/deleteBook] on deleting book with parameters: " +
                  "[titles[]] : [" + Arrays.toString(titles) + "].");
        return library.removeBooksByTitle(Arrays.asList(titles));
    }

}
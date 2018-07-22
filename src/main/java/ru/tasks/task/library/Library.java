package ru.tasks.task.library;

import java.util.List;

public interface Library {

    List<LibraryBook> getAllBooks();

    List<String> getAllAuthors();

    boolean addNewBook(LibraryBook book);

    boolean changeBookByTitle(String titleBook, LibraryBook updatedBook);

    boolean removeBooksByTitle(List<String> bookTitles);

}
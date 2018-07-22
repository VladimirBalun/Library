package ru.tasks.task.data.service;

import java.util.List;

public interface BooksService {

    boolean isExistBook(String titleBook);

    boolean addNewBook(String titleBook, int publishingYear);

    boolean changeBookByTitle(String oldTitleBook, String newTitleBook, int newPublishingYear);

    boolean removeBooksByTitle(List<String> bookTitles);

}

package ru.tasks.task.data.service;

import ru.tasks.task.data.entity.Author;
import ru.tasks.task.library.LibraryBook;

import java.util.List;

public interface AuthorsWithBooksService {

    List<LibraryBook> getAllLibraryBooks();

    List<Author> getAuthorsByTitleBook(String titleBook);

    boolean addLinkAuthorWithBook(String nameAuthor, String titleBook);

    boolean removeLinkAuthorWithBook(String nameAuthor, String titleBook);

}
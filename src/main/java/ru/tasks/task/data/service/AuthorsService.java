package ru.tasks.task.data.service;

import java.util.List;

public interface AuthorsService {

    List<String> getAllAuthors();

    boolean isExistAuthor(String nameAuthor);

    boolean addNewAuthor(String nameAuthor);

    boolean removeAuthorByName(String nameAuthor);

}

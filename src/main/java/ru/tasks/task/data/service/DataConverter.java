package ru.tasks.task.data.service;

import ru.tasks.task.data.entity.Author;
import ru.tasks.task.data.entity.AuthorWithBook;

import java.util.ArrayList;
import java.util.List;

class DataConverter {

    static List<String> authorsToNameAuthors(List<Author> authors) {
        List<String> nameAuthors = new ArrayList<>();
        for (Author author : authors) {
            nameAuthors.add(author.getName());
        }
        return nameAuthors;
    }

    static List<String> authorsWithBooksToNameAuthors(List<AuthorWithBook> authorsWithBooks) {
        List<String> nameAuthors = new ArrayList<>(authorsWithBooks.size());
        for (AuthorWithBook authorWithBook : authorsWithBooks) {

            nameAuthors.add(authorWithBook.getAuthor().getName());
        }
        return nameAuthors;
    }

    static List<Author> authorsWithBooksToAuthors(List<AuthorWithBook> authorsWithBooks) {
        List<Author> authors = new ArrayList<>(authorsWithBooks.size());
        for (AuthorWithBook authorWithBook : authorsWithBooks) {
            authors.add(authorWithBook.getAuthor());
        }
        return authors;
    }

}
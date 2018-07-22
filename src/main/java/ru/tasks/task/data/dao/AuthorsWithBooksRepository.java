package ru.tasks.task.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tasks.task.data.entity.Author;
import ru.tasks.task.data.entity.AuthorWithBook;
import ru.tasks.task.data.entity.Book;

import java.util.List;

public interface AuthorsWithBooksRepository extends JpaRepository<AuthorWithBook, Long> {

    boolean existsByAuthorAndBook(Author author, Book book);

    void deleteByAuthorAndBook(Author author, Book book);

    List<AuthorWithBook> findByBook(Book book);

}

package ru.tasks.task.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tasks.task.data.entity.Book;

public interface BooksRepository extends JpaRepository<Book, Long> {

    boolean existsByTitle(String title);

    Book findByTitle(String title);

    void deleteByTitle(String title);

}

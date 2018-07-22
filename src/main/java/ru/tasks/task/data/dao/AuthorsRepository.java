package ru.tasks.task.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tasks.task.data.entity.Author;

public interface AuthorsRepository extends JpaRepository<Author, Long> {

    boolean existsByName(String name);

    Author findByName(String name);

    void deleteByName(String name);

}
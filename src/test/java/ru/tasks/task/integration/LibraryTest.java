package ru.tasks.task.integration;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ru.tasks.task.configuration.LibraryConfig;
import ru.tasks.task.configuration.DataConfig;
import ru.tasks.task.data.dao.AuthorsRepository;
import ru.tasks.task.data.dao.AuthorsWithBooksRepository;
import ru.tasks.task.data.dao.BooksRepository;
import ru.tasks.task.data.entity.Author;
import ru.tasks.task.data.entity.AuthorWithBook;
import ru.tasks.task.data.entity.Book;
import ru.tasks.task.library.Library;
import ru.tasks.task.library.LibraryBook;

import java.util.Arrays;
import java.util.Collections;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { LibraryConfig.class, DataConfig.class })
public class LibraryTest {

    @Autowired
    private Library library;

    @Autowired
    private AuthorsRepository authorsRepo;

    @Autowired
    private BooksRepository booksRepo;

    @Autowired
    private AuthorsWithBooksRepository authorsWithBooksRepo;

    private final String titleBook = "TestTitleOfBook";
    private final String nameAuthor1 = "TestNameOfAuthor1";
    private final String nameAuthor2 = "TestNameOfAuthor2";

    @Test
    @Rollback
    @Transactional
    public void addingNewBook() {
        library.addNewBook(new LibraryBook(titleBook, 2003, Arrays.asList(nameAuthor1, nameAuthor2)));

        if (!booksRepo.existsByTitle(titleBook)) {
            Assert.fail();
        }
        if (!authorsRepo.existsByName(nameAuthor1) && !authorsRepo.existsByName(nameAuthor2)) {
            Assert.fail();
        }

        Book book = booksRepo.findByTitle(titleBook);
        Author author1 = authorsRepo.findByName(nameAuthor1);
        Author author2 = authorsRepo.findByName(nameAuthor2);
        if (!authorsWithBooksRepo.existsByAuthorAndBook(author1, book) &&
                !authorsWithBooksRepo.existsByAuthorAndBook(author2, book)){
            Assert.fail();
        }
    }

    @Test
    @Rollback
    @Transactional
    public void deletingLibraryBook() {
        booksRepo.saveAndFlush(new Book(titleBook, 1990));
        authorsRepo.saveAndFlush(new Author(nameAuthor1));
        authorsRepo.saveAndFlush(new Author(nameAuthor2));
        Author author1 = authorsRepo.findByName(nameAuthor1);
        Author author2 = authorsRepo.findByName(nameAuthor2);
        Book book = booksRepo.findByTitle(titleBook);
        authorsWithBooksRepo.saveAndFlush(new AuthorWithBook(author1, book));
        authorsWithBooksRepo.saveAndFlush(new AuthorWithBook(author2, book));

        library.removeBooksByTitle(Collections.singletonList(titleBook));

        if (booksRepo.existsByTitle(titleBook)) {
            Assert.fail();
        }
        if (authorsRepo.existsByName(nameAuthor1) && authorsRepo.existsByName(nameAuthor2) ) {
            Assert.fail();
        }
        if (authorsWithBooksRepo.existsByAuthorAndBook(author1, book) &&
                authorsWithBooksRepo.existsByAuthorAndBook(author2, book)) {
            Assert.fail();
        }
    }

    @Test
    @Rollback
    @Transactional
    public void changingBook() {
        booksRepo.saveAndFlush(new Book(titleBook, 1990));
        authorsRepo.saveAndFlush(new Author(nameAuthor1));
        authorsRepo.saveAndFlush(new Author(nameAuthor2));
        Author author1 = authorsRepo.findByName(nameAuthor1);
        Author author2 = authorsRepo.findByName(nameAuthor2);
        Book book = booksRepo.findByTitle(titleBook);
        authorsWithBooksRepo.saveAndFlush(new AuthorWithBook(author1, book));
        authorsWithBooksRepo.saveAndFlush(new AuthorWithBook(author2, book));

        String newTitleBook = "NewTestTitleOfBook";
        String newNameAuthor = "NewTestNameOfAuthor";
        Author newAuthor = authorsRepo.findByName(newNameAuthor);
        Book newBook = booksRepo.findByTitle(newTitleBook);
        library.changeBookByTitle(titleBook, new LibraryBook(newTitleBook, 2000, Collections.singletonList(newNameAuthor)));

        if (booksRepo.existsByTitle(titleBook) && !booksRepo.existsByTitle(newTitleBook)) {
            Assert.fail();
        }
        if (authorsRepo.existsByName(nameAuthor1) &&
                authorsRepo.existsByName(nameAuthor2) &&
                !authorsRepo.existsByName(newNameAuthor)) {
            Assert.fail();
        }
        if (authorsWithBooksRepo.existsByAuthorAndBook(author1, book) &&
                authorsWithBooksRepo.existsByAuthorAndBook(author2, book) &&
                !authorsWithBooksRepo.existsByAuthorAndBook(newAuthor, newBook)) {
            Assert.fail();
        }
    }

}
package ru.tasks.task.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ru.tasks.task.configuration.DataConfig;
import ru.tasks.task.data.dao.AuthorsRepository;
import ru.tasks.task.data.dao.BooksRepository;
import ru.tasks.task.data.entity.Author;
import ru.tasks.task.data.entity.Book;
import ru.tasks.task.data.service.AuthorsWithBooksService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataConfig.class)
public class AuthorsWithBooksServiceTest {

    @Autowired
    private AuthorsWithBooksService authorsWithBooksService;

    @Autowired
    private AuthorsRepository authorsRepo;

    @Autowired
    private BooksRepository booksRepo;

    private final String nameAuthor = "TestNameOfAuthor";
    private final String titleBook = "TestTitleOfBook";

    @Test
    @Rollback
    @Transactional
    public void addingLinkBetweenBookAndAuthor() {
        authorsRepo.saveAndFlush(new Author(nameAuthor));
        booksRepo.saveAndFlush(new Book(titleBook, 2000));
        Assert.assertTrue(authorsWithBooksService.addLinkAuthorWithBook(nameAuthor, titleBook));
    }

    @Test
    @Rollback
    @Transactional
    public void addingLinkBetweenBookAndNonExistingAuthor() {
        booksRepo.saveAndFlush(new Book(titleBook, 2000));
        Assert.assertFalse(authorsWithBooksService.addLinkAuthorWithBook(nameAuthor, titleBook));
    }

    @Test
    @Rollback
    @Transactional
    public void addingLinkBetweenAuthorAndNonExistingBook() {
        authorsRepo.saveAndFlush(new Author(nameAuthor));
        Assert.assertFalse(authorsWithBooksService.addLinkAuthorWithBook(nameAuthor, titleBook));
    }

    @Test
    @Rollback
    @Transactional
    public void deletingLinkBetweenBookAndAuthor() {
        authorsRepo.saveAndFlush(new Author(nameAuthor));
        booksRepo.saveAndFlush(new Book(titleBook, 2000));
        Assert.assertTrue(authorsWithBooksService.removeLinkAuthorWithBook(nameAuthor, titleBook));
    }

}
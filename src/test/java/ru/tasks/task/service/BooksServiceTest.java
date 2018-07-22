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

import ru.tasks.task.data.dao.BooksRepository;
import ru.tasks.task.data.entity.Book;
import ru.tasks.task.data.service.BooksService;

import java.util.Arrays;
import java.util.Collections;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataConfig.class)
public class BooksServiceTest {

    @Autowired
    private BooksService booksService;

    @Autowired
    private BooksRepository booksRepo;

    private final String titleBook = "TestingTitleOfBook";

    @Test
    @Rollback
    @Transactional
    public void addingNewBook() {
        Assert.assertTrue(booksService.addNewBook(titleBook, 2010));
    }

    @Test
    @Rollback
    @Transactional
    public void addingNewBooksWithNonExistingPublishingYear() {
        Assert.assertFalse(booksService.addNewBook(titleBook, 2222));
    }

    @Test
    @Rollback
    @Transactional
    public void addingTheSameBooks() {
        booksRepo.saveAndFlush(new Book(titleBook, 2010));
        Assert.assertFalse(booksService.addNewBook(titleBook, 2015));
    }

    @Test
    @Rollback
    @Transactional
    public void deletingBook() {
        booksRepo.saveAndFlush(new Book(titleBook, 2010));
        Assert.assertTrue(booksService.removeBooksByTitle(Collections.singletonList(titleBook)));
    }

    @Test
    @Rollback
    @Transactional
    public void deletingNonExistingBooks() {
        Assert.assertFalse(booksService.removeBooksByTitle(Arrays.asList("NonExistingBook1", "NonExistingBook2")));
    }

    @Test
    @Rollback
    @Transactional
    public void deletingExistingAndNonExistingBooks() {
        booksRepo.saveAndFlush(new Book(titleBook, 2010));
        Assert.assertFalse(booksService.removeBooksByTitle(Arrays.asList(titleBook, "NonExistingBook")));
    }

    @Test
    @Rollback
    @Transactional
    public void changingBook() {
        booksRepo.saveAndFlush(new Book(titleBook, 1990));
        Assert.assertTrue(booksService.changeBookByTitle(titleBook, "NewTestTitleOfBook", 2000));
    }

}
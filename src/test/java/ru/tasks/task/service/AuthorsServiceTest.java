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
import ru.tasks.task.data.entity.Author;
import ru.tasks.task.data.service.AuthorsService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataConfig.class)
public class AuthorsServiceTest {

    @Autowired
    private AuthorsService authorsService;

    @Autowired
    private AuthorsRepository authorsRepository;

    private final String nameAuthor = "TestingNameOfAuthor";

    @Test
    @Rollback
    @Transactional
    public void addingNewAuthor() {
        Assert.assertTrue(authorsService.addNewAuthor(nameAuthor));
    }

    @Test
    @Rollback
    @Transactional
    public void addingTheSameAuthors() {
        authorsRepository.saveAndFlush(new Author(nameAuthor));
        Assert.assertFalse(authorsService.addNewAuthor(nameAuthor));
    }

    @Test
    @Rollback
    @Transactional
    public void deletingExistingAuthor() {
        authorsRepository.saveAndFlush(new Author(nameAuthor));
        Assert.assertTrue(authorsService.removeAuthorByName(nameAuthor));
    }

    @Test
    @Rollback
    @Transactional
    public void deletingNonExistingAuthor() {
        Assert.assertFalse(authorsService.removeAuthorByName("NonExistingNameUser4"));
    }

}
package ru.tasks.task.data.service;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tasks.task.data.dao.AuthorsRepository;
import ru.tasks.task.data.entity.Author;

import java.util.List;

@Log4j
@Service
public class AuthorsServiceImpl implements AuthorsService {

    @Autowired
    private AuthorsRepository authorsRepo;

    public List<String> getAllAuthors() {
        return DataConverter.authorsToNameAuthors(authorsRepo.findAll());
    }

    public boolean isExistAuthor(String nameAuthor) {
        return authorsRepo.existsByName(nameAuthor);
    }

    public boolean addNewAuthor(String nameAuthor) {
        try {
            authorsRepo.saveAndFlush(new Author(nameAuthor));
            return true;
        } catch (DataAccessException e) {
            log.warn(e.getMessage());
            return false;
        }
    }

    @Transactional
    public boolean removeAuthorByName(String nameAuthor) {
        if (!authorsRepo.existsByName(nameAuthor)) {
            return false;
        }

        try {
            authorsRepo.deleteByName(nameAuthor);
            return true;
        } catch (DataAccessException e) {
            log.warn(e.getMessage());
            return false;
        }
    }

}
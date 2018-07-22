package ru.tasks.task.data.service;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import ru.tasks.task.data.dao.BooksRepository;
import ru.tasks.task.data.entity.Book;

import java.time.Year;
import java.util.List;

@Log4j
@Service
public class BooksServiceImpl implements BooksService {

    @Autowired
    private BooksRepository booksRepo;

    public boolean isExistBook(String titleBook) {
        return booksRepo.existsByTitle(titleBook);
    }

    public boolean addNewBook(String titleBook, int publishingYear) {
        if (!isValidPublishingYear(publishingYear)) {
            return false;
        }
        try {
            booksRepo.saveAndFlush(new Book(titleBook, publishingYear));
            return true;
        } catch (DataAccessException e) {
            log.warn(e.getMessage());
            return false;
        }
    }

    @Transactional
    public boolean changeBookByTitle(String oldTitleBook, String newTitleBook, int newPublishingYear) {
        if (!isValidPublishingYear(newPublishingYear)) {
            return false;
        }

        try {
            Book book = booksRepo.findByTitle(oldTitleBook);
            book.setTitle(newTitleBook);
            book.setYear(newPublishingYear);
            booksRepo.save(book);
            return true;
        } catch (Exception e) {
            log.warn(e.getMessage());
            return false;
        }
    }

    private boolean isValidPublishingYear(int publishingYear) {
        return publishingYear <= Year.now().getValue() && publishingYear > 0;
    }

    @Transactional
    public boolean removeBooksByTitle(List<String> bookTitles) {
        try {
            for (String title : bookTitles) {
                if (!removeBook(title)) {
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return false;
                }
            }
            return true;
        } catch (DataAccessException e) {
            log.warn(e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }
    }

    private boolean removeBook(String titleBook) {
        if (booksRepo.existsByTitle(titleBook)) {
            booksRepo.deleteByTitle(titleBook);
            return true;
        } else {
            return false;
        }
    }

}
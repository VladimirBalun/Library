package ru.tasks.task.data.service;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tasks.task.data.dao.AuthorsRepository;
import ru.tasks.task.data.dao.AuthorsWithBooksRepository;
import ru.tasks.task.data.dao.BooksRepository;
import ru.tasks.task.data.entity.Author;
import ru.tasks.task.data.entity.AuthorWithBook;
import ru.tasks.task.data.entity.Book;
import ru.tasks.task.library.LibraryBook;

import java.util.ArrayList;
import java.util.List;

@Log4j
@Service
public class AuthorsWithBooksServiceImpl implements AuthorsWithBooksService {

    @Autowired
    private AuthorsRepository authorsRepo;

    @Autowired
    private BooksRepository booksRepo;

    @Autowired
    private AuthorsWithBooksRepository authorsWithBooksRepo;

    public List<LibraryBook> getAllLibraryBooks() {
        List<LibraryBook> libraryBooks = new ArrayList<>();
        for (Book book : booksRepo.findAll()) {
            List<AuthorWithBook> authorsWithBooks = authorsWithBooksRepo.findByBook(book);
            LibraryBook libraryBook = new LibraryBook(book.getTitle(), book.getYear(), DataConverter.authorsWithBooksToNameAuthors(authorsWithBooks));
            libraryBooks.add(libraryBook);
        }
        return libraryBooks;
    }


    public List<Author> getAuthorsByTitleBook(String titleBook) {
        Book book = booksRepo.findByTitle(titleBook);
        if (book != null) {
            List<AuthorWithBook> authorsWithBooks = authorsWithBooksRepo.findByBook(book);
            return DataConverter.authorsWithBooksToAuthors(authorsWithBooks);
        } else {
            return new ArrayList<>();
        }
    }

    public boolean addLinkAuthorWithBook(String nameAuthor, String titleBook) {
        try {
            Author author = authorsRepo.findByName(nameAuthor);
            Book book = booksRepo.findByTitle(titleBook);
            if (!authorsWithBooksRepo.existsByAuthorAndBook(author, book)) {
                authorsWithBooksRepo.saveAndFlush(new AuthorWithBook(author, book));
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            log.warn(e.getMessage());
            return false;
        }
    }

    public boolean removeLinkAuthorWithBook(String nameAuthor, String titleBook) {
        try {
            Author author = authorsRepo.findByName(nameAuthor);
            Book book = booksRepo.findByTitle(titleBook);
            authorsWithBooksRepo.deleteByAuthorAndBook(author, book);
            return true;
        } catch (Exception e) {
            log.warn(e.getMessage());
            return false;
        }
    }

}
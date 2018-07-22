package ru.tasks.task.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.tasks.task.data.entity.Author;
import ru.tasks.task.data.service.AuthorsService;
import ru.tasks.task.data.service.AuthorsWithBooksService;
import ru.tasks.task.data.service.BooksService;

import java.util.List;

@Component
public class LibraryImpl implements Library {

    @Autowired
    private BooksService booksService;

    @Autowired
    private AuthorsService authorsService;

    @Autowired
    private AuthorsWithBooksService authorsWithBooksService;

    public List<LibraryBook> getAllBooks() {
        return authorsWithBooksService.getAllLibraryBooks();
    }

    public List<String> getAllAuthors() {
        return authorsService.getAllAuthors();
    }

    @Transactional
    public boolean addNewBook(LibraryBook book) {
        if (book == null) {
            return false;
        } else if (!booksService.addNewBook(book.getTitle(), book.getYear())) {
            return false;
        } else {
            addNonExistingAuthors(book);
            return true;
        }
    }

    private void addNonExistingAuthors(LibraryBook book) {
        for (String author : book.getAuthors()) {
            if (!authorsService.isExistAuthor(author)) {
                authorsService.addNewAuthor(author);
            }
            authorsWithBooksService.addLinkAuthorWithBook(author, book.getTitle());
        }
    }

    @Transactional
    public boolean changeBookByTitle(String oldTitleBook, LibraryBook updatedBook) {
        if (updatedBook == null) {
            return false;
        } else if (booksService.isExistBook(updatedBook.getTitle())) {
            return false;
        }

        List<Author> oldAuthors = authorsWithBooksService.getAuthorsByTitleBook(oldTitleBook);
        if (!updatedBook.getAuthors().containsAll(oldAuthors)) {
            removeOldLinksAuthorsWithBook(oldAuthors, oldTitleBook);
        }
        booksService.changeBookByTitle(oldTitleBook, updatedBook.getTitle(), updatedBook.getYear());
        addNewLinksAuthorsWithBook(updatedBook);
        return true;
    }

    private void removeOldLinksAuthorsWithBook(List<Author> authors, String titleBook) {
        for (Author author : authors){
            authorsWithBooksService.removeLinkAuthorWithBook(author.getName(), titleBook);
        }
    }

    private void addNewLinksAuthorsWithBook(LibraryBook updatedBook) {
        for (String nameAuthor : updatedBook.getAuthors()) {
            if (!authorsService.isExistAuthor(nameAuthor)) {
                authorsService.addNewAuthor(nameAuthor);
            }
            authorsWithBooksService.addLinkAuthorWithBook(nameAuthor, updatedBook.getTitle());
        }
    }

    @Transactional // Authors without books remove with trigger
    public boolean removeBooksByTitle(List<String> bookTitles) {
        for (String titleBook : bookTitles) {
            for (Author author : authorsWithBooksService.getAuthorsByTitleBook(titleBook)) {
                authorsWithBooksService.removeLinkAuthorWithBook(author.getName(), titleBook);
            }
        }
        return booksService.removeBooksByTitle(bookTitles);
    }

}
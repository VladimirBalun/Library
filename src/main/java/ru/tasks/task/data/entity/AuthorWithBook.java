package ru.tasks.task.data.entity;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "authors_books")
public class AuthorWithBook {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_author", nullable = false)
    private Author author;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_book", nullable = false)
    private Book book;

    public AuthorWithBook() {}

    public AuthorWithBook(Author author, Book book) {
        this.author = author;
        this.book = book;
    }

}
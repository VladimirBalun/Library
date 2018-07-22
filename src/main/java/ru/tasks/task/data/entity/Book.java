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
@Table(name = "books")
public class Book {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private int id;

    @Column(name = "title", unique = true, length = 200, nullable = false)
    private String title;

    @Column(name = "year", nullable = false)
    private int year;

    public Book() {}

    public Book(String title, int year) {
        this.title = title;
        this.year = year;
    }

}
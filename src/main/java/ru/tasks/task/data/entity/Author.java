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
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @Column(name = "name", unique = true, length = 100, nullable = false)
    private String name;

    public Author() {}

    public Author(String name) {
        this.name = name;
    }

}
package ru.tasks.task.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.tasks.task.library.Library;
import ru.tasks.task.library.LibraryImpl;

@Configuration
@ComponentScan("ru.tasks.task.library")
public class LibraryConfig {

    @Bean
    public Library library() {
        return new LibraryImpl();
    }

}

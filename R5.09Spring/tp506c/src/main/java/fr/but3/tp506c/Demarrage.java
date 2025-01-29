package fr.but3.tp506c;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class Demarrage implements ApplicationRunner {
    @Autowired
    ApplicationContext context;


    @Autowired
    AuthorDAO daoAuthor;


    @Override
    public void run(ApplicationArguments args) throws Exception {

        daoAuthor.findAll().forEach(author -> {
            System.out.println(author.getName() + " " + author.getFirstname() + " " + author.getEmail() + " " + author.getIdauthor());

        });
        System.out.println("CEASAAAAAR !!! ;-;");
    }
}


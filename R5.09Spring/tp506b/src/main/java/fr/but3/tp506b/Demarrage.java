package fr.but3.tp506b;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Demarrage implements ApplicationRunner {
    @Autowired
    ApplicationContext context;
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DAOAuthor daoAuthor;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        int result = jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM author", Integer.class);
        for (String name : context.getBeanDefinitionNames()) {
            System.out.println(name);
        }
        List<Author> authors = daoAuthor.findAll();
        for (Author author : authors) {
            System.out.println(author.getIdauthor() + " " + author.getEmail() + " " + author.getFirstname() + " " + author.getName());
        }
        System.out.println("CEASAAAAAR !!! ;-;");
        System.out.println("Nombre d'auteurs : " + result);
    }
}
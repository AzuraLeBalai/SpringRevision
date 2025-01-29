package fr.but3.tp506d;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Demarrage implements ApplicationRunner {
    @Autowired
    ApplicationContext context;


    @Autowired
    AuthorDAO daoAuthor;
    @Autowired
    BookDAO daoBook;


    @Override
    public void run(ApplicationArguments args) throws Exception {

        daoAuthor.findAll().forEach(author -> {
            System.out.println(author.getName() + " " + author.getFirstname() + " " + author.getEmail() + " " + author.getIdAuthor());

        });
        daoBook.findAll().forEach(book -> {
            System.out.println(book.getTitle() + " " + book.getCategory() + " " + book.getLno() + " " + book.getAuthor().getName());
        });

        System.out.println("POLNAREEEEEF !!! ;-;");

        daoBook.findByTitleContainingOrderByLnoDesc("DE").forEach(book -> {
            System.out.println(book.getTitle() + " " + book.getCategory() + " " + book.getLno() + " " + book.getAuthor().getName());
        });

        System.out.println("CEASAAAAAR !!! ;-;");
    }
}

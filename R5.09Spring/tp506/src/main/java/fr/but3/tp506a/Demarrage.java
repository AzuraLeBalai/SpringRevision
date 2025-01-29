package fr.but3.tp506a;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Demarrage implements ApplicationRunner {
    @Autowired
    ApplicationContext context;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        for (String name : context.getBeanDefinitionNames()) {
            System.out.println(name);
        }
        System.out.println("CEASAAAAAR !!! ;-;");
    }
}

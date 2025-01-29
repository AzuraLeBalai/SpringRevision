package fr.but3.tp506a;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyOwnScheduling2 {
    @Scheduled(initialDelay=2000, fixedDelay=500)
    public void print() {
        System.out.println("POLNAREEEEF !!! ;-; ");
    }
}

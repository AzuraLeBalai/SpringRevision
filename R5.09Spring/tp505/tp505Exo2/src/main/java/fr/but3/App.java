package fr.but3;

import fr.but3.model.Author;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("pu");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        System.out.println( "Hello World!" );

        Author author = new Author();
        author.setName("Mathieu");
        author.setFirstname("Philipe");
        author.setEmail("pmathieu@univ-lille.fr");
        entityManager.getTransaction().begin();
        entityManager.persist(author);
        entityManager.getTransaction().commit();
        entityManagerFactory.close();
    }
}

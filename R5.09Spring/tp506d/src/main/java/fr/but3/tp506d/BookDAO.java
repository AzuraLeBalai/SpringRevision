package fr.but3.tp506d;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDAO extends CrudRepository<Book, Integer> {
    List<Book> findByTitleContainingOrderByLnoDesc(String title);
}

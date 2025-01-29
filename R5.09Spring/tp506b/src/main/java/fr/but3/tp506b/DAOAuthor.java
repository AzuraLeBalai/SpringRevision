package fr.but3.tp506b;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DAOAuthor {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Author> findAll() {
        return jdbcTemplate.query("select * from author", new AuthorRowMapper());
    }

    public int insert(Author author) {
        return jdbcTemplate.update("insert into author values(?, ?, ?, ?)",
                new Object[]{author.getIdauthor(), author.getEmail(), author.getFirstname(), author.getName()});
    }

    public int getCount() {
        return jdbcTemplate.queryForObject("select count(*) from author", Integer.class);
    }
}

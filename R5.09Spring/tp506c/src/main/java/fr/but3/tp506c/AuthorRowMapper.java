package fr.but3.tp506c;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

class AuthorRowMapper implements RowMapper<Author> {
    @Override
    public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
        Author Author = new Author();
        Author.setIdauthor(rs.getInt("idauthor"));
        Author.setEmail(rs.getString("email"));
        Author.setFirstname(rs.getString("firstname"));
        Author.setName(rs.getString("name"));
        return Author;
    }
}

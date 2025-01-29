package fr.but3.tp506d;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Entity
@Getter
@Setter
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAuthor;
    @Column(length = 20)
    private String name;
    private String firstname;
    private String email;
    @OneToMany(mappedBy = "author")
    private Collection<Book> books;

    @Override
    public String toString() {
        return "Author{" +
                "id=" + idAuthor +
                ", name='" + name + '\'' +
                ", firstname='" + firstname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}


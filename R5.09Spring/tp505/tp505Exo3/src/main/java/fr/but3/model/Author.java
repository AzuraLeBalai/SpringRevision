package fr.but3.model;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
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
    public int getId() {
        return idAuthor;
    }

    public void setId(int id) {
        this.idAuthor = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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

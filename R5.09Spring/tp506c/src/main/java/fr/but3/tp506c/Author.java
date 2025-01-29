package fr.but3.tp506c;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Author {
    @Id
    private int idauthor;
    private String email;
    private String firstname;
    private String name;

    public int getIdauthor() {
        return idauthor;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getName() {
        return name;
    }

    public void setIdauthor(int idauthor) {
        this.idauthor = idauthor;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setName(String name) {
        this.name = name;
    }
}

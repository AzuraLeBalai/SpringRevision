package fr.but3.tp506d;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int lno;
    String title;
    String category;
    @ManyToOne
    @JoinColumn(name = "ano")
    Author author;


    @Override
    public String toString() {
        return "Book{" +
                "lno=" + lno +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", author=" + author.toString() +
                '}';
    }
}


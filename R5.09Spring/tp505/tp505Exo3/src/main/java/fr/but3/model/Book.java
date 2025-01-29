package fr.but3.model;

import jakarta.persistence.*;
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int lno;
    String title;
    String category;
    @ManyToOne
    @JoinColumn(name = "ano")
    Author author;

    public int getLno() {
        return lno;
    }

    public void setLno(int lno) {
        this.lno = lno;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

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

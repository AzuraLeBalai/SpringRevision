package fr.but3.tp7a;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.springframework.context.annotation.Bean;

@Entity
@Data
@Getter
public class Etudiant {
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String prenom;
    String nom;
    int age;
    String groupe;

    public Etudiant(String prenom, String nom, int age, String groupe) {
        this.prenom = prenom;
        this.nom = nom;
        this.age = age;
        this.groupe = groupe;
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "id=" + id +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", age=" + age +
                ", groupe='" + groupe + '\'' +
                '}';
    }
}

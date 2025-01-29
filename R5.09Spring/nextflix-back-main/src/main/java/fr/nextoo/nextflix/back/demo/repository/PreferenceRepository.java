package fr.nextoo.nextflix.back.demo.repository;

import fr.nextoo.nextflix.back.demo.entities.Preference;
import fr.nextoo.nextflix.back.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PreferenceRepository extends JpaRepository<Preference, Integer> {

	List<Preference> findAllByUser(User user);

	List<Preference> findAllByUser_IdOrderByType(int id);

	List<Preference> findByUser_IdAndTypeEquals(int userId, String type);
}

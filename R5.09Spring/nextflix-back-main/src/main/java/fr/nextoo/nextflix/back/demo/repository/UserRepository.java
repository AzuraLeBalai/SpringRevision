package fr.nextoo.nextflix.back.demo.repository;

import fr.nextoo.nextflix.back.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUserName(String username);

	boolean existsByUserName(String username);

	boolean existsByUserNameAndPassword(String username, String password);

	Optional<User> findById(Integer id);
}

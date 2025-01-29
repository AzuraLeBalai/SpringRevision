package fr.nextoo.nextflix.back.demo.service;

import fr.nextoo.nextflix.back.demo.config.DataBase;
import fr.nextoo.nextflix.back.demo.entities.User;
import fr.nextoo.nextflix.back.demo.exeption.BadInputException;
import fr.nextoo.nextflix.back.demo.mapper.Mapper;
import fr.nextoo.nextflix.back.demo.model.UserModel;
import fr.nextoo.nextflix.back.demo.repository.UserRepository;
import fr.nextoo.nextflix.back.demo.service.interfaces.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService implements IUserService {
	private final UserRepository userRepository;
	private final Mapper mapper = new Mapper();
	private final DataBase dataBase;

	public UserService(UserRepository userRepository, DataBase dataBase) {
		this.userRepository = userRepository;
		this.dataBase = dataBase;
	}

	@Override
	public List<UserModel> getAllUser() {
		return userRepository.findAll()
				.stream()
				.map(mapper::userEntitieToModel)
				.toList();
	}

	@Override
	public void disconnectCurrentLogin() {
		this.dataBase.setCurrentIdSession(0);
	}

	@Override
	public UserModel getCurrentUser() {
		try {
			return mapper.userEntitieToModel(this.userRepository.findById(this.dataBase.getCurrentIdSession()).get());
		} catch (NoSuchElementException e) {
			throw new BadInputException("No current login present ", e);
		}
	}

	@Override
	public UserModel createUser(String userName) {
		if (this.userRepository.existsByUserName(userName)) {
			throw new BadInputException("Username already exists");
		}if (userName == null || userName.isEmpty()) {
			throw new BadInputException("Username is empty");
		}
		User user = new User();
		user.setUserName(userName);
		return mapper.userEntitieToModel(this.userRepository.save(user));
	}

	@Override
	public UserModel switchCurrentUserById(int id) {
		if (this.userRepository.existsById(id)) {
			this.dataBase.setCurrentIdSession(id);
		}else {
			throw new NoSuchElementException("No current login present for id " + id);
		}
		return mapper.userEntitieToModel(this.userRepository.findById(this.dataBase.getCurrentIdSession()).get());
	}
}

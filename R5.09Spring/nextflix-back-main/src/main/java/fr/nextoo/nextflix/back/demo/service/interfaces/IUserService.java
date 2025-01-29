package fr.nextoo.nextflix.back.demo.service.interfaces;

import fr.nextoo.nextflix.back.demo.model.UserModel;

import java.util.List;

public interface IUserService {
	List<UserModel> getAllUser();

	void disconnectCurrentLogin();

	UserModel getCurrentUser();

	UserModel createUser(String user);

	UserModel switchCurrentUserById(int id);
}

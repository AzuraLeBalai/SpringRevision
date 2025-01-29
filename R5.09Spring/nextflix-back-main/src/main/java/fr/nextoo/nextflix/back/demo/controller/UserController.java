package fr.nextoo.nextflix.back.demo.controller;

import fr.nextoo.nextflix.back.demo.entities.exit.UserExitDTO;
import fr.nextoo.nextflix.back.demo.exeption.BadInputException;
import fr.nextoo.nextflix.back.demo.mapper.Mapper;
import fr.nextoo.nextflix.back.demo.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {

	private final IUserService userService;
	private final Mapper mapper = new Mapper();

	public UserController(@Qualifier("userService") final IUserService userService) {
		this.userService = userService;
	}

	@GetMapping("/all")
	public ResponseEntity<List<UserExitDTO>> getAllSport() throws BadInputException {
		return ResponseEntity.ok(this.userService.getAllUser().stream().map(mapper::userModelToUserExitDTO).toList());
	}

	@PutMapping("/login")
	public ResponseEntity<UserExitDTO> login(@RequestParam int userId) throws BadInputException {
		return ResponseEntity.ok(mapper.userModelToUserExitDTO(this.userService.switchCurrentUserById(userId)));
	}

	@GetMapping("/disconnect")
	public void disconnect() {
		this.userService.disconnectCurrentLogin();
	}

	@GetMapping("/current-login")
	public ResponseEntity<UserExitDTO> getCurrentUser() {
		return ResponseEntity.ok(mapper.userModelToUserExitDTO(this.userService.getCurrentUser()));
	}

	@PostMapping("/create-user")
	public ResponseEntity<UserExitDTO> createUser(@RequestParam String username) throws BadInputException {
		return ResponseEntity.ok(mapper.userModelToUserExitDTO(this.userService.createUser(username)));
	}
}

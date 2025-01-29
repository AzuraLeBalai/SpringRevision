package fr.nextoo.nextflix.back.demo.controller;

import fr.nextoo.nextflix.back.demo.config.DataBase;
import fr.nextoo.nextflix.back.demo.entities.DTO.NewPreferenceList;
import fr.nextoo.nextflix.back.demo.entities.exit.PreferencesExitDTO;
import fr.nextoo.nextflix.back.demo.exeption.BadInputException;
import fr.nextoo.nextflix.back.demo.mapper.Mapper;
import fr.nextoo.nextflix.back.demo.model.PreferenceModel;
import fr.nextoo.nextflix.back.demo.service.interfaces.IPreferenceService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/preference")
public class PreferenceController {

	private final IPreferenceService preferenceService;
	private final Mapper mapper = new Mapper();
	private final DataBase database;

	public PreferenceController(@Qualifier("preferenceService") final IPreferenceService preferenceService, DataBase database) {
		this.preferenceService = preferenceService;
		this.database = database;
	}

	@PutMapping("/modifier-preference")
	public ResponseEntity<List<PreferencesExitDTO>> updatePreferenceList(@RequestBody NewPreferenceList preferenceList) throws BadInputException {
		List<PreferenceModel> preferenceModelList = mapper.newPreferenceToPreferenceModelList(preferenceList);
		return ResponseEntity.ok(this.preferenceService.updatePreferenceList(preferenceModelList)
				.stream()
				.map(mapper::preferenceModelToPreferenceExitDTO)
				.toList());
	}

	@PostMapping("/skip-movie")
	public ResponseEntity<PreferenceModel> skipFilm(@RequestParam int movieId) throws BadInputException {
		return ResponseEntity.ok(this.preferenceService.postWithoutMovie(movieId));
	}
}

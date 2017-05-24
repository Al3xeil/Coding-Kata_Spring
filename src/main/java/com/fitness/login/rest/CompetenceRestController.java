package com.fitness.login.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fitness.login.model.competence.Competence;
import com.fitness.login.model.dtos.CompetenceCategoryDTO;
import com.fitness.login.model.dtos.CompetenceStatusDTO;
import com.fitness.login.model.dtos.CompetenceTypeDTO;
import com.fitness.login.service.CompetenceService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/competence")
public class CompetenceRestController {

	@Autowired
	private CompetenceService competenceService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Competence getCompentenceDetail(@PathVariable("id") int competenceId) {
		Competence competence = competenceService.getCompetenceById(competenceId);
		if (competence == null) {
			return null;
		}
		return competence;
	}

	@RequestMapping(value = "/type", method = RequestMethod.GET)
	public Resources<?> getAllCompentenceType() {
		List<CompetenceTypeDTO> allType = competenceService.getAllTypes().stream().map(CompetenceTypeDTO::new)
				.collect(Collectors.toList());
		return new Resources<>(allType);
	}

	@RequestMapping(value = "/status", method = RequestMethod.GET)
	public Resources<?> getAllCompentenceStatus() {
		List<CompetenceStatusDTO> allStatus = competenceService.getAllStatus().stream().map(CompetenceStatusDTO::new)
				.collect(Collectors.toList());
		return new Resources<>(allStatus);
	}

	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public Resources<?> getAllCompentenceCategory() {
		List<CompetenceCategoryDTO> allCategory = competenceService.getAllCategories().stream()
				.map(CompetenceCategoryDTO::new).collect(Collectors.toList());
		return new Resources<>(allCategory);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public Resources<?> getAllCompetences() {
		List<Competence> allCompetences = competenceService.getAllCompetence();
		// User loggedInUser = securityService.findLoggedInUser();
		return new Resources<>(allCompetences);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Competence updateCompetence(@RequestBody Competence competence) {
		if (competence.getId() == null) {
			return null;
		}
		competenceService.save(competence);

		return competence;
	}

}

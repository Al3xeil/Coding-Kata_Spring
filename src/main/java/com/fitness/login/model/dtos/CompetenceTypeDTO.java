package com.fitness.login.model.dtos;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fitness.login.model.competence.CompetenceType;
import com.fitness.login.model.user.User;

public class CompetenceTypeDTO extends ResourceSupport {

	private final CompetenceType competenceType;

	@JsonCreator
	public CompetenceTypeDTO(@JsonProperty("competenceType") CompetenceType competenceType) {
		this.competenceType = competenceType;
	}

	public CompetenceType getCompetenceType() {
		return competenceType;
	}

}

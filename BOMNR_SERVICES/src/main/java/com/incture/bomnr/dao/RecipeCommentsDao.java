package com.incture.bomnr.dao;

import org.springframework.stereotype.Repository;

import com.incture.bomnr.dto.RecipeCommentsDto;

import com.incture.bomnr.entity.RecipeCommentsDo;

@Repository("recipecommentsDao")
public class RecipeCommentsDao {

	public RecipeCommentsDo importDto(RecipeCommentsDto recipeCommentsDto) {
		RecipeCommentsDo recipeCommentsDo = new RecipeCommentsDo();

		recipeCommentsDo.setRComSNumber(recipeCommentsDto.getrComSNumber());
		recipeCommentsDo.setrComCreatedBy(recipeCommentsDto.getrComCreatedBy());
		recipeCommentsDo.setrComCreatedOn(recipeCommentsDto.getrComCreatedOn());
		recipeCommentsDo.setrComComment(recipeCommentsDto.getrComComment());
		return recipeCommentsDo;

	}

	public RecipeCommentsDto exportDto(RecipeCommentsDo recipeCommentsDo) {
		RecipeCommentsDto recipeCommentsDto = new RecipeCommentsDto();
		recipeCommentsDto.setrComSNumber(recipeCommentsDo.getRComSNumber());
		recipeCommentsDto.setrComCreatedBy(recipeCommentsDo.getrComCreatedBy());
		recipeCommentsDto.setrComCreatedOn(recipeCommentsDo.getrComCreatedOn());
		recipeCommentsDto.setrComComment(recipeCommentsDo.getrComComment());
		return recipeCommentsDto;

	}

}
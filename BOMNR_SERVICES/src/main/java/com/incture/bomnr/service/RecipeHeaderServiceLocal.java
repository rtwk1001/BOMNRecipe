package com.incture.bomnr.service;

import java.util.List;

import com.incture.bomnr.dto.BaseDto;

import com.incture.bomnr.dto.RecipeHeaderDto;
import com.incture.bomnr.dto.ResponseDto;

public interface RecipeHeaderServiceLocal {
	ResponseDto createRecipe(RecipeHeaderDto Dto);

	BaseDto findById(String requestNo);

	ResponseDto deleteRecipe(String requestNo);

	List<RecipeHeaderDto> findAllRecipies();

	ResponseDto updateRecipe(RecipeHeaderDto Dto);
}

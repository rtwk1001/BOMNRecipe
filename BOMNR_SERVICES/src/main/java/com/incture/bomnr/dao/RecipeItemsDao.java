package com.incture.bomnr.dao;

import org.springframework.stereotype.Repository;

import com.incture.bomnr.dto.RecipeItemsDto;
import com.incture.bomnr.entity.RecipeHeaderDo;
import com.incture.bomnr.entity.RecipeItemsDo;
@Repository("recipeitemsDao")
public class RecipeItemsDao  {
	private RecipeItemsDo recipeItemsDo;
	private RecipeItemsDto recipeItemsDto;

	protected RecipeItemsDo importDto(RecipeItemsDto recipeItemsDto,RecipeHeaderDo recipeHeaderDo) {

		recipeItemsDo = new RecipeItemsDo();
		recipeItemsDo.setRecipeSNumber(recipeItemsDto.getRecipeSNumber());
		recipeItemsDo.setRecipeResource(recipeItemsDto.getRecipeResource());
		recipeItemsDo.setRecipeResourceDes(recipeItemsDto.getRecipeResourceDes());
		recipeItemsDo.setRecipeQty(recipeItemsDto.getRecipeQty());
		recipeItemsDo.setRecipeUom(recipeItemsDto.getRecipeUom());
		recipeItemsDo.setRecipeOperationDes(recipeItemsDto.getRecipeOperationDes());
		recipeItemsDo.setRecipeStd1(recipeItemsDto.getRecipeStd1());
		recipeItemsDo.setRecipeStd2(recipeItemsDto.getRecipeStd2());
		recipeItemsDo.setRecipeStd3(recipeItemsDto.getRecipeStd3());
		recipeItemsDo.setRecipeStd4(recipeItemsDto.getRecipeStd4());
		recipeItemsDo.setRecipeStd5(recipeItemsDto.getRecipeStd5());
		recipeItemsDo.setRecipeStd6(recipeItemsDto.getRecipeStd6());
		//recipeItemsDo.setRheader(recipeHeaderDo);

		return recipeItemsDo;

	}

	protected RecipeItemsDto exportDto(RecipeItemsDo recipeItemsDo) {
		recipeItemsDto = new RecipeItemsDto();
		recipeItemsDto.setRecipeSNumber(recipeItemsDo.getRecipeSNumber());
		recipeItemsDto.setRecipeResource(recipeItemsDo.getRecipeResource());
		recipeItemsDto.setRecipeResourceDes(recipeItemsDo.getRecipeResourceDes());
		recipeItemsDto.setRecipeQty(recipeItemsDo.getRecipeQty());
		recipeItemsDto.setRecipeUom(recipeItemsDo.getRecipeUom());
		recipeItemsDto.setRecipeOperationDes(recipeItemsDo.getRecipeOperationDes());
		recipeItemsDto.setRecipeStd1(recipeItemsDo.getRecipeStd1());
		recipeItemsDto.setRecipeStd2(recipeItemsDo.getRecipeStd2());
		recipeItemsDto.setRecipeStd3(recipeItemsDo.getRecipeStd3());
		recipeItemsDto.setRecipeStd4(recipeItemsDo.getRecipeStd4());
		recipeItemsDto.setRecipeStd5(recipeItemsDo.getRecipeStd5());
		recipeItemsDto.setRecipeStd6(recipeItemsDo.getRecipeStd6());

		return recipeItemsDto;

	}

}

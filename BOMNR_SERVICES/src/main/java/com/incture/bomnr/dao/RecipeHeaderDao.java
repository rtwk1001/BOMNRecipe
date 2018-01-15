package com.incture.bomnr.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.incture.bomnr.dto.RecipeCommentsDto;
import com.incture.bomnr.dto.RecipeHeaderDto;
import com.incture.bomnr.dto.RecipeItemsDto;

import com.incture.bomnr.entity.RecipeCommentsDo;
import com.incture.bomnr.entity.RecipeHeaderDo;
import com.incture.bomnr.entity.RecipeItemsDo;

@Repository("recipeheaderdao")
public class RecipeHeaderDao extends BaseDao<RecipeHeaderDo, RecipeHeaderDto> {

	public RecipeHeaderDo importDto(RecipeHeaderDto recipeHeaderDto) {
		RecipeHeaderDo recipeHeaderDo = new RecipeHeaderDo();

		recipeHeaderDo = new RecipeHeaderDo();
		recipeHeaderDo.setRequestNo(recipeHeaderDto.getRequestNo());
		recipeHeaderDo.setRecipeAltBOM(recipeHeaderDto.getRecipeAltBOM());
		recipeHeaderDo.setRecipeAltText(recipeHeaderDto.getRecipeAltText());
		recipeHeaderDo.setRecipeBaseQty(recipeHeaderDto.getRecipeBaseQty());
		recipeHeaderDo.setRecipeBaseUom(recipeHeaderDto.getRecipeBaseUom());
		recipeHeaderDo.setRecipeMaterialCode(recipeHeaderDto.getRecipeMaterialCode());
		recipeHeaderDo.setRecipePlantCode(recipeHeaderDto.getRecipePlantCode());
		recipeHeaderDo.setRecipeRefAltBOM(recipeHeaderDto.getRecipeAltBOM());
		recipeHeaderDo.setRecipeRefMaterialCode(recipeHeaderDto.getRecipeRefMaterialCode());
		if (recipeHeaderDto.getComments() != null) {
			List<RecipeCommentsDo> comList = new ArrayList<RecipeCommentsDo>();
			RecipeCommentsDao comdao = new RecipeCommentsDao();
			for (RecipeCommentsDto recipeCommentsDto : recipeHeaderDto.getComments()) {
				comList.add(comdao.importDto(recipeCommentsDto));
			}
			recipeHeaderDo.setComments(comList);
		}
		if (recipeHeaderDto.getItems() != null) {
			List<RecipeItemsDo> itemList = new ArrayList<RecipeItemsDo>();
			RecipeItemsDao itemdao = new RecipeItemsDao();
			for (RecipeItemsDto recipeItemsDto : recipeHeaderDto.getItems()) {
				itemList.add(itemdao.importDto(recipeItemsDto, recipeHeaderDo));
			}
			recipeHeaderDo.setItems(itemList);
		}

		return recipeHeaderDo;

	}

	public RecipeHeaderDto exportDto(RecipeHeaderDo recipeHeaderDo) {
		RecipeHeaderDto recipeHeaderDto = new RecipeHeaderDto();
		recipeHeaderDto.setRequestNo(recipeHeaderDo.getRequestNo());
		recipeHeaderDto.setRecipeAltBOM(recipeHeaderDo.getRecipeAltBOM());
		recipeHeaderDto.setRecipeAltText(recipeHeaderDo.getRecipeAltText());
		recipeHeaderDto.setRecipeBaseQty(recipeHeaderDo.getRecipeBaseQty());
		recipeHeaderDto.setRecipeBaseUom(recipeHeaderDo.getRecipeBaseUom());
		recipeHeaderDto.setRecipeMaterialCode(recipeHeaderDo.getRecipeMaterialCode());
		recipeHeaderDto.setRecipePlantCode(recipeHeaderDo.getRecipePlantCode());
		recipeHeaderDto.setRecipeRefAltBOM(recipeHeaderDo.getRecipeAltBOM());
		recipeHeaderDto.setRecipeRefMaterialCode(recipeHeaderDo.getRecipeRefMaterialCode());
		if (recipeHeaderDo.getComments() != null) {
			List<RecipeCommentsDto> comList = new ArrayList<RecipeCommentsDto>();
			RecipeCommentsDao comdao = new RecipeCommentsDao();
			for (RecipeCommentsDo recipeCommentsDo : recipeHeaderDo.getComments()) {
				comList.add(comdao.exportDto(recipeCommentsDo));
			}
			recipeHeaderDto.setComments(comList);
		}
		if (recipeHeaderDo.getItems() != null) {
			List<RecipeItemsDto> itemList = new ArrayList<RecipeItemsDto>();
			RecipeItemsDao itemdao = new RecipeItemsDao();
			for (RecipeItemsDo bomItemsDo : recipeHeaderDo.getItems()) {
				itemList.add(itemdao.exportDto(bomItemsDo));
			}
			recipeHeaderDto.setItems(itemList);
		}

		return recipeHeaderDto;

	}

}

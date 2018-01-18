package com.incture.bomnr.dto;

import com.incture.bomnr.entity.BomHeaderDo;
import com.incture.bomnr.exceptions.InvalidInputFault;
import com.incture.bomnr.util.BOMNROperation;

public class RecipeItemsDto extends BaseDto {
	private int recipeSNumber;
	private String recipeResource;
	private String recipeResourceDes;
	private String recipeQty;
	private String recipeUom;
	private String recipeOperationDes;
	private String recipeStd1;
	private String recipeStd2;
	private String recipeStd3;
	private String recipeStd4;
	private String recipeStd5;
	private String recipeStd6;
	private BomHeaderDo rheader;

	public int getRecipeSNumber() {
		return recipeSNumber;
	}

	public void setRecipeSNumber(int recipeSNumber) {
		this.recipeSNumber = recipeSNumber;
	}

	public String getRecipeResource() {
		return recipeResource;
	}

	public void setRecipeResource(String recipeResource) {
		this.recipeResource = recipeResource;
	}

	public String getRecipeResourceDes() {
		return recipeResourceDes;
	}

	public void setRecipeResourceDes(String recipeResourceDes) {
		this.recipeResourceDes = recipeResourceDes;
	}

	public String getRecipeQty() {
		return recipeQty;
	}

	public void setRecipeQty(String recipeQty) {
		this.recipeQty = recipeQty;
	}

	public String getRecipeUom() {
		return recipeUom;
	}

	public void setRecipeUom(String recipeUom) {
		this.recipeUom = recipeUom;
	}

	public String getRecipeOperationDes() {
		return recipeOperationDes;
	}

	public void setRecipeOperationDes(String recipeOperationDes) {
		this.recipeOperationDes = recipeOperationDes;
	}

	public String getRecipeStd1() {
		return recipeStd1;
	}

	public void setRecipeStd1(String recipeStd1) {
		this.recipeStd1 = recipeStd1;
	}

	public String getRecipeStd2() {
		return recipeStd2;
	}

	public void setRecipeStd2(String recipeStd2) {
		this.recipeStd2 = recipeStd2;
	}

	public String getRecipeStd3() {
		return recipeStd3;
	}

	public void setRecipeStd3(String recipeStd3) {
		this.recipeStd3 = recipeStd3;
	}

	public String getRecipeStd4() {
		return recipeStd4;
	}

	public void setRecipeStd4(String recipeStd4) {
		this.recipeStd4 = recipeStd4;
	}

	public String getRecipeStd5() {
		return recipeStd5;
	}

	public void setRecipeStd5(String recipeStd5) {
		this.recipeStd5 = recipeStd5;
	}

	public String getRecipeStd6() {
		return recipeStd6;
	}

	public void setRecipeStd6(String recipeStd6) {
		this.recipeStd6 = recipeStd6;
	}

	public BomHeaderDo getRheader() {
		return rheader;
	}

	public void setRheader(BomHeaderDo rheader) {
		this.rheader = rheader;
	}

	@Override
	public void validate(BOMNROperation enOperation) throws InvalidInputFault {
		 recipeResource = checkStringSize("RecipeItems.RecipeResource",  recipeResource, 18);
		 recipeResourceDes = checkStringSize("RecipeItems.RecipeResourceDes",recipeResourceDes, 18);
	 recipeQty = checkStringSize("RecipeItems.recipeQty", recipeQty , 18);
		 recipeUom = checkStringSize("RecipeItems.recipeUom", recipeUom, 18);
		recipeOperationDes = checkStringSize("RecipeItems.recipeOperationDes",	recipeOperationDes, 18);
		 recipeStd1 = checkStringSize("RecipeItems.recipeStd1", recipeStd1, 18);
		recipeStd2 = checkStringSize("RecipeItems.recipeStd2", recipeStd2 , 18);
		 recipeStd3 = checkStringSize("RecipeItems.recipeStd3", recipeStd3, 18);
		 recipeStd4 = checkStringSize("RecipeItems.recipeStd4", recipeStd4, 18);
		recipeStd5 = checkStringSize("RecipeItems.recipeStd5", recipeStd5, 18);
		 recipeStd6 = checkStringSize("RecipeItems.recipeStd6", recipeStd6, 18);

	}

}

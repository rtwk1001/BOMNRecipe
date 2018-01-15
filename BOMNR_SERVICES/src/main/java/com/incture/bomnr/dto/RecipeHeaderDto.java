package com.incture.bomnr.dto;

import java.util.List;

public class RecipeHeaderDto extends BaseDto {

	private String requestNo;
	private String recipeRefMaterialCode;
	private String recipeRefAltBOM;
	private String recipeMaterialCode;
	private String recipeBaseQty;
	private String recipeBaseUom;
	private String recipePlantCode;
	private String recipeAltBOM;
	private String recipeAltText;
	private List<RecipeItemsDto> items;
	private List<RecipeCommentsDto> comments;
	public String getRequestNo() {
		return requestNo;
	}
	public void setRequestNo(String requestNo) {
		this.requestNo = requestNo;
	}
	public String getRecipeRefMaterialCode() {
		return recipeRefMaterialCode;
	}
	public void setRecipeRefMaterialCode(String recipeRefMaterialCode) {
		this.recipeRefMaterialCode = recipeRefMaterialCode;
	}
	public String getRecipeRefAltBOM() {
		return recipeRefAltBOM;
	}
	public void setRecipeRefAltBOM(String recipeRefAltBOM) {
		this.recipeRefAltBOM = recipeRefAltBOM;
	}
	public String getRecipeMaterialCode() {
		return recipeMaterialCode;
	}
	public void setRecipeMaterialCode(String recipeMaterialCode) {
		this.recipeMaterialCode = recipeMaterialCode;
	}
	public String getRecipeBaseQty() {
		return recipeBaseQty;
	}
	public void setRecipeBaseQty(String recipeBaseQty) {
		this.recipeBaseQty = recipeBaseQty;
	}
	public String getRecipeBaseUom() {
		return recipeBaseUom;
	}
	public void setRecipeBaseUom(String recipeBaseUom) {
		this.recipeBaseUom = recipeBaseUom;
	}
	public String getRecipePlantCode() {
		return recipePlantCode;
	}
	public void setRecipePlantCode(String recipePlantCode) {
		this.recipePlantCode = recipePlantCode;
	}
	public String getRecipeAltBOM() {
		return recipeAltBOM;
	}
	public void setRecipeAltBOM(String recipeAltBOM) {
		this.recipeAltBOM = recipeAltBOM;
	}
	public String getRecipeAltText() {
		return recipeAltText;
	}
	public void setRecipeAltText(String recipeAltText) {
		this.recipeAltText = recipeAltText;
	}
	public List<RecipeItemsDto> getItems() {
		return items;
	}
	public void setItems(List<RecipeItemsDto> items) {
		this.items = items;
	}
	public List<RecipeCommentsDto> getComments() {
		return comments;
	}
	public void setComments(List<RecipeCommentsDto> comments) {
		this.comments = comments;
	}
}

package com.incture.bomnr.dto;

import java.util.Date;
import java.util.List;



import com.incture.bomnr.exceptions.InvalidInputFault;
import com.incture.bomnr.util.BOMNROperation;

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

	private Date recipeCreatedOn;
	private String recipeCreatedBy;
	private Date recipeUpdatedOn;
	private String recipeUpdateddBy;

	public Date getRecipeCreatedOn() {
		return recipeCreatedOn;
	}

	public void setRecipeCreatedOn(Date recipeCreatedOn) {
		this.recipeCreatedOn = recipeCreatedOn;
	}

	public String getRecipeCreatedBy() {
		return recipeCreatedBy;
	}

	public void setRecipeCreatedBy(String recipeCreatedBy) {
		this.recipeCreatedBy = recipeCreatedBy;
	}

	public Date getRecipeUpdatedOn() {
		return recipeUpdatedOn;
	}

	public void setRecipeUpdatedOn(Date recipeUpdatedOn) {
		this.recipeUpdatedOn = recipeUpdatedOn;
	}

	public String getRecipeUpdateddBy() {
		return recipeUpdateddBy;
	}

	public void setRecipeUpdateddBy(String recipeUpdateddBy) {
		this.recipeUpdateddBy = recipeUpdateddBy;
	}

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

	@Override
	public void validate(BOMNROperation operation) throws InvalidInputFault {
		if (operation != BOMNROperation.RETRIVE) {
			enforceMandatory("RecipeHeader.requestNo", requestNo);
		}
		recipeAltBOM = checkStringSize("RecipeHeader.AltBom", recipeAltBOM, 18);
		recipeAltText = checkStringSize("RecipeHeader.AltText", recipeAltText, 18);
		recipeBaseQty = checkStringSize("RecipeHeader.BaseQantity", recipeBaseQty, 18);

		recipeBaseUom = checkStringSize("BomHeader.BaseUOM", recipeBaseUom, 18);

		recipeMaterialCode = checkStringSize("BomHeader.recipeMaterialCode", recipeMaterialCode, 18);

		recipePlantCode = checkStringSize("BomHeader.recipePlantCode", recipePlantCode, 18);

		recipeRefAltBOM = checkStringSize("BomHeader.recipeRefALtBOM", recipeRefAltBOM, 18);

		recipeRefMaterialCode = checkStringSize("BomHeader.recipeRefMaterialCode", recipeRefMaterialCode, 18);
		if (comments != null) {
			for (RecipeCommentsDto com : comments)

				com.validate(operation);

		}

		if (items != null) {
			for (RecipeItemsDto item : items)

				item.validate(operation);

		}

	}
}

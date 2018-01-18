package com.incture.bomnr.entity;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "RECIPE_HEADER")
public class RecipeHeaderDo implements BaseDo {
	// primary key and auto generated

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "REQUEST_NO", length = 40, nullable = true)
	private String requestNo;

	// when using with reference these fields will be included.
	@Column(name = "REF_MATERIAL_CODE", nullable = true)
	private String recipeRefMaterialCode;
	@Column(name = "REF_ALTBOM", nullable = true)
	private String recipeRefAltBOM;
	// recipe material code
	@Column(name = "MATERIAL_CODE", nullable = true)
	private String recipeMaterialCode;
	// recipe Base Quantity
	@Column(name = "BASE_QTY", nullable = true)
	private String recipeBaseQty;
	// recipe Base Uom
	@Column(name = "BASE_UOM", nullable = true)
	private String recipeBaseUom;
	// recipe Plant Code
	@Column(name = "PLANT_CODE", nullable = true)
	private String recipePlantCode;
	// Alternate recipe
	@Column(name = "ALT_BOM", nullable = true)
	private String recipeAltBOM;
	// alternate text
	@Column(name = "ALT_TEXT", nullable = true)
	private String recipeAltText;
	@Column(name = "CREATED_On", nullable = true)
	private Date recipeCreatedOn;
	@Column(name = "CREATED_BY", nullable = true)
	private String recipeCreatedBy;
	@Column(name = "UPDATED_On", nullable = true)
	private Date recipeUpdatedOn;
	@Column(name = "UPDATED_BY", nullable = true)
	private String recipeUpdateddBy;

	@OneToMany(targetEntity = RecipeItemsDo.class,  fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<RecipeItemsDo> items;

	@OneToMany(targetEntity = RecipeCommentsDo.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<RecipeCommentsDo> comments;

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

	public List<RecipeItemsDo> getItems() {
		return items;
	}

	public void setItems(List<RecipeItemsDo> items) {
		this.items = items;
	}

	public List<RecipeCommentsDo> getComments() {
		return comments;
	}

	public void setComments(List<RecipeCommentsDo> comments) {
		this.comments = comments;
	}

	public Object getPrimaryKey() {
		// TODO Auto-generated method stub
		return requestNo;
	}

}

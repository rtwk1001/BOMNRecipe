package com.incture.bomnr.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "RECIPE_ITEMS")
public class RecipeItemsDo implements BaseDo {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "SL_NUMBER", nullable = false)

	@GeneratedValue(strategy = GenerationType.TABLE, generator = "ritem_generator")
	@TableGenerator(name = "ritem_generator", table = "ritems_pk_table", pkColumnName = "name", valueColumnName = "value", allocationSize = 1)
	private int recipeSNumber;
	// Resource
	@Column(name = "RESOURCE", nullable = false)
	private String recipeResource;
	// Resource description
	@Column(name = "RESOURCE_DES", nullable = false)
	private String recipeResourceDes;
	// Quantity
	@Column(name = "QUANTITY", nullable = false)
	private String recipeQty;
	// Uom
	@Column(name = "UOM", nullable = false)
	private String recipeUom;
	// Operation description
	@Column(name = "OPERATION_DES", nullable = false)
	private String recipeOperationDes;
	// Standard Values
	@Column(name = "STD_1", nullable = false)
	private String recipeStd1;
	@Column(name = "STD_2", nullable = false)
	private String recipeStd2;
	@Column(name = "STD_3", nullable = false)
	private String recipeStd3;
	@Column(name = "STD_4", nullable = false)
	private String recipeStd4;
	@Column(name = "STD_5", nullable = false)
	private String recipeStd5;
	@Column(name = "STD_6", nullable = false)
	private String recipeStd6;
	// mapping from header table
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "REQUEST_NO")
	 * 
	 * @JsonIgnore private RecipeHeaderDo rheader;
	 */

	/*
	 * public RecipeHeaderDo getRheader() { return rheader; }
	 * 
	 * public void setRheader(RecipeHeaderDo recipeHeaderDo) { this.rheader =
	 * recipeHeaderDo; }
	 */

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

	public Object getPrimaryKey() {
		// TODO Auto-generated method stub
		return recipeSNumber;
	}

}

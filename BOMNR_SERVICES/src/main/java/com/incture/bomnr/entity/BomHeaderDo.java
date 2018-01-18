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
@Table(name = "BOM_HEADER")
public class BomHeaderDo implements BaseDo {
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
	private String bomRefMaterialCode;
	@Column(name = "REF_ALTBOM", nullable = true)
	private String bomRefAltBOM;
	// BOM material code
	@Column(name = "MATERIAL_CODE", nullable = true)
	private String bomMaterialCode;
	// BOM Base Quantity
	@Column(name = "BASE_QTY", nullable = true)
	private String bomBaseQty;
	// BOM Base Uom
	@Column(name = "BASE_UOM", nullable = true)
	private String bomBaseUom;
	// BOM Plant Code
	@Column(name = "PLANT_CODE", nullable = true)
	private String bomPlantCode;
	// Alternate BOM
	@Column(name = "ALT_BOM", nullable = true)
	private String bomAltBOM;
	// alternate text
	@Column(name = "ALT_TEXT", nullable = true)
	private String bomAltText;

	@Column(name = "CREATED_On", nullable = true)
	private Date bomCreatedOn;
	@Column(name = "CREATED_BY", nullable = true)
	private String bomCreatedBy;
	@Column(name = "UPDATED_On", nullable = true)
	private Date bomUpdatedOn;
	@Column(name = "UPDATED_BY", nullable = true)
	private String bomUpdateddBy;

	public Date getBomCreatedOn() {
		return bomCreatedOn;
	}

	public void setBomCreatedOn(Date bomCreatedOn) {
		this.bomCreatedOn = bomCreatedOn;
	}

	public String getBomCreatedBy() {
		return bomCreatedBy;
	}

	public void setBomCreatedBy(String bomCreatedBy) {
		this.bomCreatedBy = bomCreatedBy;
	}

	public Date getBomUpdatedOn() {
		return bomUpdatedOn;
	}

	public void setBomUpdatedOn(Date bomUpdatedOn) {
		this.bomUpdatedOn = bomUpdatedOn;
	}

	public String getBomUpdateddBy() {
		return bomUpdateddBy;
	}

	public void setBomUpdateddBy(String bomUpdateddBy) {
		this.bomUpdateddBy = bomUpdateddBy;
	}

	@OneToMany(targetEntity = BomItemsDo.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<BomItemsDo> items;

	@OneToMany(targetEntity = BomCommentsDo.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<BomCommentsDo> comments;

	public List<BomItemsDo> getItems() {
		return items;
	}

	public void setItems(List<BomItemsDo> items) {
		this.items = items;
	}

	public String getRequestNo() {
		return requestNo;
	}

	public void setRequestNo(String requestNo) {
		this.requestNo = requestNo;
	}

	public String getBomRefMaterialCode() {
		return bomRefMaterialCode;
	}

	public void setBomRefMaterialCode(String bomRefMaterialCode) {
		this.bomRefMaterialCode = bomRefMaterialCode;
	}

	public String getBomRefAltBOM() {
		return bomRefAltBOM;
	}

	public void setBomRefAltBOM(String bomRefAltBOM) {
		this.bomRefAltBOM = bomRefAltBOM;
	}

	public String getBomMaterialCode() {
		return bomMaterialCode;
	}

	public void setBomMaterialCode(String bomMaterialCode) {
		this.bomMaterialCode = bomMaterialCode;
	}

	public String getBomBaseQty() {
		return bomBaseQty;
	}

	public void setBomBaseQty(String bomBaseQty) {
		this.bomBaseQty = bomBaseQty;
	}

	public String getBomBaseUom() {
		return bomBaseUom;
	}

	public void setBomBaseUom(String bomBaseUom) {
		this.bomBaseUom = bomBaseUom;
	}

	public String getBomPlantCode() {
		return bomPlantCode;
	}

	public void setBomPlantCode(String bomPlantCode) {
		this.bomPlantCode = bomPlantCode;
	}

	public String getBomAltBOM() {
		return bomAltBOM;
	}

	public void setBomAltBOM(String bomAltBOM) {
		this.bomAltBOM = bomAltBOM;
	}

	public String getBomAltText() {
		return bomAltText;
	}

	public void setBomAltText(String bomAltText) {
		this.bomAltText = bomAltText;
	}

	public List<BomCommentsDo> getComments() {
		return comments;
	}

	public void setComments(List<BomCommentsDo> comments) {
		this.comments = comments;
	}

	public Object getPrimaryKey() {
		// TODO Auto-generated method stub
		return requestNo;
	}

	public String getPrimaryKeyName() {
		// TODO Auto-generated method stub
		return "requestNo";
	}

}

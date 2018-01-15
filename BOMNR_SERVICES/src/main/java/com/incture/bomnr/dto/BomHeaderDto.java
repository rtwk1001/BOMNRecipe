package com.incture.bomnr.dto;

import java.io.Serializable;

import java.util.List;


public class BomHeaderDto extends BaseDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String requestNo;
	private String bomRefMaterialCode;
	private String bomRefALtBOM;
	private String bomMaterialCode;
	private String bomBaseQty;
	private String bomBaseUom;
	private String bomPlantCode;
	private String bomAltBOM;
	private String bomAltText;
	private List<BomItemsDto> items;
	private List<BomCommentsDto> comments;

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

	public String getBomRefALtBOM() {
		return bomRefALtBOM;
	}

	public void setBomRefALtBOM(String bomRefALtBOM) {
		this.bomRefALtBOM = bomRefALtBOM;
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

	public List<BomItemsDto> getItems() {
		return items;
	}

	public void setItems(List<BomItemsDto> items) {
		this.items = items;
	}

	public List<BomCommentsDto> getComments() {
		return comments;
	}

	public void setComments(List<BomCommentsDto> comments) {
		this.comments = comments;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

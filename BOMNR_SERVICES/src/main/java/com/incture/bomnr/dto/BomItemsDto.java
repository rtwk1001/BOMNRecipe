package com.incture.bomnr.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.incture.bomnr.entity.BomHeaderDo;

public class BomItemsDto extends BaseDto {
	private int bomSNumber;
	private String bomCompCode;
	private String bomCompDes;
	private String bomQty;
	private String bomUom;
	private String bomItemCat;
	@JsonIgnore
	private BomHeaderDo header;
	private String bomText;
	private String bomSortString;
	private String bomStorageLoc;
	private String bomManufacturer;
	public int getBomSNumber() {
		return bomSNumber;
	}
	public void setBomSNumber(int bomSNumber) {
		this.bomSNumber = bomSNumber;
	}
	public String getBomCompCode() {
		return bomCompCode;
	}
	public void setBomCompCode(String bomCompCode) {
		this.bomCompCode = bomCompCode;
	}
	public String getBomCompDes() {
		return bomCompDes;
	}
	public void setBomCompDes(String bomCompDes) {
		this.bomCompDes = bomCompDes;
	}
	public String getBomQty() {
		return bomQty;
	}
	public void setBomQty(String bomQty) {
		this.bomQty = bomQty;
	}
	public String getBomUom() {
		return bomUom;
	}
	public void setBomUom(String bomUom) {
		this.bomUom = bomUom;
	}
	public String getBomItemCat() {
		return bomItemCat;
	}
	public void setBomItemCat(String bomItemCat) {
		this.bomItemCat = bomItemCat;
	}
	public BomHeaderDo getHeader() {
		return header;
	}
	public void setHeader(BomHeaderDo header) {
		this.header = header;
	}
	public String getBomText() {
		return bomText;
	}
	public void setBomText(String bomText) {
		this.bomText = bomText;
	}
	public String getBomSortString() {
		return bomSortString;
	}
	public void setBomSortString(String bomSortString) {
		this.bomSortString = bomSortString;
	}
	public String getBomStorageLoc() {
		return bomStorageLoc;
	}
	public void setBomStorageLoc(String bomStorageLoc) {
		this.bomStorageLoc = bomStorageLoc;
	}
	public String getBomManufacturer() {
		return bomManufacturer;
	}
	public void setBomManufacturer(String bomManufacturer) {
		this.bomManufacturer = bomManufacturer;
	}
}

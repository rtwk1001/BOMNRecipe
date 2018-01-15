package com.incture.bomnr.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "BOM_ITEMS")
public class BomItemsDo implements BaseDo {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Serial number is primary key
	@Id
	@Column(name = "SL_NUMBER", nullable = false)

	@GeneratedValue(strategy = GenerationType.TABLE, generator = "item_generator")
	@TableGenerator(name = "item_generator", table = "pk_table", pkColumnName = "name", valueColumnName = "value", allocationSize = 1)
	private int bomSNumber;

	// component code
	@Column(name = "COMP_CODE", nullable = false)
	private String bomCompCode;
	// Component description
	@Column(name = "COMP_DES", nullable = false)
	private String bomCompDes;
	// Quantity of material in bom item table
	@Column(name = "QUANTITY", nullable = false)
	private String bomQty;
	// Uom
	@Column(name = "UOM", nullable = false)
	private String bomUom;
	// Item catagory
	@Column(name = "ITEM_CAT", nullable = false)
	private String bomItemCat;

	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "REQUEST_NO")
	 * 
	 * @JsonIgnore private BomHeaderDo header;
	 */

	// Item Text
	@Column(name = "ITEM_TEXT", nullable = false)
	private String bomText;
	// Sort String
	@Column(name = "SORT_STRING", nullable = false)
	private String bomSortString;
	// Strorage Location
	@Column(name = "STORAGE_LOC", nullable = false)
	private String bomStorageLoc;
	// Manufacturer
	@Column(name = "MANUFACTURER", nullable = false)
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

	/*
	 * public BomHeaderDo getHeader() { return header; }
	 * 
	 * public void setHeader(BomHeaderDo header) { this.header = header; }
	 */

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

	public Object getPrimaryKey() {
		// TODO Auto-generated method stub
		return bomSNumber;
	}

}

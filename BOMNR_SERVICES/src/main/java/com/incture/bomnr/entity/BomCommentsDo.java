package com.incture.bomnr.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "BOM_COMMENTS")
public class BomCommentsDo implements BaseDo {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Serial number is primary key
	@Id
	@Column(name = "SL_NUMBER", nullable = false)

	@GeneratedValue(strategy = GenerationType.TABLE, generator = "comments_generator")

	@TableGenerator(name = "comments_generator", table = "comments_pk_table", pkColumnName = "name", valueColumnName = "value", allocationSize = 1)

	private int comSNumber;
	// Created By
	@Column(name = "CREATED_BY", nullable = false)
	private String comCreatedBy;

	// Created On
	@Column(name = "CREATED_ON", nullable = true)
	private Date comCreatedOn;

	// Comment
	@Column(name = "COMMENT", nullable = true)
	private String comComment;

	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "REQUEST_NO")
	 * 
	 * @JsonIgnore private BomHeaderDo head;
	 */

	public int getComSNumber() {
		return comSNumber;
	}

	public void setComSNumber(int comSNumber) {
		this.comSNumber = comSNumber;
	}

	public String getComCreatedBy() {
		return comCreatedBy;
	}

	public void setComCreatedBy(String comCreatedBy) {
		this.comCreatedBy = comCreatedBy;
	}

	public Date getComCreatedOn() {
		return comCreatedOn;
	}

	public void setComCreatedOn(Date comCreatedOn) {
		this.comCreatedOn = comCreatedOn;
	}

	public String getComComment() {
		return comComment;
	}

	public void setComComment(String comComment) {
		this.comComment = comComment;
	}

	/*
	 * public BomHeaderDo getHead() { return head; }
	 * 
	 * public void setHead(BomHeaderDo head) { this.head = head; }
	 */

	public Object getPrimaryKey() {

		return comSNumber;
	}

}

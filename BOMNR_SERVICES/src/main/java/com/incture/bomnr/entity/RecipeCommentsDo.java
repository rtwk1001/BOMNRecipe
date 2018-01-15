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
@Table(name = "RECIPE_COMMENTS")
public class RecipeCommentsDo implements BaseDo {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Serial number is primary key
	@Id
	@Column(name = "SL_NUMBER", nullable = false)

	@GeneratedValue(strategy = GenerationType.TABLE, generator = "comments_generator")

	@TableGenerator(name = "comments_generator", table = "rcomments_pk_table", pkColumnName = "name", valueColumnName = "value", allocationSize = 1)

	private int rComSNumber;
	// Created By
	@Column(name = "CREATED_BY", nullable = false)
	private String rComCreatedBy;

	// Created On
	@Column(name = "CREATED_ON", nullable = true)
	private Date rComCreatedOn;

	// Comment
	@Column(name = "COMMENT", nullable = true)
	private String rComComment;
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "REQUEST_NO")
	 * 
	 * @JsonIgnore private RecipeHeaderDo rhead;
	 */

	public int getRComSNumber() {
		return rComSNumber;
	}

	public void setRComSNumber(int rComSNumber) {
		this.rComSNumber = rComSNumber;
	}

	public String getrComCreatedBy() {
		return rComCreatedBy;
	}

	public void setrComCreatedBy(String rComCreatedBy) {
		this.rComCreatedBy = rComCreatedBy;
	}

	public Date getrComCreatedOn() {
		return rComCreatedOn;
	}

	public void setrComCreatedOn(Date rComCreatedOn) {
		this.rComCreatedOn = rComCreatedOn;
	}

	public String getrComComment() {
		return rComComment;
	}

	public void setrComComment(String rComComment) {
		this.rComComment = rComComment;
	}

	/*
	 * public RecipeHeaderDo getRhead() { return rhead; }
	 * 
	 * public void setRhead(RecipeHeaderDo rhead) { this.rhead = rhead; }
	 */
	public Object getPrimaryKey() {
		// TODO Auto-generated method stub
		return rComSNumber;
	}

}

package com.incture.bomnr.dto;

import java.util.Date;

import com.incture.bomnr.entity.RecipeHeaderDo;
import com.incture.bomnr.exceptions.InvalidInputFault;
import com.incture.bomnr.util.BOMNROperation;

public class RecipeCommentsDto extends BaseDto {
	private int rComSNumber;
	private String rComCreatedBy;
	private Date rComCreatedOn;
	private String rComComment;
	private RecipeHeaderDo rhead;

	public int getrComSNumber() {
		return rComSNumber;
	}

	public void setrComSNumber(int rComSNumber) {
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

	public RecipeHeaderDo getRhead() {
		return rhead;
	}

	public void setRhead(RecipeHeaderDo rhead) {
		this.rhead = rhead;
	}

	@Override
	public void validate(BOMNROperation enOperation) throws InvalidInputFault {
		rComCreatedBy = checkStringSize("RecipeComments.CreatedBy", rComCreatedBy, 50);
	       
		rComComment = checkStringSize("RecipeComments.Comment", rComComment, 255);
	}

}

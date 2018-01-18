package com.incture.bomnr.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.incture.bomnr.entity.BomHeaderDo;
import com.incture.bomnr.exceptions.InvalidInputFault;
import com.incture.bomnr.util.BOMNROperation;


public class BomCommentsDto extends BaseDto {
	private int comSNumber;
	private String comCreatedBy;
	private Date comCreatedOn;
	private String comComment;
	@JsonIgnore
	private BomHeaderDo head;

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

	public BomHeaderDo getHead() {
		return head;
	}

	public void setHead(BomHeaderDo head) {
		this.head = head;
	}

	@Override
	public void validate(BOMNROperation enOperation) throws InvalidInputFault {
	
		comCreatedBy = checkStringSize("BomComments.CreatedBy", comCreatedBy, 50);
       
		comComment = checkStringSize("BomComments.Comment", comComment, 255);

	}

}

package com.incture.bomnr.dao;

import org.springframework.stereotype.Repository;

import com.incture.bomnr.dto.BomCommentsDto;
import com.incture.bomnr.entity.BomCommentsDo;

@Repository("bomcommentsDao")
public class BomCommentsDao  {

	
	
	public BomCommentsDo importDto(BomCommentsDto bomCommentsDto) {
		
	 BomCommentsDo  bomCommentsDo=new BomCommentsDo();	
		bomCommentsDo.setComSNumber(bomCommentsDto.getComSNumber());
		bomCommentsDo.setComCreatedBy(bomCommentsDto.getComCreatedBy());
		bomCommentsDo.setComCreatedOn(bomCommentsDto.getComCreatedOn());
		//bomCommentsDo.setHead(bomheaderDo);
		bomCommentsDo.setComComment(bomCommentsDto.getComComment());
		return bomCommentsDo;

	}

	public BomCommentsDto exportDto(BomCommentsDo bomCommentsDo) {
		BomCommentsDto bomCommentsDto= new BomCommentsDto();
		bomCommentsDto=new BomCommentsDto();
		bomCommentsDto.setComSNumber(bomCommentsDo.getComSNumber());
		bomCommentsDto.setComCreatedBy(bomCommentsDo.getComCreatedBy());
		bomCommentsDto.setComCreatedOn(bomCommentsDo.getComCreatedOn());
		//bomCommentsDto.setHead(bomCommentsDo.getHead());
		bomCommentsDto.setComComment(bomCommentsDo.getComComment());

		return bomCommentsDto;

	}

}

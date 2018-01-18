package com.incture.bomnr.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.incture.bomnr.dto.BomCommentsDto;
import com.incture.bomnr.dto.BomHeaderDto;
import com.incture.bomnr.dto.BomItemsDto;

import com.incture.bomnr.entity.BomCommentsDo;
import com.incture.bomnr.entity.BomHeaderDo;
import com.incture.bomnr.entity.BomItemsDo;

@Repository("bomheaderdao")
public class BomHeaderDao extends BaseDao<BomHeaderDo, BomHeaderDto> {

	private BomHeaderDo bomHeaderDo;
	private BomHeaderDto bomHeaderDto;
	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override

	public BomHeaderDo importDto(BomHeaderDto bomHeaderDto) {
		bomHeaderDo = new BomHeaderDo();
		bomHeaderDo.setRequestNo(bomHeaderDto.getRequestNo());
		bomHeaderDo.setBomAltBOM(bomHeaderDto.getBomAltBOM());
		bomHeaderDo.setBomAltText(bomHeaderDto.getBomAltText());
		bomHeaderDo.setBomBaseQty(bomHeaderDto.getBomBaseQty());
		bomHeaderDo.setBomBaseUom(bomHeaderDto.getBomBaseUom());

		bomHeaderDo.setBomMaterialCode(bomHeaderDto.getBomMaterialCode());
		bomHeaderDo.setBomPlantCode(bomHeaderDto.getBomPlantCode());
		bomHeaderDo.setBomRefAltBOM(bomHeaderDto.getBomAltBOM());
		bomHeaderDo.setBomRefMaterialCode(bomHeaderDto.getBomRefMaterialCode());
		bomHeaderDo.setBomCreatedBy(bomHeaderDto.getBomCreatedBy());
		bomHeaderDo.setBomCreatedOn(bomHeaderDto.getBomCreatedOn());
		bomHeaderDo.setBomUpdateddBy(bomHeaderDto.getBomUpdateddBy());
		bomHeaderDo.setBomUpdatedOn(bomHeaderDto.getBomUpdatedOn());
		if (bomHeaderDto.getComments() != null) {
			List<BomCommentsDo> comList = new ArrayList<BomCommentsDo>();
			BomCommentsDao comdao = new BomCommentsDao();
			for (BomCommentsDto bomCommentsDto : bomHeaderDto.getComments()) {
				comList.add(comdao.importDto(bomCommentsDto));
			}
			bomHeaderDo.setComments(comList);
		}
		if (bomHeaderDto.getItems() != null) {
			List<BomItemsDo> itemList = new ArrayList<BomItemsDo>();
			BomItemsDao itemdao = new BomItemsDao();
			for (BomItemsDto bomItemsDto : bomHeaderDto.getItems()) {
				itemList.add(itemdao.importDto(bomItemsDto, bomHeaderDo));
			}
			bomHeaderDo.setItems(itemList);
		}

		return bomHeaderDo;

	}

	@Override
	public BomHeaderDto exportDto(BomHeaderDo bomHeaderDo) {
		bomHeaderDto = new BomHeaderDto();
		bomHeaderDto.setRequestNo(bomHeaderDo.getRequestNo());
		bomHeaderDto.setBomAltBOM(bomHeaderDo.getBomAltBOM());
		bomHeaderDto.setBomAltText(bomHeaderDo.getBomAltText());
		bomHeaderDto.setBomBaseQty(bomHeaderDo.getBomBaseQty());
		bomHeaderDto.setBomBaseUom(bomHeaderDo.getBomBaseUom());
		bomHeaderDto.setBomMaterialCode(bomHeaderDo.getBomMaterialCode());
		bomHeaderDto.setBomPlantCode(bomHeaderDo.getBomPlantCode());
		bomHeaderDto.setBomRefALtBOM(bomHeaderDo.getBomAltBOM());
		bomHeaderDto.setBomRefMaterialCode(bomHeaderDo.getBomRefMaterialCode());
		bomHeaderDto.setBomCreatedBy(bomHeaderDo.getBomCreatedBy());
		bomHeaderDto.setBomCreatedOn(bomHeaderDo.getBomCreatedOn());
		bomHeaderDto.setBomUpdateddBy(bomHeaderDo.getBomUpdateddBy());
		bomHeaderDto.setBomUpdatedOn(bomHeaderDo.getBomUpdatedOn());
		if (bomHeaderDo.getComments() != null) {
			List<BomCommentsDto> comList = new ArrayList<BomCommentsDto>();
			BomCommentsDao comdao = new BomCommentsDao();
			for (BomCommentsDo bomCommentsDo : bomHeaderDo.getComments()) {
				comList.add(comdao.exportDto(bomCommentsDo));
			}
			bomHeaderDto.setComments(comList);
		}
		if (bomHeaderDo.getItems() != null) {
			List<BomItemsDto> itemList = new ArrayList<BomItemsDto>();
			BomItemsDao itemdao = new BomItemsDao();
			for (BomItemsDo bomItemsDo : bomHeaderDo.getItems()) {
				itemList.add(itemdao.exportDto(bomItemsDo));
			}
			bomHeaderDto.setItems(itemList);
		}

		return bomHeaderDto;

	}

}

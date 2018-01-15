package com.incture.bomnr.dao;

import com.incture.bomnr.dto.BomItemsDto;
import com.incture.bomnr.entity.BomHeaderDo;
import com.incture.bomnr.entity.BomItemsDo;

public class BomItemsDao  {
	

	public BomItemsDo importDto(BomItemsDto bomItemsDto,BomHeaderDo bomHeaderDo) {
		BomItemsDo bomItemsDo=new BomItemsDo();

		bomItemsDo.setBomSNumber(bomItemsDto.getBomSNumber());

		bomItemsDo.setBomCompCode(bomItemsDto.getBomCompCode());

		bomItemsDo.setBomCompDes(bomItemsDto.getBomCompDes());

		bomItemsDo.setBomItemCat(bomItemsDto.getBomItemCat());

		bomItemsDo.setBomQty(bomItemsDto.getBomQty());

		bomItemsDo.setBomText(bomItemsDto.getBomText());

		bomItemsDo.setBomUom(bomItemsDto.getBomUom());

		bomItemsDo.setBomSortString(bomItemsDto.getBomSortString());

		bomItemsDo.setBomStorageLoc(bomItemsDto.getBomStorageLoc());

		bomItemsDo.setBomManufacturer(bomItemsDto.getBomManufacturer());

		//bomItemsDo.setHeader(bomHeaderDo);

		return bomItemsDo;

	}

	public BomItemsDto exportDto(BomItemsDo bomItemsDo) {
		BomItemsDto bomItemsDto = new BomItemsDto();

		bomItemsDto.setBomSNumber(bomItemsDo.getBomSNumber());

		bomItemsDto.setBomCompCode(bomItemsDo.getBomCompCode());

		bomItemsDto.setBomCompDes(bomItemsDo.getBomCompDes());

		bomItemsDto.setBomItemCat(bomItemsDo.getBomItemCat());

		bomItemsDto.setBomQty(bomItemsDo.getBomQty());

		bomItemsDto.setBomText(bomItemsDo.getBomText());

		bomItemsDto.setBomUom(bomItemsDo.getBomUom());

		bomItemsDto.setBomSortString(bomItemsDo.getBomSortString());

		bomItemsDto.setBomStorageLoc(bomItemsDo.getBomStorageLoc());

		bomItemsDto.setBomManufacturer(bomItemsDo.getBomManufacturer());

		//bomItemsDto.setHeader(bomItemsDo.getHeader());

		return bomItemsDto;

	}

	

}

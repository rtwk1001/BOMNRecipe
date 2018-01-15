package com.incture.bomnr.service;

import java.util.List;

import com.incture.bomnr.dto.BaseDto;
import com.incture.bomnr.dto.BomHeaderDto;
import com.incture.bomnr.dto.ResponseDto;

public interface BomHeaderServiceLocal {
	ResponseDto createBom(BomHeaderDto Dto);

	BaseDto findBom(String requestNo);

	ResponseDto deleteBom(String requestNo);

	List<BomHeaderDto> findAllBom();

	ResponseDto updateBom(BomHeaderDto Dto);
}

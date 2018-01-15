package com.incture.bomnr.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.incture.bomnr.dao.BomHeaderDao;
import com.incture.bomnr.dto.BaseDto;
import com.incture.bomnr.dto.BomHeaderDto;
import com.incture.bomnr.dto.ResponseDto;

@Service("bomheaderservice")
@Transactional
public class BomHeaderService implements BomHeaderServiceLocal {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Autowired
	private BomHeaderDao bomHeaderDao;

	public ResponseDto createBom(BomHeaderDto Dto) {
		Dto.setRequestNo(SequenceNumberGen.getInstance().getNextSeqNumber("BOM", 8, getSession()));
		return bomHeaderDao.create(Dto);
	}

	public BaseDto findBom(String requestNo) {
		BomHeaderDto inputdto = new BomHeaderDto();
		inputdto.setRequestNo(requestNo);

		try {
			return bomHeaderDao.getByKeys(inputdto);
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ResponseDto response = new ResponseDto();
			response.setStatus(false);
			response.setMessage("Invalid Response Number");
			return response;
		}
	}

	public ResponseDto deleteBom(String requestNo) {
		ResponseDto response = new ResponseDto();
		BomHeaderDto inputdto = new BomHeaderDto();
		inputdto.setRequestNo(requestNo);
		try {
			bomHeaderDao.deleteDto(inputdto);
			response.setStatus(true);
			response.setMessage("BOM with Request number:" + requestNo + " ,is Successfully Deleted!");

		}
		catch (Exception e) {
			e.printStackTrace();
			response.setStatus(false);
			response.setMessage("Failed to delete the BOM. Request number:" + requestNo);
		}
		return response;
	}

	public List<BomHeaderDto> findAllBom() {
		BomHeaderDto sampleDto = new BomHeaderDto();
		try {
			return bomHeaderDao.findAll(sampleDto);
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return null;
		}

	}

	public ResponseDto updateBom(BomHeaderDto Dto) {

		return bomHeaderDao.update(Dto);
	}

}

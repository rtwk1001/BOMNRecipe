package com.incture.bomnr.service;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.incture.bomnr.dao.BomHeaderDao;
import com.incture.bomnr.dto.BaseDto;
import com.incture.bomnr.dto.BomHeaderDto;
import com.incture.bomnr.dto.RemoveMultipeDto;
import com.incture.bomnr.dto.ResponseDto;
import com.incture.bomnr.exceptions.InvalidInputFault;

@Service("bomheaderservice")
@Transactional
public class BomHeaderService implements BomHeaderServiceLocal {

	private static final Logger LOGGER = LoggerFactory.getLogger(BomHeaderService.class);

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Autowired
	private BomHeaderDao bomHeaderDao;

	public ResponseDto createBom(BomHeaderDto Dto) {
		ResponseDto response = new ResponseDto();
		Dto.setRequestNo(SequenceNumberGen.getInstance().getNextSeqNumber("BOM", 8, getSession()));
		Dto.setBomCreatedOn(new Date());
		try {
			return bomHeaderDao.create(Dto);

		}
		catch (Exception e) {
			response.setStatus(false);
			response.setMessage("failed" + e.toString());
			LOGGER.error("Error in creating the bom.");
			e.printStackTrace();
			return response;
		}
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
			response.setMessage("Invalid Request Number");
			LOGGER.error("Unable to find the Bom with request ID: " + requestNo);
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
			LOGGER.error("Unable to Delete the Bom with request ID: " + requestNo);
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
			LOGGER.error("Unable to find the Boms");
			return null;
		}

	}

	public ResponseDto updateBom(BomHeaderDto Dto) {
		ResponseDto response = new ResponseDto();
		try {
			bomHeaderDao.update(Dto);
			response.setMessage("Bom with  request Number :" + Dto.getRequestNo() + "updated!");
			response.setStatus(true);
		}
		catch (Exception e) {
			response.setStatus(false);
			response.setMessage("Updation failed with: " + e.toString());
			LOGGER.error("Unable to Update the Bom with request ID: " + Dto.getRequestNo());
		}
		return response;
	}

	public ResponseDto deleteMultipeBom(RemoveMultipeDto Dto) {
		List<String> reqNos = Dto.getReqNumbers();
		ResponseDto res = new ResponseDto();

		try {
			for (String reqNo : reqNos) {
				BomHeaderDto inputdto = new BomHeaderDto();
				inputdto.setRequestNo(reqNo);
				bomHeaderDao.deleteDto(inputdto);
			}
			res.setStatus(true);
			res.setMessage("Successfully deleted the desired Boms");

		}
		catch (Exception e) {
			res.setStatus(false);
			res.setMessage("Invalid Input or unable to delete the desired files");
			LOGGER.error("Unable to Delete multiple the Boms ");
		}
		return res;
	}

}

package com.incture.bomnr.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.incture.bomnr.dao.RecipeHeaderDao;
import com.incture.bomnr.dto.BaseDto;
import com.incture.bomnr.dto.BomHeaderDto;
import com.incture.bomnr.dto.RecipeHeaderDto;
import com.incture.bomnr.dto.RemoveMultipeDto;
import com.incture.bomnr.dto.ResponseDto;

@Service("recipeheaderservice")
@Transactional
public class RecipeHeaderService implements RecipeHeaderServiceLocal {

	private static final Logger LOGGER = LoggerFactory.getLogger(RecipeHeaderService.class);

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Autowired
	private RecipeHeaderDao recipeHeaderDao;

	public ResponseDto createRecipe(RecipeHeaderDto Dto) {
		Dto.setRequestNo(SequenceNumberGen.getInstance().getNextSeqNumber("REC", 8, getSession()));
		try {
			return recipeHeaderDao.create(Dto);
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ResponseDto response = new ResponseDto();
			response.setStatus(false);
			response.setMessage("Failed" + e.toString());
			LOGGER.error(" Unable to create the REcipe");
			return response;

		}

	}

	public BaseDto findById(String requestNo) {
		RecipeHeaderDto inputdto = new RecipeHeaderDto();
		inputdto.setRequestNo(requestNo);

		try {
			return recipeHeaderDao.getByKeys(inputdto);
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ResponseDto response = new ResponseDto();
			response.setStatus(false);
			response.setMessage("Invalid Request Number");
			LOGGER.error(" Unable to find  the REcipe with request Number: " + requestNo);
			return response;
		}

	}

	public ResponseDto deleteRecipe(String requestNo) {
		ResponseDto response = new ResponseDto();
		RecipeHeaderDto inputdto = new RecipeHeaderDto();
		inputdto.setRequestNo(requestNo);
		try {
			recipeHeaderDao.deleteDto(inputdto);
			response.setStatus(true);
			response.setMessage("Recipe with Request number:" + requestNo + " ,is Successfully Deleted!");

		}
		catch (Exception e) {
			e.printStackTrace();
			response.setStatus(false);
			response.setMessage("Failed to delete the Recipe. Request number:" + requestNo);
			LOGGER.error("Failed to delete the Recipe. Request number:" + requestNo);
		}
		return response;
	}

	public List<RecipeHeaderDto> findAllRecipies() {
		RecipeHeaderDto sampleDto = new RecipeHeaderDto();
		try {
			return recipeHeaderDao.findAll(sampleDto);
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGGER.error("Failed to fetch all Recipes.");
			return null;
		}
	}

	public ResponseDto updateRecipe(RecipeHeaderDto Dto) {
		ResponseDto response = new ResponseDto();
		try {
			recipeHeaderDao.update(Dto);
			response.setMessage("Recipe with  request Number :" + Dto.getRequestNo() + "updated!");
			response.setStatus(true);
		}
		catch (Exception e) {
			response.setStatus(false);
			response.setMessage("Updation failed with: " + e.toString());
			LOGGER.error("Unable to Update the Recipe with request ID: " + Dto.getRequestNo());
		}
		return response;
	}

	public ResponseDto deleteMultipeRecipe(RemoveMultipeDto Dto) {
		List<String> reqNos = Dto.getReqNumbers();
		ResponseDto res = new ResponseDto();

		try {
			for (String reqNo : reqNos) {
				RecipeHeaderDto inputdto = new RecipeHeaderDto();
				inputdto.setRequestNo(reqNo);
				recipeHeaderDao.deleteDto(inputdto);
			}
			res.setStatus(true);
			res.setMessage("Successfully deleted the desired Recipies");

		}
		catch (Exception e) {
			res.setStatus(false);
			res.setMessage("Invalid Input or unable to delete the desired files");
			LOGGER.error("Failed to delete multiple Recipes. ");
		}
		return res;
	}

}

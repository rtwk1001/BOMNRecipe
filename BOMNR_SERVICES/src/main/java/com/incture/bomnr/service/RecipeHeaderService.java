package com.incture.bomnr.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.incture.bomnr.dao.RecipeHeaderDao;
import com.incture.bomnr.dto.BaseDto;

import com.incture.bomnr.dto.RecipeHeaderDto;
import com.incture.bomnr.dto.ResponseDto;

@Service("recipeheaderservice")
@Transactional
public class RecipeHeaderService implements RecipeHeaderServiceLocal {
	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Autowired
	private RecipeHeaderDao recipeHeaderDao;

	public ResponseDto createRecipe(RecipeHeaderDto Dto) {
		Dto.setRequestNo(SequenceNumberGen.getInstance().getNextSeqNumber("REC", 8, getSession()));
		return recipeHeaderDao.create(Dto);

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
			response.setMessage("Invalid Response Number");
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

			return null;
		}
	}

	public ResponseDto updateRecipe(RecipeHeaderDto Dto) {
		// TODO Auto-generated method stub
		return recipeHeaderDao.update(Dto);
	}
}

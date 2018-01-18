package com.incture.bomnr.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
		
		return recipeHeaderDao.update(Dto);
	}

	public ResponseDto deleteMultipeRecipe(RemoveMultipeDto Dto) {
		List<String> reqNos=Dto.getReqNumbers();
		ResponseDto res=new ResponseDto();
		
		try{for(String reqNo:reqNos){
			RecipeHeaderDto inputdto = new RecipeHeaderDto();
			inputdto.setRequestNo(reqNo);
			recipeHeaderDao.deleteDto(inputdto);
		}
		res.setStatus(true);
		res.setMessage("Successfully deleted the desired Recipies");
		
		}
		catch(Exception e){
		res.setStatus(false);
		res.setMessage("Invalid Input or unable to delete the desired files");
		}
		return res;
	}
	
}

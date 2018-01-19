package com.incture.bomnr.dao;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;

import com.incture.bomnr.dto.BaseDto;
import com.incture.bomnr.dto.ResponseDto;
import com.incture.bomnr.entity.BaseDo;
import com.incture.bomnr.exceptions.ExecutionFault;
import com.incture.bomnr.exceptions.InvalidInputFault;
import com.incture.bomnr.exceptions.NoResultFault;
import com.incture.bomnr.exceptions.NonUniqueRecordFault;
import com.incture.bomnr.util.BOMNROperation;

public abstract class BaseDao<E extends BaseDo, D extends BaseDto> {
    
	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
//Persist
	public void persist(E entity) {
		getSession().persist(entity);
	}
	//Update
	public void update(E entity){
		getSession().merge(entity);
	}
	
//delete
	public void delete(E entity) {
		getSession().delete(entity);
	}
//Import Generic
	public E importdto(BOMNROperation op, D dto) throws Exception {
        dto.validate(op);
		return importDto(dto);
	}
//Export Generic
	public D exportdto(BOMNROperation op, E dos) throws Exception {
		// TODO Auto-generated method stub
		return exportDto(dos);
	}

	abstract D exportDto(E dos);

	abstract E importDto(D dto)throws InvalidInputFault, ExecutionFault, NoResultFault;
//Create
	public ResponseDto create(D dto) throws Exception{
		ResponseDto response = new ResponseDto();
		try {
			// persisting the dto
			E e = importdto(BOMNROperation.CREATE, dto);
			persist(e);
			response.setStatus(true);
			response.setMessage("Success");
		}
		catch (Exception e) {
			e.printStackTrace();
			response.setStatus(false);
			response.setMessage("failed"+e.toString());
		}
		return response;

	}
//Find 
	public D getByKeys(D dto) throws Exception {
		return exportDto(getByKeysForFK(dto));
	}

	public E getByKeysForFK(D dto) throws Exception {
		return find(importdto(BOMNROperation.RETRIVE, dto));
	}
	

	@SuppressWarnings("unchecked")
	protected E find(E pojo)  throws Exception {
		E result = null;
		try {

			result = (E) getSession().get(pojo.getClass(), (Serializable) pojo.getPrimaryKey());
		}
		catch (Exception e) {
			// In case of connection or other JPA ones.
			e.printStackTrace();
		}

		return result;
	}
	//FindAll
	 @SuppressWarnings("unchecked")
	public List<D> findAll(D Dto) throws Exception{
List<D> outDtos=new ArrayList<D>();
		Criteria criteria = getSession().createCriteria(importdto(BOMNROperation.RETRIVE,Dto).getClass());
		
		List<E> listDo=(List<E>)criteria.list();
		 for(E Dos: listDo)
		 {
			 outDtos.add(exportDto(Dos));
			 
		 }
		 return outDtos;
	}
	 //UPdate
	 public void update(D dto) throws Exception {
		
			
		
			getByKeysForFK(dto);
			update(importdto(BOMNROperation.UPDATE, dto));
		
	
		}
	
//Delete
	public void deleteDto(D dto)  {
		// remove(importDto(EnOperation.DELETE, dto));
		try {
			delete(getByKeysForFK(dto));
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

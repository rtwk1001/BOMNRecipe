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

		return importDto(dto);
	}
//Export Generic
	public D exportdto(BOMNROperation create, E dos) throws Exception {
		// TODO Auto-generated method stub
		return exportDto(dos);
	}

	abstract D exportDto(E dos);

	abstract E importDto(D dto);
//Create
	public ResponseDto create(D dto) {
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
			response.setMessage("failed");
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
	protected E find(E pojo) {
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
	 public ResponseDto update(D dto)  {
		ResponseDto response= new ResponseDto();	
			
		try {
			getByKeysForFK(dto);
			update(importdto(BOMNROperation.UPDATE, dto));
			response.setStatus(true);
			response.setMessage("BOM with Request Number:"+importDto(dto).getPrimaryKey()+"is updated SuccessFully");
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.setMessage("Failed");
			response.setStatus(false);
		}
		return response;
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
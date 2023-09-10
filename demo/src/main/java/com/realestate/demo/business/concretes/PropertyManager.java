package com.realestate.demo.business.concretes;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.realestate.demo.business.abstracts.IPropertyService;
import com.realestate.demo.core.results.DataResult;
import com.realestate.demo.core.results.Result;
import com.realestate.demo.core.results.SuccessDataResult;
import com.realestate.demo.dataAccess.PropertyDao;
import com.realestate.demo.entity.Property;
import com.realestate.demo.entity.dtos.PropertyWithTypeDto;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PropertyManager implements IPropertyService {
	
	// the class from business interface to write wished method. It is written by respecting which classes, parameters and objects are used.

	private PropertyDao propertyDao;

	@Override
	public DataResult<List<Property>> getAll()
	{

		return new SuccessDataResult<List<Property>>
		(this.propertyDao.findAll(), "Data listed");
	}

	@Override
	public DataResult<List<Property>> getAllSorted() 
	{
		Sort sort = Sort.by(Sort.Direction.DESC, "propertyName");
		return new SuccessDataResult<List<Property>>
		(this.propertyDao.findAll(sort),"Success");
	}

	@Override
	public DataResult<List<Property>> getAll(int pageNo, int pageSize) 
	{
		Pageable pageable = PageRequest.of(pageNo-1,  pageSize); //page no begins at 0 so we should indicates -1
		
		return new SuccessDataResult<List<Property>>
		(this.propertyDao.findAll(pageable).getContent());
	}

	@Override
	public Result add(Property property)
	{

		this.propertyDao.save(property);
		return new SuccessDataResult<Property>("Property added");
	}

	@Override
	public DataResult<Property> getByPropertyName(String propertyName) 
	{
		return new SuccessDataResult<Property>
		(this.propertyDao.getByPropertyName(propertyName), "Data listed");
	}

	@Override
	public DataResult<List<Property>> getByTypeIn(List<Integer> types) 
	{
		return new SuccessDataResult<List<Property>>
		(this.propertyDao.getByTypeIn(types),"Data listelendi");
	
	}

	@Override
	public DataResult<Property> getByPropertyNameAndType(String propertyName, int typeId)
	{
		return new SuccessDataResult<Property>(this.propertyDao.getByPropertyNameAndType_TypeId(propertyName , typeId),"Data listelendi");
	}

	@Override
	public DataResult<List<Property>> getByPropertyNameOrType(String propertyName, int typeId)
	{
		return new SuccessDataResult<List<Property>>	
		(this.propertyDao.getByPropertyNameOrType_TypeId(propertyName, typeId),"Data listelendi");
	
	}

	@Override
	public DataResult<List<Property>> getByPropertyNameContains(String propertyName)
	{
		return new SuccessDataResult<List<Property>>
		(this.propertyDao.getByPropertyNameContains(propertyName),"Data listelendi");
	
	}

	@Override
	public DataResult<List<Property>> getByPropertyNameStartsWith(String propertyName)
	{
		return new SuccessDataResult<List<Property>>	
		(this.propertyDao.getByPropertyNameStartsWith(propertyName),"Data listelendi");
	
	}

	@Override
	public DataResult<List<Property>> getByNameAndType(String propertyName, int typeId)
	{
		return new SuccessDataResult<List<Property>>	
		(this.propertyDao.getByNameAndType(propertyName,typeId),"Data listelendi");
	
	}

	@Override
	public DataResult<List<PropertyWithTypeDto>> getPropertyWithTypeDetails()
	{
		return new SuccessDataResult<List<PropertyWithTypeDto>>(this.propertyDao.getPropertyWithTypeDetails(),"Data listelendi");		
	
	}
		


}

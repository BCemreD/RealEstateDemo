package com.realestate.demo.business.abstracts;

import java.util.List;

import com.realestate.demo.core.results.DataResult;
import com.realestate.demo.core.results.Result;
import com.realestate.demo.entity.Property;
import com.realestate.demo.entity.dtos.PropertyWithTypeDto;

public interface IPropertyService {
	
	//the interface class for getting all properties from objects, and posting methods by using wished methods.
	
	 DataResult<List<Property>>getAll();
	 DataResult<List<Property>>getAllSorted();
	 DataResult<List<Property>>getAll(int pageNo, int pageSize );
	 Result add(Property property);
	 
	 DataResult<Property>getByPropertyName(String propertyName);
	 DataResult<Property>getByPropertyNameAndType(String propertyName, int typeId);
	 DataResult<List<Property>> getByPropertyNameOrType(String propertyName, int typeId);
	 DataResult<List<Property>>getByTypeIn(List<Integer>types);
     DataResult<List<Property>> getByPropertyNameContains(String propertyName);
     DataResult<List<Property>> getByPropertyNameStartsWith(String propertyName);
     DataResult<List<Property>> getByNameAndType(String propertyName, int typeId);     
     DataResult<List<PropertyWithTypeDto>> getPropertyWithTypeDetails();
}

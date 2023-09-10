package com.realestate.demo.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.realestate.demo.entity.Property;
import com.realestate.demo.entity.dtos.PropertyWithTypeDto;

public interface PropertyDao extends JpaRepository<Property,Integer>{
	
	/*this class is written for repository
	 * it contains getting and posting types.
	 * Also contains querry for calling object list.
	*/

	
	Property getByPropertyName(String propertyName);
	
	List<Property>getByTypeIn(List<Integer>types);
	
	Property getByPropertyNameAndType_TypeId(String propertyName, int typeId);
	  
	List<Property> getByPropertyNameOrType_TypeId(String propertyName, int typeId);
	  
	  List<Property> getByPropertyNameContains(String propertyName);
	  
	  List<Property> getByPropertyNameStartsWith(String propertyName);
	  
	  //sql querries
	  
	  @Query("From Property where propertyName=:propertyName and type.typeId=:typeId")
	  List<Property> getByNameAndType(String propertyName, int typeId);
	  
	  @Query("Select  new com.realestate.demo.entity.dtos.PropertyWithTypeDto"
	  		+ "(p.propertyId, p.propertyName, t.typeName) "
	  		+ "From Type t Inner Join t.properties p")
	  List<PropertyWithTypeDto> getPropertyWithTypeDetails();

	}

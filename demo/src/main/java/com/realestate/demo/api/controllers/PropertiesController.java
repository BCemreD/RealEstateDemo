package com.realestate.demo.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.realestate.demo.business.abstracts.IPropertyService;
import com.realestate.demo.core.results.DataResult;
import com.realestate.demo.core.results.Result;
import com.realestate.demo.entity.Property;


/*
 * the controller page controls the connection service and database, and business methods.
 */
@RestController
@RequestMapping ("/api/properties")
public class PropertiesController {
	
	//api connection class. Some of getting and posting methods' urls are dedicated. Mapping is needed
	
	private IPropertyService iPropertyService; //methods which are mapped, are collected from service interface 
	
	@Autowired
	public PropertiesController (IPropertyService ipropertyService)
	{
		super();
		this.iPropertyService = ipropertyService;
		
	}
	
	@GetMapping("/getall")
	public DataResult<List<Property>>getAll()
	{
		return this.iPropertyService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Property property)
	{
		return this.iPropertyService.add(property);
	}
	
	@GetMapping("/getByPropertyName")
	public DataResult<Property>getByPropertyName(@RequestParam String propertyName)
	{
		return this.iPropertyService.getByPropertyName(propertyName);
	}
	
	@GetMapping("/getByPropertyNameAndTypeId")
	public DataResult<Property>getByPropertyNameAndTypeId(@RequestParam("propertyName") String propertyName,@RequestParam("typeId") int typeId){
		System.out.println(propertyName);
		System.out.println(typeId);
		
		return this.iPropertyService.getByPropertyNameAndType(propertyName, typeId);
	}
	
	@GetMapping("/getByPropertyNameContains")
	public DataResult<List<Property>> getByPropertyNameContains(@RequestParam String propertyName){
		return this.iPropertyService.getByPropertyNameContains(propertyName);
	}
	
	@GetMapping("/getAllByPage")
	DataResult<List<Property>> getAll(int pageNo, int pageSize){
		return this.iPropertyService.getAll(pageNo, pageSize);
	}
	
	@GetMapping("/getAllDesc")
	public DataResult<List<Property>> getAllSorted() {
		return this.iPropertyService.getAllSorted();
	}
	
	
}

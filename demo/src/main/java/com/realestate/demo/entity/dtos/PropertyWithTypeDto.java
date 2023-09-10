package com.realestate.demo.entity.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyWithTypeDto {
	/*data transformation object DTO
//written for providing details. These parameters are used in manager and service.
 * */
 
	
	private int propertyId;
	private String propertyName;
	private String typeName;
	private int typeId;
	
}

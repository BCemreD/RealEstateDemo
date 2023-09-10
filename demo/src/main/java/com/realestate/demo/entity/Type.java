package com.realestate.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "types")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "properties"})//to avoid recursive results and provide lazy loading
public class Type {
//this class holds properties' other qualities such as bein villa, flat, residence and so on.
	@Id
	@Column(name = "type_id")
	private int typeId;
	@Column(name = "type_name")
	private String typeName;
	
	
	@OneToMany(mappedBy = "type") 
	private List<Property>properties;

}

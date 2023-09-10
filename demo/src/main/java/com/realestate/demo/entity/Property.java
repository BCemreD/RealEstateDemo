package com.realestate.demo.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "properties")
public class Property {
	//my first object for houses, villas etc.

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)//to add id acc auto.
	@Column(name = "property_id")
	private int propertyId;
	@Column(name = "property_name")
	private String propertyName;
	@Column (name = "address")
	private String address;
	@Column(name = "description")
	private String description;
	@Column(name = "size")
	private int size;
	@Column(name="is_rent") //to decide if the property is for sale or rent
	boolean isRent;
	@Column(name = "price")
	private int price;

	@ManyToOne()
    @JoinColumn(name = "type_id")
    private Type type;
}

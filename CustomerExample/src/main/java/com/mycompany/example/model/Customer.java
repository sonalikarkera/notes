package com.mycompany.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Immutable;
import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "customer")
@Immutable
public class Customer {
	@Id
	@Column(name = "id")
	private int id;
	@NotNull
	private String type = null;

	@Length(min =6)
	private String name = null;
	public Customer(  String name,String type) {
		super();

		this.name = name;
		this.type = type;
	}

}
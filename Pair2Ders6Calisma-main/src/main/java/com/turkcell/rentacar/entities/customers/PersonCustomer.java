package com.turkcell.rentacar.entities.customers;

import com.turkcell.rentacar.core.entities.BaseCustomerEntitity;
import com.turkcell.rentacar.core.entities.BaseEntity;
import com.turkcell.rentacar.entities.concretes.Brand;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="personCustomers")
public class PersonCustomer extends BaseCustomerEntitity{
	@Column(name = "firstName")
	private String firstName;
	@Column(name = "lastName")
	private String lastName;	
	@Column(name ="nationalId")
	private String nationalId;
	
}

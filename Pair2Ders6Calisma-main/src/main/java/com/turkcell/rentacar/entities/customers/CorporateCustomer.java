package com.turkcell.rentacar.entities.customers;

import com.turkcell.rentacar.core.entities.BaseCustomerEntitity;

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
@Table(name="corporateCustomers")
public class CorporateCustomer extends BaseCustomerEntitity{
	@Column(name = "corporateName")
	private String corporateName;
	@Column(name = "taxIdNumber")
	private String taxIdNumber;
	
}

package com.example.asyncrestapi.model;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class EmployeeAddresses implements Serializable {

	private static final long serialVersionUID = 6822909773594610374L;

	public List<EmployeeAddress> employeeAddressList;
	
}

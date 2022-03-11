package com.example.asyncrestapi.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class EmployeeName implements Serializable {

	private static final long serialVersionUID = -1773599508061743940L;

	public String firstName;
	public String lastName;
	
}

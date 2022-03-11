package com.example.asyncrestapi.model;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class EmployeePhone implements Serializable {

	private static final long serialVersionUID = 3705958972000701963L;

	public List<String> phoneNumbers;
	
}

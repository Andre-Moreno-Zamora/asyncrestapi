package com.example.asyncrestapi.model;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class EmployeeCategory implements Serializable {
	
	private static final long serialVersionUID = -4460779733748460597L;

	public List<String> categories;
	
}

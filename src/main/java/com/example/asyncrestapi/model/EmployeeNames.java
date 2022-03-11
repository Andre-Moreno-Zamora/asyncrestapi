package com.example.asyncrestapi.model;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class EmployeeNames implements Serializable {
	
	private static final long serialVersionUID = -1773599508061743940L;

	public List<EmployeeName> employeeNameList;

}

package com.example.asyncrestapi.controller;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.asyncrestapi.model.EmployeeAddresses;
import com.example.asyncrestapi.model.EmployeeCategory;
import com.example.asyncrestapi.model.EmployeeNames;
import com.example.asyncrestapi.model.EmployeePhone;
import com.example.asyncrestapi.service.AsyncService;

@RestController
public class AsyncController {
	
	private static Logger log = LoggerFactory.getLogger(AsyncController.class);
	
	@Autowired
	private AsyncService service;
	
	@RequestMapping(value = "/testAsynch", method = RequestMethod.GET)
	public void testAsynch() throws InterruptedException, ExecutionException {
		log.info("testAsynch start");
		
		CompletableFuture<EmployeeAddresses> employeeAddress = service.getEmployeeAddress();
		CompletableFuture<EmployeeNames> employeeName = service.getEmployeeName();
		CompletableFuture<EmployeePhone> employeePhone = service.getEmployeePhone();
		CompletableFuture<EmployeeCategory> employeeCategory = service.getEmployeeCategory();
		
		// Wait until they are all done
		CompletableFuture.allOf(employeeAddress, employeeName, employeePhone, employeeCategory).join();
		
		log.info("EmployeeAddress--> " + employeeAddress.get());
		log.info("EmployeeName--> " + employeeName.get());
		log.info("EmployeePhone--> " + employeePhone.get());
		log.info("EmployeeCategory--> " + employeeCategory.get());
	}

}

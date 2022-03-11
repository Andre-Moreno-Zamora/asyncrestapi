package com.example.asyncrestapi.service;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.asyncrestapi.model.EmployeeAddress;
import com.example.asyncrestapi.model.EmployeeAddresses;
import com.example.asyncrestapi.model.EmployeeCategory;
import com.example.asyncrestapi.model.EmployeeNames;
import com.example.asyncrestapi.model.EmployeePhone;

@Service
public class AsyncService {

	private static Logger log = LoggerFactory.getLogger(AsyncService.class);
	
	@Autowired
	@Lazy
	private RestTemplate restTemplate;
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Async("asyncExecutor")
	public CompletableFuture<EmployeeNames> getEmployeeName() throws InterruptedException {
		log.info("getEmployeeName starts");
		
		EmployeeNames employeeNameData = restTemplate.getForObject("http://localhost:8083/names", EmployeeNames.class);
				
		log.info("employeeNameData, {}", employeeNameData);
		Thread.sleep(1000L); // Intentional delay
		log.info("employeeNameData completed");
		return CompletableFuture.completedFuture(employeeNameData);
	}
	
	@Async("asyncExecutor")
	public CompletableFuture<EmployeeAddresses> getEmployeeAddress() throws InterruptedException {
		log.info("getEmployeeAddress starts");
		
		EmployeeAddresses employeeAddressData = restTemplate.getForObject("http://localhost:8083/addresses", EmployeeAddresses.class);
		
		log.info("employeeAddressData, {}", employeeAddressData);
		Thread.sleep(1000L); // Intentional delay
		log.info("employeeAddressData completed");
		return CompletableFuture.completedFuture(employeeAddressData);
	}
	
	@Async("asyncExecutor")
	public CompletableFuture<EmployeePhone> getEmployeePhone() throws InterruptedException {
		log.info("getEmployeePhone starts");
		
		EmployeePhone employeePhoneData = restTemplate.getForObject("http://localhost:8083/phones", EmployeePhone.class);
		
		log.info("employeePhoneData, {}", employeePhoneData);
		Thread.sleep(1000L); // Intentional delay
		log.info("employeePhoneData completed");
		return CompletableFuture.completedFuture(employeePhoneData);
	}
	
	@Async("asyncExecutor")
	public CompletableFuture<EmployeeCategory> getEmployeeCategory() throws InterruptedException {
		log.info("getEmployeeCategory starts");
		
		EmployeeCategory employeeCategoryData = restTemplate.getForObject("http://localhost:8083/categories", EmployeeCategory.class);
		
		log.info("employeeCategoryData, {}", employeeCategoryData);
		Thread.sleep(1000L); // Intentional delay
		log.info("employeeCategoryData completed");
		return CompletableFuture.completedFuture(employeeCategoryData);
	}
}

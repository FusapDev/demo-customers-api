package ar.com.fusap.sample.service;

import java.util.List;

import ar.com.fusap.sample.dto.CustomerRequestDto;
import ar.com.fusap.sample.dto.CustomerResponseDto;
import ar.com.fusap.sample.exception.CustomerConflictException;
import ar.com.fusap.sample.exception.CustomerNotFoundException;


public interface ICustomerService {

	public CustomerResponseDto get(Integer customerId) throws Exception, CustomerNotFoundException;
	
	public List<CustomerResponseDto> getAll() throws Exception;
	
	public void create(CustomerRequestDto request) throws Exception, CustomerConflictException;
	
	public void update(Integer customerId, CustomerRequestDto request) throws Exception, CustomerNotFoundException, CustomerConflictException;
	
	public void delete(Integer customerId) throws Exception, CustomerNotFoundException;
	
}

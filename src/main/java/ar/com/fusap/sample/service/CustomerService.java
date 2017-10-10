package ar.com.fusap.sample.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.fusap.sample.dto.CustomerRequestDto;
import ar.com.fusap.sample.dto.CustomerResponseDto;
import ar.com.fusap.sample.entity.Customer;
import ar.com.fusap.sample.exception.CustomerConflictException;
import ar.com.fusap.sample.exception.CustomerNotFoundException;
import ar.com.fusap.sample.repository.CustomerRepository;


@Service
@Transactional(rollbackFor={Exception.class, CustomerNotFoundException.class, CustomerConflictException.class})
public class CustomerService implements ICustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	
	@Override
	public CustomerResponseDto get(Integer customerId) throws Exception, CustomerNotFoundException {

		Customer customer = customerRepository.findOne(customerId);
		if(customer == null)
			throw new CustomerNotFoundException();
		
		// At this point we can use a reflection library.
		CustomerResponseDto customerResponse = new CustomerResponseDto();
		customerResponse.setId(customer.getId());
		customerResponse.setName(customer.getName());
		customerResponse.setAddress(customer.getAddress());
		
		return customerResponse;
	}


	@Override
	public List<CustomerResponseDto> getAll() throws Exception {

		List<CustomerResponseDto> customerResponseList = new ArrayList<CustomerResponseDto>();
		
		for(Customer customer : customerRepository.findAll()) {
			CustomerResponseDto customerResponse = new CustomerResponseDto();
			customerResponse.setId(customer.getId());
			customerResponse.setName(customer.getName());
			customerResponse.setAddress(customer.getAddress());
			customerResponseList.add(customerResponse);
		}
		
		return customerResponseList;
	}


	@Override
	public void create(CustomerRequestDto request) throws Exception, CustomerConflictException {		
		
		if(customerRepository.findByName(request.getName()) != null)
			throw new CustomerConflictException();
		
		Customer customer = new Customer();
		customer.setName(request.getName());
		customer.setAddress(request.getAddress());
		customerRepository.save(customer);
	}


	@Override
	public void update(Integer customerId, CustomerRequestDto request) throws Exception, CustomerNotFoundException, CustomerConflictException {
		
		Customer customer = customerRepository.findOne(customerId);
		if(customer == null)
			throw new CustomerNotFoundException();
		
		Customer customerByName = customerRepository.findByName(request.getName());
		if(customerByName != null && customerByName.getId().compareTo(customerId) != 0)
			throw new CustomerConflictException();
		
		customer.setName(request.getName());
		customer.setAddress(request.getAddress());
		customerRepository.save(customer);
	}


	@Override
	public void delete(Integer customerId) throws Exception, CustomerNotFoundException {

		Customer customer = customerRepository.findOne(customerId);
		if(customer == null)
			throw new CustomerNotFoundException();
		
		// We could implement a logical deletion
		customerRepository.delete(customer);
	}
}

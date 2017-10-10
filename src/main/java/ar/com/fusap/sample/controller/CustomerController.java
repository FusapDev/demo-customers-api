package ar.com.fusap.sample.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.fusap.sample.dto.CustomerRequestDto;
import ar.com.fusap.sample.dto.CustomerResponseDto;
import ar.com.fusap.sample.exception.CustomerUnprocessableEntityException;
import ar.com.fusap.sample.service.ICustomerService;


@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/customers")
public class CustomerController {

	
	@Autowired
	private ICustomerService customerService;
	

	@RequestMapping(
		method = RequestMethod.GET,
		value = "/{id}",
		produces = "application/json"
	)
	public @ResponseBody CustomerResponseDto get(@PathVariable("id") Integer customerId) throws Exception {

		return customerService.get(customerId);
	}
	

	@RequestMapping(
		method = RequestMethod.GET,
		produces = "application/json"
	)
	public @ResponseBody List<CustomerResponseDto> getAll() throws Exception {

		return customerService.getAll();
	}
	

	@RequestMapping(
		method = RequestMethod.POST,
		produces = "application/json"
	)
	public @ResponseBody void create(@RequestBody @Valid CustomerRequestDto request, BindingResult result, Model model) throws Exception {
		
		if(result.hasErrors()) {
			throw new CustomerUnprocessableEntityException();
		}
		
		customerService.create(request);
	}


	@RequestMapping(
		method = RequestMethod.PUT,
		value = "/{id}",
		produces = "application/json"
	)
	public @ResponseBody void update(
		@PathVariable("id") Integer customerId,
		@RequestBody @Valid CustomerRequestDto request, BindingResult result, Model model) throws Exception {
		
		if(result.hasErrors()) {
			throw new CustomerUnprocessableEntityException();
		}
		
		customerService.update(customerId, request);
	}


	@RequestMapping(
		method = RequestMethod.DELETE,
		value = "/{id}",
		produces = "application/json"
	)
	public @ResponseBody void delete(@PathVariable("id") Integer customerId) throws Exception {
		
		customerService.delete(customerId);
	}
	
}

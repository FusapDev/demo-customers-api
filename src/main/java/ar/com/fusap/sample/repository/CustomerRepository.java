package ar.com.fusap.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.fusap.sample.entity.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	/**
	 * search a customer by name
	 * @param name
	 * @return
	 */
	public Customer findByName(String name);

}

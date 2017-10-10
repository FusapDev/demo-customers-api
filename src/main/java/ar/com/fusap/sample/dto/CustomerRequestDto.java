package ar.com.fusap.sample.dto;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerRequestDto {
	
	@NotEmpty()
	@JsonProperty("name")
	private String name;
	
	@NotEmpty()
	@JsonProperty("address")
	private String address;

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}

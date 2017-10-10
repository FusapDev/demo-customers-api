package ar.com.fusap.sample.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import ar.com.fusap.sample.base.BaseEntity;

@Entity
@Table(name="customer")
public class Customer extends BaseEntity { 

	@Column(name="name", nullable = false, length = 255)
	private String name;

	@Column(name="address", nullable = false, length = 255)
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

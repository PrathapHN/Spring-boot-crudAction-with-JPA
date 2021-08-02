package com.example.demo;

/**
 * 
 * 
 * @author prathapa
 * 
 * 
 */
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity

@Table(name = "employee")
public class Employee {
	
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "second_name")
	private String secondName;
	
	@OneToOne(mappedBy = "address")
	private Address address;
	
	
	
	public int getID() {
		return id;
	}
	public void setID(int iD) {
		id = iD;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String nAME) {
		firstName = nAME;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(String fIRST_NAME) {
		secondName = fIRST_NAME;
	}
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public int hashCode() {
		return Objects.hash(address, firstName, id, secondName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(address, other.address) && Objects.equals(firstName, other.firstName) && id == other.id
				&& Objects.equals(secondName, other.secondName);
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", secondName=" + secondName + ", address=" + address
				+ "]";
	}
	
	
	
	
	
	 
	

}

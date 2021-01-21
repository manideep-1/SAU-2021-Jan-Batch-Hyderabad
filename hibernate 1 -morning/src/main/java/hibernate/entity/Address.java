package hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "addId")
	private int addId;
	@Column
	private String addressLine1;
	@Column
	private String addressLine2;
	@Column
	private int pin;
	@Column
	private String state;
	@Column
	private String country;
	@ManyToOne//(fetch = FetchType.EAGER)
	private Employee employee;
	
//	public Address(String string, String string2, int i, String string3, String string4) {
//		
//	}
	public Address(String addressLine1,String addressLine2,int pin,String state,String country) {
		
		this.addressLine1=addressLine1;
		this.addressLine2=addressLine2;
		this.country=country;
		this.state=state;
		this.pin=pin;
		
	}
	public int getAddId() {
		return addId;
	}

	public void setAddId(int addId) {
		this.addId = addId;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	@Override
	public String toString() {
		return "Address [addId=" + addId + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2
				+ ", pin=" + pin + ", state=" + state + ", country=" + country + ", employee=" + employee + "]";
	}
	
	
	
	
}

package hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class EmployeeDetails {
	
	@Id
	@Column(name="EmpDetId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int EmpDetId;
	@Column
	private String number;
	@Column
	private String email;
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getEmpDetId() {
		return EmpDetId;
	}
	public void setEmpDetId(int empDetId) {
		EmpDetId = empDetId;
	}
	
	

}

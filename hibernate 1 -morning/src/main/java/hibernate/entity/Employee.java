package hibernate.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="EmployeeTable")
public class Employee {
	
	@Id
	@Column(name="Id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int EmployeeId;
	
	@Column(name="First_Name" , length=25)
	private String firstName;
	
	@Column(name="Last_Name")
	private String lastName;
	
	@Temporal(TemporalType.DATE)
	private Date joiningDate;
	
	@ElementCollection(fetch=FetchType.EAGER)
	private List<String> skillSet=new ArrayList<>();
	
//	@OneToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name="EmpDetId")
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name="employeetodetailsjointable", joinColumns = @JoinColumn(name="EMPLOYEE_ID"),
	inverseJoinColumns = @JoinColumn(name="EmpDetId"))
//	private AccountEntity account;
	private EmployeeDetails empdetails;
	
	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="AddressId")
    private Collection<Address> addresses=new HashSet<>();
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="EmployeeSessions",joinColumns=@JoinColumn(name="empId"),inverseJoinColumns=@JoinColumn(name="sessionId"))
	private Collection< ILearnSessions> iLearnsession=new HashSet<>();//iLearnSession
	
	
	public Collection<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Collection<Address> addresses) {
		this.addresses = addresses;
	}

	public Collection<ILearnSessions> getiLearnsession() {
		return iLearnsession;
	}

	public void setiLearnsession(Collection<ILearnSessions> iLearnsession) {
		this.iLearnsession = iLearnsession;
	}
	
	

	public EmployeeDetails getEmpdetails() {
		return empdetails;
	}

	public void setEmpdetails(EmployeeDetails empdetails) {
		this.empdetails = empdetails;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public List<String> getSkillSet() {
		return skillSet;
	}

	public void setSkillSet(List<String> skillSet) {
		this.skillSet = skillSet;
	}
	public Employee() {
		
	}
	public Employee(String firstName, String lastName,Date date) {
		super();
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.joiningDate=date;
		
	}

	public int getEmployeeId() {
		return EmployeeId;
	}

	public void setEmployeeId(int employeeId) {
		EmployeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	

}

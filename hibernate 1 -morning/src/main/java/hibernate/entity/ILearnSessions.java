package hibernate.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
@Entity
public class ILearnSessions {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int sessionId;
	
	private String SessionName;
	
	
	
	@ManyToMany(mappedBy="iLearnsession")
	private List<Employee> emps=new ArrayList<>();
	
	
	public List<Employee> getEmps() {
		return emps;
	}
	public void setEmps(List<Employee> emps) {
		this.emps = emps;
	}
	public int getSessionId() {
		return sessionId;
	}
	public void setSessionId(int sessionId) {
		this.sessionId = sessionId;
	}
	public String getSessionName() {
		return SessionName;
	}
	public void setSessionName(String sessionName) {
		SessionName = sessionName;
	}
	
	

}

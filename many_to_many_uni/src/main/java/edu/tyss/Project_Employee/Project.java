package edu.tyss.Project_Employee;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Project {
	@Id
	private int id;
	private String p_name;
	private String status;
	private int team_member;
	
	@ManyToMany
	private List<Employee> employees;
	
	public Project() {
	}

	public Project(int id, String p_name, String status, int team_member) {
		this.id = id;
		this.p_name = p_name;
		this.status = status;
		this.team_member = team_member;
	}

	public int getId() {
		return id;
	}

	public String getP_name() {
		return p_name;
	}

	public String getStatus() {
		return status;
	}

	public int getTeam_member() {
		return team_member;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setTeam_member(int team_member) {
		this.team_member = team_member;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", p_name=" + p_name + ", status=" + status + ", team_member=" + team_member
				+ ", employees=" + employees + "]";
	}
	
	

}

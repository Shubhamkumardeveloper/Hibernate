package edu.tyss.companyApp.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Company {
	@Id
	private int id;
	private String name;
	private String gstNo;
	private String reg_No;
	
	@OneToMany
	private List<Employee> employees;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getGstNo() {
		return gstNo;
	}

	public String getReg_No() {
		return reg_No;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}

	public void setReg_No(String reg_No) {
		this.reg_No = reg_No;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
}

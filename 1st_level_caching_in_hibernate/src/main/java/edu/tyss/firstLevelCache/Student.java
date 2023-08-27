package edu.tyss.firstLevelCache;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "Student_Record")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rol;
	private String name;
	private String email;
	
	public int getRol() {
		return rol;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public void setRol(int rol) {
		this.rol = rol;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Student [rol=" + rol + ", name=" + name + ", email=" + email + "]";
	}

	
	
}

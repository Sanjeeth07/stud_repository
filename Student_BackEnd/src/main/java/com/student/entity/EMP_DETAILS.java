package com.student.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="EMP_DETAILS")
@Entity
public class EMP_DETAILS implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2346714226674531985L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	int emp_Id;
	
	@Column
	String emp_name;
	
	
	public int getEmp_Id() {
		return emp_Id;
	}
	public void setEmp_Id(int emp_Id) {
		this.emp_Id = emp_Id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

}

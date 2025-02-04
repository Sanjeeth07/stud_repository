package com.student.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Stud")
public class Excel_Student implements Serializable {

		/**
	 * 
	 */
	private static final long serialVersionUID = 6747319112087360188L;@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;	
		public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

		@Column
	    private String name;
		@Column
		 private String emailAddress;
		@Column
	    private String purchasedPackage;
	  
	    public Excel_Student() {}
	  
	    public String getEmailAddress() {
	        return emailAddress;
	    }
	  
	    public String getName() {
	        return name;
	    }
	  
	    public String getPurchasedPackage() {
	        return purchasedPackage;
	    }
	  
	    public void setEmailAddress(String emailAddress) {
	        this.emailAddress = emailAddress;
	    }
	  
	    public void setName(String name) {
	        this.name = name;
	    }
	  
	    public void setPurchasedPackage(String purchasedPackage) {
	        this.purchasedPackage = purchasedPackage;
	    }
}

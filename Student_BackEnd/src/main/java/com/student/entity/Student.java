package com.student.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.function.SQLFunctionRegistry;
import org.hibernate.mapping.Selectable;

@Entity
@Table(name="Student")
public class Student  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -901934147594407441L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rollNo;	
	
	@Column
	private String name;
	@Column
	private int tamilMark;
	@Column
	private int englishMark;
	@Column
	private int mathsMark;
	@Column
	private int scienceMark;
	@Column
	private int socialMark;
	@Column
	private int totalMark;
	/*
	 * @Column private String userName;
	 * 
	 * private boolean editEnabled = false;
	 */
	
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * public String getUserName() { return userName; } public void
	 * setUserName(String userName) { this.userName = userName; } public boolean
	 * isEditEnabled() { return editEnabled; } public void setEditEnabled(boolean
	 * editEnabled) { this.editEnabled = editEnabled; }
	 */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTamilMark() {
		return tamilMark;
	}
	public void setTamilMark(int tamilMark) {
		this.tamilMark = tamilMark;
	}
	public int getEnglishMark() {
		return englishMark;
	}
	public void setEnglishMark(int englishMark) {
		this.englishMark = englishMark;
	}
	public int getMathsMark() {
		return mathsMark;
	}
	public void setMathsMark(int mathsMark) {
		this.mathsMark = mathsMark;
	}
	public int getScienceMark() {
		return scienceMark;
	}
	public void setScienceMark(int scienceMark) {
		this.scienceMark = scienceMark;
	}
	public int getSocialMark() {
		return socialMark;
	}
	public void setSocialMark(int socialMark) {
		this.socialMark = socialMark;
	}
	public int getTotalMark() {
		return totalMark;
	}
	public void setTotalMark(int totalMark) {
		this.totalMark = totalMark;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	
}

package com.student.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.entity.Student;
import com.student.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;

	public Boolean addStudent(Student student) {
		Boolean sesFlag = false;
		studentRepository.save(student);
		sesFlag = true;
		return sesFlag;

	}

	public List<Student> readAllStudentRecords() {

		List<Student> studentList = (List<Student>) studentRepository.findAll();
		return studentList;
		// TODO Auto-generated method stub

	}

	public List<Integer> viewPercentage() {
		// TODO Auto-generated method stub
		int studentCount = 0;
		int passCount = 0;
		int passPercentage = 0;
		int failPercentage = 0;
		studentCount = (int) studentRepository.count();
		List<Student> students = (List<Student>) studentRepository.findAll();		
		passCount= (int) students.stream().filter(stud -> stud.getTamilMark() >= 35)
				.filter(stud -> stud.getEnglishMark() >= 35).filter(stud -> stud.getMathsMark() >= 35)
				.filter(stud -> stud.getScienceMark() >= 35).filter(stud -> stud.getSocialMark() >= 35).count();				
		passPercentage = passPercentage + (passCount * 100) / studentCount;
		failPercentage = failPercentage + (studentCount - passCount) * 100 / studentCount;
		List<Integer> passfail = new ArrayList<Integer>();
		passfail.add(failPercentage);
		passfail.add(passPercentage);
		return passfail;
	}

	public Optional<Student> readStudentsById(int rollNo) {
		// TODO Auto-generated method stub
		Optional<Student> student = studentRepository.findById(rollNo);
		return student;
	}

	public Boolean updateStudentsById(Student student) {
		// TODO Auto-generated method stub
		Student stud = new Student();
		stud.setRollNo(student.getRollNo());
		stud.setName(student.getName());
		stud.setTamilMark(student.getTamilMark());
		stud.setEnglishMark(student.getEnglishMark());
		stud.setMathsMark(student.getMathsMark());
		stud.setScienceMark(student.getScienceMark());
		stud.setSocialMark(student.getSocialMark());
		stud.setTotalMark(student.getTotalMark());
		studentRepository.save(stud);
		return true;

	}

}

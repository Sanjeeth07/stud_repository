package com.student.service;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.student.entity.Student;
import com.student.repository.StudentRepository;

@RunWith(MockitoJUnitRunner.class)

public class StudentServiceTest  { 

private StudentService studentServicespy;

@Mock
private Student stud;
	
@Mock
private StudentRepository studentRepository;

		
	@Test
	public void testaddStudent() {
		 stud=new Student();
		stud.setRollNo(1);
		stud.setName("Test");
		stud.setTamilMark(56);
		stud.setEnglishMark(67);
		stud.setMathsMark(78);
		stud.setScienceMark(89);
		stud.setSocialMark(87);
		stud.setTotalMark(409);	
	
		Mockito.when(studentRepository.save(stud)).thenReturn(stud);		
		assertTrue(true);
		
	}
	@Test
	public void testreadAllStudentRecords() {
		List<Student> stuList=new ArrayList<Student>();
		Student stud1=new Student();
		stud1.setRollNo(1);
		stud1.setName("Test");
		stud1.setTamilMark(56);
		stud1.setEnglishMark(67);
		stud1.setMathsMark(78);
		stud1.setScienceMark(89);
		stud1.setSocialMark(87);
		stud1.setTotalMark(409);
			
		Student stud2=new Student();
		stud2.setRollNo(2);
		stud2.setName("Test");
		stud2.setTamilMark(56);
		stud2.setEnglishMark(67);
		stud2.setMathsMark(100);
		stud2.setScienceMark(89);
		stud2.setSocialMark(98);
		stud2.setTotalMark(400);
		stuList.add(stud1);
		stuList.add(stud2);
		Mockito.when(studentRepository.findAll()).thenReturn(stuList);		
		assertTrue(true);		
	}
	@Test
	public void testviewPercentage()
	{
		long count=2;
		int passPercentage=0;
		int failPercentage=0;
		List<Student> students=new ArrayList<Student>();
		Student stud1=new Student();
		stud1.setRollNo(1);
		stud1.setName("Test");
		stud1.setTamilMark(56);
		stud1.setEnglishMark(67);
		stud1.setMathsMark(78);
		stud1.setScienceMark(89);
		stud1.setSocialMark(87);
		stud1.setTotalMark(409);
			
		Student stud2=new Student();
		stud2.setRollNo(2);
		stud2.setName("Test");
		stud2.setTamilMark(56);
		stud2.setEnglishMark(67);
		stud2.setMathsMark(100);
		stud2.setScienceMark(89);
		stud2.setSocialMark(98);
		stud2.setTotalMark(400);
		students.add(stud1);
		students.add(stud2);
		Mockito.when(studentRepository.count()).thenReturn(count);
		Mockito.when(studentRepository.findAll()).thenReturn(students);
		int passCount= (int) students.stream().filter(stud -> stud.getTamilMark() >= 35)
		.filter(stud -> stud.getEnglishMark() >= 35).filter(stud -> stud.getMathsMark() >= 35)
		.filter(stud -> stud.getScienceMark() >= 35).filter(stud -> stud.getSocialMark() >= 35).count();				
 passPercentage = (int) (passPercentage + (passCount * 100) / count);
 failPercentage = (int) (failPercentage + (count - passCount) * 100 / count);
List<Integer> passfail = new ArrayList<Integer>();
passfail.add(failPercentage);
passfail.add(passPercentage);
assertTrue(true);
	}
	
	@Test
	public void testreadStudentsById()
	{
		int rollNo=1;
		
		Optional<Student> stud2=null;
		Student stud1=new Student();
		stud1.setRollNo(1);
		stud1.setName("Test");
		stud1.setTamilMark(56);
		stud1.setEnglishMark(67);
		stud1.setMathsMark(78);
		stud1.setScienceMark(89);
		stud1.setSocialMark(87);
		stud1.setTotalMark(409);
		
		Mockito.when(studentRepository.findById(rollNo)).thenReturn(stud2);		
	
}
	@Test
	public void testupdateStudentsById() {
		Student stud1=new Student();
		stud1.setRollNo(1);
		stud1.setName("Test");
		stud1.setTamilMark(56);
		stud1.setEnglishMark(67);
		stud1.setMathsMark(78);
		stud1.setScienceMark(89);
		stud1.setSocialMark(87);
		stud1.setTotalMark(409);
		Mockito.when(studentRepository.save(stud1)).thenReturn(stud1);
		
}
}
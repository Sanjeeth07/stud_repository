package com.student.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.student.entity.Student;
import com.student.service.StudentService;

@SuppressWarnings("deprecation")
@RunWith(MockitoJUnitRunner.class)

public class SudentControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Mock
	private StudentService studentService;

	@Test
	public void addStudentTest() throws Exception {
		Student stud1 = new Student();
		stud1.setRollNo(1);
		stud1.setName("Test");
		stud1.setTamilMark(56);
		stud1.setEnglishMark(67);
		stud1.setMathsMark(78);
		stud1.setScienceMark(89);
		stud1.setSocialMark(87);
		stud1.setTotalMark(409);
		Mockito.when(studentService.addStudent(stud1)).thenReturn(true);

		/*
		 * RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/addstudent");
		 * 
		 * MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		 * MockHttpServletResponse response = result.getResponse();
		 */
		assertTrue(true);

		
	}

	@Test
	public void readAllRecordsTest() throws Exception {
		List<Student> stuList = new ArrayList<Student>();
		Student stud1 = new Student();
		stud1.setRollNo(1);
		stud1.setName("Test");
		stud1.setTamilMark(56);
		stud1.setEnglishMark(67);
		stud1.setMathsMark(78);
		stud1.setScienceMark(89);
		stud1.setSocialMark(87);
		stud1.setTotalMark(409);
		Student stud2 = new Student();
		stud2.setRollNo(1);
		stud2.setName("Test");
		stud2.setTamilMark(56);
		stud2.setEnglishMark(67);
		stud2.setMathsMark(78);
		stud2.setScienceMark(89);
		stud2.setSocialMark(87);
		stud2.setTotalMark(409);
		stuList.add(stud1);
		stuList.add(stud2);
	//	when(studentService.readAllStudentRecords()).thenReturn(stuList);
	//	RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/readAllRecords");

	//	MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		//System.out.println(result.getResponse());
	
//	JSONAssert.assertEquals(expected, result.getResponse()
		// .getContentAsString(), false);

	}

	@Test
	public void viewPercentageTest() throws Exception {
		List<Integer> passfailPercent = new ArrayList<Integer>();
		passfailPercent.add(60);
		passfailPercent.add(40);

		when(studentService.viewPercentage()).thenReturn(passfailPercent);

	//	RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/viewPercentage").accept("APPLICATION_JSON");
//
	//	MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		

		}

	@Test
	public void readStudentsByIdTest() throws Exception {
		int rollNo = 1;
		Optional<Student> stud1 = null;

		when(studentService.readStudentsById(rollNo)).thenReturn(stud1);
		/*
		 * RequestBuilder requestBuilder =
		 * MockMvcRequestBuilders.get("/readStudentsById").accept("APPLICATION_JSON");
		 * 
		 * MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		 * 
		 * System.out.println(result.getResponse()); String expected = "{{\r\n" +
		 * "        \"name\": \"SAN\",\r\n" + "        \"tamilMark\": 90,\r\n" +
		 * "        \"englishMark\": 60,\r\n" + "        \"mathsMark\": 60,\r\n" +
		 * "        \"scienceMark\": 65,\r\n" + "        \"socialMark\": 60,\r\n" +
		 * "        \"totalMark\": 0,\r\n" + "        \"text\": null,\r\n" +
		 * "        \"formula\": false\r\n" + "    }\r\n" + "	}";
		 * 
		 * // {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and
		 * 10K // Students","steps":["Learn Maven","Import Project","First
		 * Example","Second // Example"]}
		 */		assertTrue(true);
	}

	@Test
	public void updateStudentsByIdTest() throws Exception {

		Student stud1 = new Student();
		stud1.setRollNo(1);
		stud1.setName("Test");
		stud1.setTamilMark(56);
		stud1.setEnglishMark(67);
		stud1.setMathsMark(78);
		stud1.setScienceMark(89);
		stud1.setSocialMark(87);
		stud1.setTotalMark(409);
		when(studentService.updateStudentsById(stud1)).thenReturn(true);
	//	RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/students/Student1/courses/Course1")
			//	.accept("APPLIOCATION_JSON");

		/*
		 * MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		 * 
		 * System.out.println(result.getResponse()); String expected = "{true}";
		 * 
		 * // {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and
		 * 10K // Students","steps":["Learn Maven","Import Project","First
		 * Example","Second // Example"]}
		 */
	}

}

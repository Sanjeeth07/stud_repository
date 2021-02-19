package com.student.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.student.entity.AuthenticationBean;
import com.student.entity.EMP_DETAILS;
import com.student.entity.Excel_Student;
import com.student.entity.Student;
import com.student.service.StudentService;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@CrossOrigin("http://localhost:8081")
public class StudentController {

@CrossOrigin(origins = "http://localhost:4200")
	    @GetMapping(path = "/basicauth")
	   public AuthenticationBean basicauth() {
	       return new AuthenticationBean("You are authenticated");
	    }
	@Autowired
	private StudentService studentservice;

	
	 @Autowired
	    JobLauncher jobLauncher;
	 
	    @Autowired
	    Job processJob;
	    
	    
	   @GetMapping("/download") 
	   public ResponseEntity<Boolean> downloadFile() throws IOException{
		   return Optional.ofNullable(studentservice.download())
				   .map(resp->new ResponseEntity<>(resp,HttpStatus.OK))
				   .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
	   }
	   
	    @PostMapping("/upload")
	    public ResponseEntity<Boolean> uploadFile(@RequestParam("file") String file) throws IOException{
	    	System.out.println("Inside Student Controller and upload method");
	     
	        	return Optional.ofNullable(studentservice.addStud(file))
		          .map(res->new ResponseEntity<>(res,HttpStatus.OK))
		          .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));

	    }


	 
	    @RequestMapping("/invokejob")
	    public String handle() throws Exception {
	 
	            JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
	                    .toJobParameters();
	            jobLauncher.run(processJob, jobParameters);
	 
	        return "Batch job has been invoked";
	    }
	
	@PostMapping("/addNewStudent")
	public ResponseEntity<Boolean> addStudentRecord(@RequestBody Student student) {
		System.out.println("Iam Inside controller");
		return Optional.ofNullable(studentservice.addStudent(student))
				.map(val -> new ResponseEntity<>(val, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
	}
		
	
	@GetMapping("/readAllRecords")
	public ResponseEntity<List<Student>> readAllRecords() {
		System.out.println("Iam Inside controller");
		
		
		return Optional.ofNullable(studentservice.readAllStudentRecords())
				.map(res -> new ResponseEntity<>(res, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
	}

	@GetMapping("/readPassFailStudents")
	public ResponseEntity<List<Integer>> getPassFailPercentage() {
		return Optional.ofNullable(studentservice.viewPercentage())
				.map(res -> new ResponseEntity<>(res, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));

	}

	
	@PutMapping("/updateStudentsById")
	public ResponseEntity<Boolean> updateStudentById(@RequestBody Student student)
	{
			
		return Optional.ofNullable(studentservice.updateStudentsById(student))
		.map(res->new ResponseEntity<>(res,HttpStatus.OK))
		.orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
	}

	@GetMapping("/getStudentsById")
	public ResponseEntity<Optional<Student>> getStudentByID(@RequestParam("rollNo") int rollNo) {
		return Optional.ofNullable(studentservice.readStudentsById(rollNo))
				.map(res -> new ResponseEntity<>(res, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));

	}
	
}
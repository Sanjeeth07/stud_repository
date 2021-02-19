package com.student.batch;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.excel.RowMapper;
import org.springframework.batch.item.excel.mapping.BeanWrapperRowMapper;
import org.springframework.batch.item.excel.poi.PoiItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.student.controller.StudentController;
import com.student.entity.Excel_Student;
import com.student.repository.Batch_Repo;
import com.student.service.StudentService;


public class Reader implements ItemReader<String>{
	

	private String[] messages = { "javainuse.com",
			"Welcome to Spring Batch Example",
			"We use H2 Database for this example" };
	@Autowired
	private StudentController studentcontroller;
	@Autowired
	private StudentService studentservice;
	@Autowired
	private Batch_Repo batch_repo;
	private int count = 0;
List<Excel_Student>listval=new ArrayList<Excel_Student>();
List<Excel_Student> tutorials = new ArrayList<Excel_Student>();
	List<String> res=new ArrayList<String>();


	  Excel_Student tutorial = new Excel_Student();
	@Override
	public String read()
			throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		try {
			System.out.println("Inside Service.excel to TZutorials");
			 File file =    new File("E:\\Student_Bend\\Student_BackEnd\\src\\main\\resources\\students.xlsx");
			  FileInputStream inputStream = new FileInputStream(file);
		String fileName="students.xlsx";
			 //   Workbook workbook = null;
		      Workbook workbook = new XSSFWorkbook(inputStream);

		      org.apache.poi.ss.usermodel.Sheet sheet =  workbook.getSheet("Sheet1");
		      Iterator<Row> rows = sheet.iterator();

		      

		      int rowNumber = 0;
		      while (rows.hasNext()) {
		        Row currentRow = rows.next();

		        // skip header
		        if (rowNumber == 0) {
		          rowNumber++;
		          continue;
		        }

		        Iterator<Cell> cellsInRow = currentRow.iterator();

		      

		        int cellIdx = 0;		       
		        while (cellsInRow.hasNext()) {
		          Cell currentCell = cellsInRow.next();

		          switch (cellIdx) {
		         
		          case 0:
		            tutorial.setName(currentCell.getStringCellValue());
		            break;

		          case 1:
		            tutorial.setEmailAddress(currentCell.getStringCellValue());
		            break;

		          case 2:
		            tutorial.setPurchasedPackage(currentCell.getStringCellValue());
		            break;

		          default:
		            break;
		          }

		          cellIdx++;
		        }

		        tutorials.add(tutorial);
		        
		       
		      }

		      workbook.close();
		      System.out.println("Tutorial"+tutorial.getEmailAddress());
		    //  studentservice.addStud();
		    //  studentcontroller.uploadFile();
		      
		      batch_repo.saveAll(tutorials);
		     // return tutorials;
	    } catch (IOException e) {
	      throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
	    }

		    
		
		        
		 
		    
		    
		    if (count < messages.length) {
				return messages.toString();
			} else {
				count = 0;
			}
			return null;//

		    }
		
			
			//return null;
			// TODO Auto-generated method stub
			
		}


	    
	
		
	



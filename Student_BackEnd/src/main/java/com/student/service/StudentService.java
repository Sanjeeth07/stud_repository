package com.student.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.student.entity.EMP_DETAILS;
import com.student.entity.Excel_Student;
import com.student.entity.Student;
import com.student.repository.Batch_Repo;
import com.student.repository.EMP_REPOSITORY;
import com.student.repository.StudentRepository;


@Service
public class StudentService {
	 static String SHEET = "Tutorials";
@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private EMP_REPOSITORY emp_repository;
	
	
	@Autowired
	private Batch_Repo batchrepo;

	public Boolean addStudent(Student student) {
		Boolean sesFlag = false;
		studentRepository.save(student);
		sesFlag = true;
		return sesFlag;

	}

	public List<Student> readAllStudentRecords() {
		System.out.println("Iam Inside service");
		List<Student> studentList = (List<Student>) studentRepository.findAll();
		return studentList;
		// TODO Auto-generated method stub

	}
	
	public Boolean addStud(String file) throws IOException {
		System.out.println("Inside Student Service and addstud method");	
		List<Excel_Student> tutorials = excelToTutorials(file);
		//Boolean sesFlag = false;	
		batchrepo.saveAll(tutorials);
		//sesFlag = true;
		return true;

	}

	@SuppressWarnings("rawtypes")
	private List<Excel_Student> excelToTutorials(String oldFilePath)  throws IOException{

		try {
			System.out.println(oldFilePath);
			System.out.println("Inside Service.excel to TZutorials");
			String newFilePath=oldFilePath.replaceAll("/","\\\\");
			System.out.println("NewPath"+newFilePath);
			 File file =    new File(newFilePath);
			  FileInputStream inputStream = new FileInputStream(file);
		String fileName="students.xlsx";
			 //   Workbook workbook = null;
		      Workbook workbook = new XSSFWorkbook(inputStream);

		      org.apache.poi.ss.usermodel.Sheet sheet =  workbook.getSheet("Student");
		      Iterator<Row> rows = sheet.iterator();

		      List<Excel_Student> tutorials = new ArrayList<Excel_Student>();

		      int rowNumber = 0;
		      while (rows.hasNext()) {
		        Row currentRow = rows.next();

		        // skip header
		        if (rowNumber == 0) {
		          rowNumber++;
		          continue;
		        }

		        Iterator<Cell> cellsInRow = currentRow.iterator();

		        Excel_Student tutorial = new Excel_Student();

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
		        System.out.println("Tutorial"+tutorial.getEmailAddress());
		      }

		      workbook.close();
		      return tutorials;
	    } catch (IOException e) {
	      throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
	    }
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
	
	public Boolean addEMP(EMP_DETAILS emp_details)
	{
		System.out.println("Iam Inside EMP SERVICE ADD");
		return true;
	}

	public List<EMP_DETAILS> view() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Iam Inside EMP SERVICE vvvvvview");
		return (List<EMP_DETAILS>) emp_repository.findAll();
	
	}

	public Boolean download()throws IOException {
		List<Excel_Student> result=(List<Excel_Student>) batchrepo.findAll();
		Boolean val=false;
		// TODO Auto-generated method stub
		downloadExcelFile(result);
		 val=true;
		
		return val;
	}
public  void downloadExcelFile(List<Excel_Student> result) throws IOException {
	String[] columns = {"Name", "Email", "Package"};
	Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

    /* CreationHelper helps us create instances of various things like DataFormat, 
       Hyperlink, RichTextString etc, in a format (HSSF, XSSF) independent way */
    CreationHelper createHelper = workbook.getCreationHelper();

    // Create a Sheet
    org.apache.poi.ss.usermodel.Sheet sheet = workbook.createSheet("Student");

    // Create a Font for styling header cells
    Font headerFont = workbook.createFont();
    headerFont.setBold(true);
    headerFont.setFontHeightInPoints((short) 14);
    headerFont.setColor(IndexedColors.RED.getIndex());

    // Create a CellStyle with the font
    CellStyle headerCellStyle = workbook.createCellStyle();
    headerCellStyle.setFont(headerFont);

    // Create a Row
    Row headerRow = sheet.createRow(0);

    // Create cells
    for(int i = 0; i < columns.length; i++) {
        Cell cell = headerRow.createCell(i);
        cell.setCellValue(columns[i]);
        cell.setCellStyle(headerCellStyle);
    }

    // Create Cell Style for formatting Date
    CellStyle dateCellStyle = workbook.createCellStyle();
    dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));

    // Create Other rows and cells with employees data
    int rowNum = 1;
    for(Excel_Student student: result) {
        Row row = sheet.createRow(rowNum++);

        row.createCell(0)
                .setCellValue(student.getName());

        row.createCell(1)
                .setCellValue(student.getEmailAddress());

        

        row.createCell(2)
                .setCellValue(student.getPurchasedPackage());
    }

	// Resize all columns to fit the content size
    for(int j = 0; j < columns.length; j++) {
        sheet.autoSizeColumn(j);
    }

    // Write the output to a file
    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
    FileOutputStream fileOut = new FileOutputStream("E:\\Student_Download\\Student_Contact"+timeStamp+".xlsx");
    workbook.write(fileOut);
    fileOut.close();

    // Closing the workbook
    workbook.close();
}

}


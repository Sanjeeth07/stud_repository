/*
 * package com.student.config;
 * 
 * import org.springframework.batch.item.ItemReader; import
 * org.springframework.batch.item.excel.mapping.BeanWrapperRowMapper; import
 * org.springframework.batch.item.excel.poi.PoiItemReader; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.core.io.ClassPathResource; import
 * org.springframework.jdbc.core.RowMapper;
 * 
 * import com.student.batch.StudentExcelRowMapper; import
 * com.student.entity.Excel_Student; import com.student.entity.Student;
 * 
 * @Configuration public class ExcelFileToDB {
 * 
 * 
 * @Bean ItemReader excelStudentReader() { PoiItemReader<Excel_Student> reader =
 * new PoiItemReader<>(); reader.setLinesToSkip(1); reader.setResource(new
 * ClassPathResource(
 * "E:\\Student_Bend\\Student_BackEnd\\src\\main\\resources\\students.xlsx"));
 * 
 * reader.setRowMapper((org.springframework.batch.item.excel.RowMapper<
 * Excel_Student>) excelRowMapper()); return reader; }
 * 
 * private RowMapper<Excel_Student> excelRowMapper() { return new
 * StudentExcelRowMapper(); }
 * 
 * }
 */
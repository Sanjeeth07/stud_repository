/*
 * package com.student.batch;
 * 
 * import java.sql.ResultSet; import java.sql.SQLException;
 * 
 * import org.springframework.batch.item.excel.support.rowset.RowSet; import
 * org.springframework.jdbc.core.RowMapper;
 * 
 * import com.student.entity.Excel_Student; import com.student.entity.Student;
 * 
 * public class StudentExcelRowMapper implements RowMapper<Excel_Student> {
 * 
 * 
 * 
 * public Excel_Student mapRow(RowSet rowSet, int rowNum) throws SQLException {
 * Excel_Student student = new Excel_Student();
 * 
 * student.setName(rowSet.getColumnValue(0));
 * student.setEmailAddress(rowSet.getColumnValue(1));
 * student.setPurchasedPackage(rowSet.getColumnValue(2));
 * 
 * return student; // TODO Auto-generated method stub return null; }
 * 
 * 
 * public Excel_Student mapRow(RowSet rowSet, int rowNum) throws SQLException {
 * // TODO Auto-generated method stub Excel_Student student = new
 * Excel_Student();
 * 
 * student.setName(rowSet.getColumnValue(0));
 * student.setEmailAddress(rowSet.getColumnValue(1));
 * student.setPurchasedPackage(rowSet.getColumnValue(2));
 * 
 * return student; }
 * 
 * @Override public Excel_Student mapRow(ResultSet rs, int rowNum) throws
 * SQLException { // TODO Auto-generated method stub return null; } }
 */
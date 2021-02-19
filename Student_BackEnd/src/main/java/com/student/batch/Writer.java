package com.student.batch;

import java.util.List;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.student.entity.Excel_Student;
import com.student.repository.Batch_Repo;


@Service
public class Writer implements ItemWriter<String> {

	@Autowired
	private Batch_Repo  batch_repo;
	@Override
	 public void write(List<? extends String> items) throws Exception {
	 // TODO Auto-generated method stub for(String item:items) {
		
	 System.out.println("Writer"+items); 
	}
	 

	
/*
 * public void write(List<? extends Excel_Student> items) throws Exception { //
 * TODO Auto-generated method stub for(Excel_Student item:items) {
 * System.out.println("Writer"+item.getName()+item.getEmailAddress()); }
 */
		
	}

	

	


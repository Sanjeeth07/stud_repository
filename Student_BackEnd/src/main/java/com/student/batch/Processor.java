package com.student.batch;

import java.util.List;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.student.entity.Excel_Student;
import com.student.repository.Batch_Repo;

public class Processor implements ItemProcessor<String, String> {


	@Autowired
	private Batch_Repo batch_repo;
	

	@Override
	public String process(String item) throws Exception {
		// TODO Auto-generated method stub

	    Excel_Student obj1=new Excel_Student();
	    obj1.setEmailAddress("test@test.com");
	  obj1.setId(44);
	    obj1.setName("JAaa");
	    obj1.setPurchasedPackage("f");
	//    batch_repo.save(obj1);
	    System.out.println("Inserting employee : " + item);
        return item;
	}

}

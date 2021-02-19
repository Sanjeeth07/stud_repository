package com.student.config;

import java.io.Reader;
import java.io.Writer;

import org.hibernate.validator.internal.util.privilegedactions.NewProxyInstance;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.student.batch.Processor;
import com.student.batch.JobCompleteListener;

@Configuration
public class SpringBatchConfig {
	
	@Autowired
	public JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Job processJob()
	{
		return jobBuilderFactory.get("Process Job")
				.incrementer(new RunIdIncrementer()).listener(listener())
				.flow(orderStep1()).end().build();

	}
	
	
	@Bean
	public Step orderStep1() {
		return stepBuilderFactory.get("orderStep1").<String, String> chunk(1)
				//.reader(com.student.batch.Reader())
				.reader(new com.student.batch.Reader()).processor(new Processor())
				.writer(new com.student.batch.Writer()).build();
	}
	
	@Bean
	public JobExecutionListener listener()
	{
		return new JobCompleteListener();
	}
			
			
		

}
 
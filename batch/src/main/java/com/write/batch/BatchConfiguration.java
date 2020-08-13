package com.write.batch;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {
	@Autowired
	public JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	
	@Autowired
	public DataSource dataSource;
	
	@Bean
	public FlatFileItemReader<Amount> reader() {
		
		// This method is used to read the values from the text file
		FlatFileItemReader<Amount> reader = new FlatFileItemReader<Amount>();
		//reader.set
		return reader;
		
	}
	
	@Bean
	public AmountItemProcessor processor() {
		return new AmountItemProcessor();
	}
	
	@Bean
	public JdbcBatchItemWriter<Amount> writer() {
		
		// This method is used for writing the file read content onto the Db
		
		JdbcBatchItemWriter<Amount> writer = new JdbcBatchItemWriter<Amount>();
		//writer.set
		
		return writer;
		
	}
	
	@Bean
	public Job importAmountJob(JobCompletionNotificationListener listener) {
		
		return jobBuilderFactory.get("importAmountJob").incrementer(new RunIdIncrementer()).listener(listener).flow(step1()).end().build();
		
	}
	
	@Bean
	public Step step1() {
		
		return stepBuilderFactory.get("step1").<Amount, Amount>chunk(10).reader(reader()).processor(processor()).writer(writer()).build();
		
	}
	
	

}

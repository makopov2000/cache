package com.example.cache.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.cache.batch.JobCompletionListener;
import com.example.cache.batch.PensionProcessor;
import com.example.cache.batch.PensionReader;
import com.example.cache.batch.PensionWriter;
import com.example.cache.model.Result;


@Configuration
@EnableBatchProcessing
public class BatchConfiguration {
	
	  @Autowired
	  public JobBuilderFactory jobBuilderFactory;

	  @Autowired
	  public StepBuilderFactory stepBuilderFactory;
	  
		@Bean
		public Job processJob() {
			return jobBuilderFactory.get("processJob")
					.incrementer(new RunIdIncrementer()).listener(listener())
					.flow(orderStep1()).end().build();
		}

		@Bean
		public Step orderStep1() {
			return stepBuilderFactory.get("orderStep1").<Result, Result> chunk(1)
					.reader(new PensionReader()).processor(new PensionProcessor())
					.writer(new PensionWriter()).build();
		}

		@Bean
		public JobExecutionListener listener() {
			return new JobCompletionListener();
		}


}

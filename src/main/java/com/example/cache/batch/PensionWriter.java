package com.example.cache.batch;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;

import com.example.cache.model.Result;

public class PensionWriter implements ItemWriter<Result> {
	private static final Logger log = LoggerFactory.getLogger(PensionWriter.class);
	
	@Override
	public void write(List<? extends Result> result) throws Exception {
		log.info("***** Writer ->" + result);
		
	}

}

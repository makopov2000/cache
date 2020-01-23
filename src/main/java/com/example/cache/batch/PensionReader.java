package com.example.cache.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import com.example.cache.model.Result;

public class PensionReader implements ItemReader<Result>{
	private static final Logger log = LoggerFactory.getLogger(PensionReader.class);
	
	private boolean batchJobState = false;

	@Override
	public Result read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		if(!batchJobState){
			Result result = new Result("Reader","Started");
			log.info("***** Reader: " + result );
			batchJobState=true;
			return result;
		}
		return null;
	}

}

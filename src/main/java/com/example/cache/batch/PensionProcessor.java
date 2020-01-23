package com.example.cache.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.example.cache.model.Result;

public class PensionProcessor implements ItemProcessor<Result, Result>{
	private static final Logger log = LoggerFactory.getLogger(PensionProcessor.class);

	@Override
	public Result process(Result result) throws Exception {
		Result resultProcessed = new Result("Presses","Completed");
		log.info("***** ItemProcess -> Converting (" + result + ") into (" + resultProcessed + ")");
		return resultProcessed;
	}
	

}

package com.example.cache;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class EhCacheExampleService {
	int value = 0;
	
	@Cacheable("testCache")
	public int getValue() {
		return value++;
	}

}

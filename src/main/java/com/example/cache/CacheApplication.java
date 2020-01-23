package com.example.cache;

import java.util.stream.IntStream;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import lombok.AllArgsConstructor;

@SpringBootApplication
@EnableCaching
@AllArgsConstructor
@EnableBatchProcessing
public class CacheApplication implements CommandLineRunner {
	private EhCacheExampleService ehCacheExampleService;

	public static void main(String[] args) {
		SpringApplication.run(CacheApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		IntStream.range(0, 5).forEach(i -> System.out.println("++++ Value 1: "+ehCacheExampleService.getValue()));
		Thread.sleep(3000);
		IntStream.range(0, 5).forEach(i -> System.out.println("++++ Value 2: "+ehCacheExampleService.getValue()));
		Thread.sleep(3000);
		IntStream.range(0, 5).forEach(i -> System.out.println("++++ Value 3: "+ehCacheExampleService.getValue()));
		
	}

}

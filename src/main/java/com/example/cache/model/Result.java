package com.example.cache.model;

public class Result {
	  private String process;
	  private String result;
	public Result(String process, String result) {
		super();
		this.process = process;
		this.result = result;
	}
	public Result() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getProcess() {
		return process;
	}
	public void setProcess(String process) {
		this.process = process;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "Result [process=" + process + ", result=" + result + "]";
	}
	  

}

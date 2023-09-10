package com.realestate.demo.core.results;

public class SuccessDataResult <T>extends DataResult<T> {
	
	//this class is used in order to verify success by getting and posting data
	
	public SuccessDataResult(T data, String message)
	{
		super (data, true, message);
	}
	
	public SuccessDataResult(T data)
	{
		super(data,true);
	}
	
	public SuccessDataResult(String message)
	{
		super (null, true, message);
	}
	
	public SuccessDataResult()
	{
		super (null, true);
	}

}

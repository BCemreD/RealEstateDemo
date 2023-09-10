package com.realestate.demo.core.results;

public class DataResult <T> extends Result {
	
	//base class for succes and error messages about getting and posting datas. All possibilities are written (with/out constructor)
	
	private T data;
	public DataResult(T data, boolean success, String message)
	{
		super(success, message);
		this.data =data;
	}
	
	public DataResult (T data, boolean success)
	{
		super(success);
		this.data =data;
	}
	
	public T getData ()
	{
		return this.data;
	}
	
}

package com.mindtree.xml.utility;

public class ClassNFCustomException extends Exception{
	public ClassNFCustomException(String str)
	{
		super(str);
	}
	
	public ClassNFCustomException(String str,Throwable e)
	{
		super(str+e.getMessage());
	}
	public ClassNFCustomException(Throwable e)
	{
		super(e.getMessage());
	}
}

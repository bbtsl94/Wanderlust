package com.agenzia.Wanderlust.entities;

import java.sql.Date;

public class Log
{

	private int id;
	private Date data;
	private String mex;
	
	
	public int getId() 
	{
		return id;
	}
	
	public void setId(String id)
	{
		this.id =Integer.parseInt(id);
	}
	
	public Date getData() 
	{
		return data;
	}
	
	public void setData(String data) 
	{
		this.data = Date.valueOf(data);
	}
	
	public String getMex() 
	{
		return mex;
	}
	
	public void setMex(String mex) 
	{
		this.mex = mex;
	}

	@Override
	public String toString() {
		return  "Id :  " 	 		+ id   + 
				"\nData :  " 		+ data + 
				"\nMessaggio :  "	+ mex  + 
				"\n";
	}
	
	
}

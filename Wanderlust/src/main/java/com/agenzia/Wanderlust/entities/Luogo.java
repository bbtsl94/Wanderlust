package com.agenzia.Wanderlust.entities;

public class Luogo 
{
	private int id;
	private String name;
	
	public int getId()
	{
		return id;
	}
	
	public void setId(String id)
	{
		this.id = Integer.parseInt(id);
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}

	@Override
	public String toString() 
	{
		return "id : " + id 
				+ "\n Luogo : " + name
				+ "\n";
	}
}

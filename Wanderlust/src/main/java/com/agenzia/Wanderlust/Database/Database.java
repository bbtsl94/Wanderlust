package com.agenzia.Wanderlust.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Database
{
	
	private Connection c;
	
	public Database(String nomeDB, String user, String password)
    {
        String timeZone = "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false&amp";
        String percorso = "jdbc:mysql://localhost:3306/"+ nomeDB + "?" 
                          + timeZone + "&useSSL=false";
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.c = DriverManager.getConnection(percorso, user, password);
        }
        catch(Exception e)
        {
            System.out.println(	"Catch nel costruttore della classe Database\n"	+
            					"Controlla build path, username, password"		);
            e.printStackTrace();
        }
    }//Fine di costruttore
	
	
	public List<Map<String, String>> rows(String query, String... params)
	{
		
		List<Map<String, String>> ris = new ArrayList<Map<String, String>>();
		
		try
		{
			PreparedStatement p = c.prepareStatement(query);
			
			for(int i = 0; i < params.length; i++)
				p.setString(i + 1, params[i]);
			ResultSet rs = p.executeQuery();
			
			while(rs.next())
			{
				
				Map<String, String> riga = new LinkedHashMap<String, String>();
				
				
				for(int i = 1; i <= rs.getMetaData().getColumnCount(); i++)
				{
					
					riga.put(	rs.getMetaData().getColumnLabel(i).toLowerCase(),	
								rs.getString(i));									
					
				}//Fine di for
			
				ris.add(riga);
				
				
			}//Fine di while
		}
		catch(Exception e)
		{
			System.err.println("Catch del metodo rows della classe Database in Utility");
			e.printStackTrace();
		}
		
		return ris;
	}//Fine di rows
	
	
	public Map<String, String> row(String query, String... params)
	{
		try
		{
			
			return	rows(query, params).get(0);
		}
		catch(Exception e)
		{
			
			return null;
		}
	}//Fine di row()
	
	
	public boolean update(String query, String... params)
	{
		try
		{
			PreparedStatement p = c.prepareStatement(query);
			
			for(int i = 0; i < params.length; i++)
			{
				p.setString(i + 1, params[i]);
			}
		System.err.println(p);
			p.executeUpdate();
			
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Catch del metodo update di Database in Utility");
			e.printStackTrace();
			return false;
		}
	}//Fine di update
}
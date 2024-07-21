package com.rakesh;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

import com.rakesh.utility.ConnectionFactory;

public class Get_Student {

	public static void main(String[] args)  {
	
		CallableStatement cs = null;
		String call_String ="{call getStudent(?,?)}";
		
		try {
			cs =ConnectionFactory.getDBConnection().prepareCall(call_String);
			
			cs.setInt(1,5);
			cs.registerOutParameter(2,Types.VARCHAR);
			
			cs.execute();
			
			String name =cs.getString(2);
			System.out.println("name returned->"+name);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		System.out.println("Done...");
	}

}

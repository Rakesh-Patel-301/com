package com.rakesh;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

import com.rakesh.utility.ConnectionFactory;

public class Get_Name_Email {

	public static void main(String[] args) {
		CallableStatement cs = null;
		String call_String ="{call getNameAndGmail(?,?,?)}";
		
		try {
			cs = ConnectionFactory.getDBConnection().prepareCall(call_String);
			cs.setInt(1, 3);
			cs.registerOutParameter(2,Types.VARCHAR);
			cs.execute();
			cs.getString(2);
			
			cs.registerOutParameter(3,Types.VARCHAR);
			cs.execute();
			cs.getString(3);
			
			String name = cs.getString(2);
			String gmail = cs.getString(3);
			
			System.out.println("Name returned--->"+name);
			System.out.println("gamil returned--->"+gmail);
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Done.....");

	}

}

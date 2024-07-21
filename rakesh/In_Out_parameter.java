package com.rakesh;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

import com.rakesh.utility.ConnectionFactory;

public class In_Out_parameter {

	public static void main(String[] args) {
		CallableStatement cs = null;
		String call_String = "{call UpdateStudentEmail(?,?)}";
		
		try {
			cs = ConnectionFactory.getDBConnection().prepareCall(call_String);
			cs.setInt(1,3);
			cs.setString(2,"jack@yahoo.com");
			cs.registerOutParameter(2,Types.VARCHAR);
			cs.execute();
			String email = cs.getString(2);
			System.out.println("Updated email---->"+email);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		System.out.println("Done.....");
	}

}

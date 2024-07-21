package com.rakesh;

import com.rakesh.utility.ConnectionFactory;

public class Callable_Statement1 {

	public static void main(String[] args) {
	
	java.sql.CallableStatement cs = null;
	String call_String ="{call createStudent(?,?,?)}";
	
	try {
		cs = ConnectionFactory.getDBConnection().prepareCall(call_String);
		cs.setInt(1, 1);
		cs.setString(2,"jack");
		cs.setString(3,"jack@gmail.com");
		
		cs.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
	
		System.out.println("Done");
	}

}

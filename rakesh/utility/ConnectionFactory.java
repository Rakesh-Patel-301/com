package com.rakesh.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	public static Connection getDBConnection() {
		
		String fileName ="C:\\mysql.ad_java\\JDBC_Bulk_OPS\\src\\Properties-info";
		Connection con =null;
		
		Properties props = new Properties();
		
		
		try {
			FileInputStream	fis = new FileInputStream(fileName);
			try {
				props.load(fis);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String db_url = props.getProperty("db.url");
    	String db_user = props.getProperty("db.user");
    	String db_password = props.getProperty("db.password");
    	
    	try {
			con =DriverManager.getConnection(db_url,db_user,db_password);
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return con;
	}

}

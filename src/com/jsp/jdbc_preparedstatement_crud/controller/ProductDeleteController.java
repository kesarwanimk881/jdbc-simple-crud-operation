package com.jsp.jdbc_preparedstatement_crud.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ProductDeleteController {
	
	public static void main(String[] Args) {
		Connection connection= null;
		try {
			// step-1: load/ register Driver
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// step-2: create connection
			
            String url = "jdbc:mysql://localhost:3306/jdbc-preparedstatement";
			String user="root";
			String pass="root";
			
			connection = DriverManager.getConnection(url, user, pass);
			
			// step-3: create statement
			
			String deleteQuery="update product set color = ? where productid=? ";
			
			PreparedStatement ps= connection.prepareStatement(deleteQuery) ;
			 ps.setString(1,"white");  
			 ps.setInt(2, 100);
			 
			 int a= ps.executeUpdate();
			 
			 if(a==1) {
				 System.out.println("data updatet");
			 }
			 else {
				 System.err.println("given dagta is not present");
			 }
			 
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}

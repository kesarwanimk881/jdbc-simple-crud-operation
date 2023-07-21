package com.jsp.jdbc_preparedstatement_movile_crud.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MobileInsert {
	public static void main(String[] Args) {
		Connection connection= null;
		try {
			// step1 load/register driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// step-2  create connection 
			String url = "jdbc:mysql://localhost:3306/jdbc-preparedstatement";
			
			String user="root";
			String pass="root";
			
			connection = DriverManager.getConnection(url, user,pass);
			
			// step-3 create statement
			String insertQuery= "insert into mobile_data values(?,?,?,?)";
			
			PreparedStatement ps =connection.prepareStatement(insertQuery);
			
			ps.setInt(1,101);
			ps.setString(2, "vivo");
			ps.setString(3, "android");
			ps.setString(4, "touch");
			
			
			ps.execute();
			
			System.out.println("data saved");
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
			connection.close();
		
			}catch(SQLException e) {
				//TODO Auto-generated  catch block
				e.printStackTrace();
			}
		}
	}

}

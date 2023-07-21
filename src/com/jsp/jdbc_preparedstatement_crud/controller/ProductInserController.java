package com.jsp.jdbc_preparedstatement_crud.controller;

import java.sql.*;

import java.sql.DriverManager;
/**
 * @author Java.Developer
 * 
 */

public class ProductInserController {
	/*
	 * 
	 */
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
			String insertQuery= "insert into product values(?,?,?,?)";
			
			PreparedStatement ps =connection.prepareStatement(insertQuery);
			
			ps.setInt(1,101);
			ps.setString(2, "pen2");
			ps.setDouble(3, 1055.2);
			ps.setString(4, "black");
			
			
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

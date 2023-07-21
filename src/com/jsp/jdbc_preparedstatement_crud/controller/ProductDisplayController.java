package com.jsp.jdbc_preparedstatement_crud.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDisplayController {
	public static void main(String[] args) {
		
		Connection con=null;
		try {
			
			//step-1 load/ register Driver
			
			Class.forName("com.mysql.cj.jdbc.Driver");
					
            // step-2: create connection
			
            String url = "jdbc:mysql://localhost:3306/jdbc-preparedstatement";
			String user="root";
			String pass="root";
			
			con = DriverManager.getConnection(url, user, pass);
			
			// step-3: create statement
			
			String displayQuery="select * from product ";
			
			PreparedStatement ps= con.prepareStatement(displayQuery) ;
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id=rs.getInt("productid");
				String name = rs.getString("productname");
				double price=rs.getDouble("productprice");
				String color=rs.getString("color");
				System.out.println("id : "+id );
				System.out.println("name : "+name );
				System.out.println("price : "+price );
				System.out.println("color : "+color );
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch(SQLException e) {
				//TODO Auto-generated  catch block
				e.printStackTrace();
			}
		}
	}
	

}

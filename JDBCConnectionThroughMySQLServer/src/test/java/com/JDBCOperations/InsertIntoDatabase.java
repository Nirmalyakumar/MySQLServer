package com.JDBCOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertIntoDatabase {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/testautomation";
		String username = "root";
		String password = "Coforge@123456";
		try {
//			Load JDBC Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
//			Establish Connection
			Connection con = DriverManager.getConnection(url, username, password);
			
//			Create Statement
			Statement stmt = con.createStatement();
			
//			SQL Query
			String query = "INSERT INTO book_detl VALUES" + "('BI011', 'Testing', 'API', 'Raghu', 'ABC', 'S', '2026', '600.0000')";
			
//			Execute Query
			int rows = stmt.executeUpdate(query);
			
			System.out.println(rows + " Record Inserted Successfully");
			
//			Close Resources
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

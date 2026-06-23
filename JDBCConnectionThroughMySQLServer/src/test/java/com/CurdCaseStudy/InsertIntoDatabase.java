package com.CurdCaseStudy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertIntoDatabase {
	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/read_demo";
		String username = "root";
		String password = "Coforge@123456";

		try {
			// Load JDBC Driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Establish Connection
			Connection con = DriverManager.getConnection(url, username, password);

			// Create Statement
			Statement stmt = con.createStatement();

			String query = "INSERT INTO departments (name, budget, manager_id, location) "
					+ "VALUES ('Operations', 700000.00, 4, 'India')";

			int rows = stmt.executeUpdate(query);

			System.out.println(rows + " Record Inserted Successfully");

			// Close Resources
			stmt.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

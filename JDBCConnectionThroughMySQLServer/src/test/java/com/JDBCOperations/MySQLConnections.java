package com.JDBCOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnections {
//	Databases Credentials
	private static final String URL = "jdbc:mysql://localhost:3306/testautomation";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Coforge@123456";

	public static void main(String[] args) {
		Connection connection = null;
		try {
//			1. Load MySQL JDBC Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
//			2. Establish connection
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//			3. Check if connection is successful
			if (connection != null) {
				System.out.println("Successfully connected to MySQL database!");
				System.out.println("Database: " + connection.getCatalog());
				System.out.println("URL: " + URL);
				System.out.println("Username: " + USERNAME);
			}
		} catch (ClassNotFoundException e) {
			System.err.println("MySQL JDBC Driver not found!");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("Failed to connect to MySQL databases!");
			System.err.println("Error Code:" + e.getErrorCode());
			System.err.println("SQL State:" + e.getSQLState());
			System.err.println("Message: " + e.getMessage());
			e.printStackTrace();
		} finally {
//			4. Close Connection
			try {
				if (connection != null && !connection.isClosed()) {
					connection.close();
					System.out.println("Connection Closed Successfully!");
				}
			} catch (SQLException e) {
				System.err.println("Error Closing Connection");
				e.printStackTrace();
			}
		}
	}

}

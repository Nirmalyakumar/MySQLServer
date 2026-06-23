package com.JDBCOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateRecord {
	private static final String URL = "jdbc:mysql://localhost:3306/testautomation";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Coforge@123456";

	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;

		try {
//			Create Database connection using DriverManager.getConnection()
			System.out.println("Attemptiong to connect to database..");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("Database connected successfully!");

//			Create Statement
			statement = connection.createStatement();
			System.out.println("Statement Created Successfully!");

//			Write the update Query
			String updateQuery = "UPDATE book_detl SET author = 'Chaithu' WHERE author = 'Raghu'";
			System.out.println("\n Executing UPDATE query:");
			System.out.println(" " + updateQuery);

//			Execute using executeUpdate()
			int rowsUpdated = statement.executeUpdate(updateQuery);

//			executeUpdate() returns the number of rows updated
			System.out.println("\n Number of rows updated:" + rowsUpdated);

			if (rowsUpdated > 0) {
				System.out.println("Update Record Successfully");
				System.out.println("  " + rowsUpdated + " record(s) updated");
				System.out.println("  Author 'Raghu' changed to 'Chaithu' ");
			} else {
				System.out.println("No rows were updated");
				System.out.println("No records found with author = 'Raghu' ");
			}

		} catch (SQLException e) {
			System.out.println("Error while closing resources");
			e.printStackTrace();

		}

	}

}

package com.JDBCOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteRecord {
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

//			Write the Delete Query
			String deleteQuery = "DELETE FROM book_detl WHERE book_no = 'BI011'";
			System.out.println("\n Executing DELETE query:");
			System.out.println(" " + deleteQuery);

//			Execute using executeUpdate()
			int rowsDeleted = statement.executeUpdate(deleteQuery);

//			executeUpdate() returns the number of rows updated
			System.out.println("\n Number of rows deleted: " + rowsDeleted);

			if (rowsDeleted > 0) {
				System.out.println("Delete Record Successfully");
				System.out.println("  " + rowsDeleted + " record(s) deleted");
				System.out.println("Book with book_no = 'BI011' has been removed. ");
			} else {
				System.out.println("No rows were deleted");
				System.out.println("No records found with book_no = 'BI011' ");
			}
		} catch (SQLException e) {
			System.out.println("Database Error Occured");
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if (connection != null && !connection.isClosed()) {
					connection.close();
					System.out.println("Connection closed successfully");
				}
			} catch (SQLException e) {
				System.err.println("Error closing connection");
				e.printStackTrace();
			}
		}
	}
}

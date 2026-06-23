package com.CurdCaseStudy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteData {
	private static final String URL = "jdbc:mysql://localhost:3306/read_demo";
	private static final String USERNAME = "root";
	private static final String Password = "Coforge@123456";

	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;

		try {
			System.out.println("Attempting to connect to database .....");
			connection = DriverManager.getConnection(URL, USERNAME, Password);
			System.out.println("Database connected successfully");

			statement = connection.createStatement();
			System.out.println("Statement created successfully");

			String deletequery = "DELETE FROM departments WHERE id = 4";
			System.out.println("\n Executing DELETE Query");
			System.out.println("  " + deletequery);

			int rowsDeleted = statement.executeUpdate(deletequery);

			System.out.println("\n Number of rows deleted: " + rowsDeleted);

			if (rowsDeleted > 0) {
				System.out.println("Delete Record Successfully");
				System.out.println("  " + rowsDeleted + " record(s) deleted");
				System.out.println("  Book with id = 4 has been removed. ");
			} else {
				System.out.println("No rows were deleted");
				System.out.println("No records found with id = 4 ");
			}

		} catch (SQLException e) {
			System.out.println("DataBase Error Occured");
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

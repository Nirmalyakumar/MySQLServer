package com.CurdCaseStudy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class InsertIntoDatabase {
	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/read_demo";
		String username = "root";
		String password = "cfg1234";

		try {
			// Optional for older JDBC versions
			Class.forName("com.mysql.cj.jdbc.Driver");

			try (Connection con = DriverManager.getConnection(url, username, password);
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("SELECT * FROM employees")) {

				ResultSetMetaData metadata = rs.getMetaData();
				int columnCount = metadata.getColumnCount();

				// Print Column Names
				for (int i = 1; i <= columnCount; i++) {
					System.out.print(metadata.getColumnName(i) + "\t");
				}
				System.out.println();

				System.out.println("----------------------------------------------------");

				// Print Data
				while (rs.next()) {
					for (int i = 1; i <= columnCount; i++) {
						System.out.print(rs.getString(i) + "\t");
					}
					System.out.println();
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

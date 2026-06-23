package com.JDBCOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLDMLCommands {
	public static void main(String[] args) throws SQLException {
		
		// 1. Create Connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/automationtestdata", "root",
				"raghuBN@123");
		
		// 2 Create Statement/Query
		Statement stamt = con.createStatement();
		String s = "INSERT INTO book_detl values ('PH005', 'Mobility', 'Che', 'Raghavendra', 'ABC', 'S', '2023', 800.0000)";
		String s1 = "UPDATE book_detl SET author = 'RaghuBNR' WHERE author = 'Raghu' ";
		String s2 = "Delete From Student Where ID = 2";
		String s3 = "Delete From book_detl Where book_no = PH003 ";
		
		// 3. Execute Statement/Query
		stamt.execute(s);
		
		// 4. Close Connection
		con.close();
		System.out.println("Statement Executed : Record Update Successfully");
	}
}

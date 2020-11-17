package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJdbc {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
		String userName = "hbstudent";
		String password = "hbstudent";
		
		System.out.println("Connecting to database " + jdbcUrl);
		try {
			Connection conn = DriverManager.getConnection(jdbcUrl, userName, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Success!");

	}

}

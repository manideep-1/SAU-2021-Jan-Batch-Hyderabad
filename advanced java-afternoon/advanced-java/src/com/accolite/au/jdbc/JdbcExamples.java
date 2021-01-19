package com.accolite.au.jdbc;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.io.File;
import com.accolite.au.xmlprocessing.*;


public class JdbcExamples {

	public static void main(String[] args) throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try (Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/assignment", "root", "1234")) {
//				jdbc:mysql://127.0.0.1:3306/?user=root root@127.0.0.1:3306
				System.out.println("con created");
				JdbcExamples jdbcExample =  new JdbcExamples();
				jdbcExample.createTables(con);
				jdbcExample.insertData(con);
//				jdbcExample.updateData(con);
//				jdbcExample.readData(con);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	void createTables(Connection con) {
		try (Statement stmt = con.createStatement()) {
			String sql = "create table assignment(name varchar(100) PRIMARY KEY, statusupdate varchar(100),prg_language varchar(100))";
			stmt.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	void insertData(Connection con) {
		XMLProcessingExample xmlProcessingExample = new XMLProcessingExample();
//		xmlProcessingExample.domParser();
		Assignments a=xmlProcessingExample.jaxBParser();
		for(Assignment ass : a.getAssignment()) {
//			System.out.println(ass.getName()+" "+ass.getPrg_language()+" "+ass.getStatusupdate() );
			String sql = "insert into assignment(name,statusupdate,prg_language) values(?, ?, ?)";
			try (PreparedStatement stmt = con.prepareStatement(sql)) {
				stmt.setString(1, ass.getName());
				stmt.setString(2, ass.getPrg_language());
				stmt.setString(3, ass.getStatusupdate());
				stmt.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
//		System.out.println(a);
//		System.out.println(a);
//		String sql = "insert into assignment(asgmt_id, name, review) values(?, ?, ?)";
//		try (PreparedStatement stmt = con.prepareStatement(sql)) {
//			stmt.setInt(1, 1);
//			stmt.setString(2, "advanced_java");
//			stmt.setString(3, "yet to begin");
//			stmt.execute();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
	}
	
	void updateData(Connection con) {
		String sql = "update assignment set review=? where asgmt_id=?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, "started");
			stmt.setInt(2, 1);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	void readData(Connection con) {
		String sql = "select asgmt_id, name, review from assignment";
		try (Statement stmt = con.createStatement()) {
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " +rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}

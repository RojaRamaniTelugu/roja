package com.jdbccom.jdbc.connection;

import java.sql.*;

public class JDBCAPP {

	public static void main(String[] args) throws SQLException {
		String url="jdbc:mysql://localhost:3306/jdbc_demo";
		String username="root";
		String password="root";
		Connection con=DriverManager.getConnection(url,username,password);
		Statement st=con.createStatement();
		insertData(url,username,password,con,st);
		updatedata(url,username,password,con,st);
		deleteData(url,username,password,con,st);
		

	}
	public static void insertData(String url,String username,String password,Connection con,Statement st) throws SQLException
	{
		String sql1="insert into student3 values(01,'ramani','CSE')"; 
		String sql2="insert into student3 values(02,'rojaramani','ECE')"; 
//		establish the connection
//		creating the statement
		st.execute(sql1);
		st.execute(sql2);
		System.out.println("rows inserted");
		
	}
	public static void updatedata(String url,String username,String password,Connection con,Statement st) throws SQLException
	{
	
		String sql="update  student3 set name='roja' where rollnumber=01"; 
		st.executeUpdate(sql);
		System.out.println("row updated");
		
	}
	public static void deleteData(String url,String username,String password,Connection con,Statement st) throws SQLException
	{

		String sql="delete from student3 where rollnumber=02"; 
		st.execute(sql);
		System.out.println("row deleted");
	}
	
}

package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {
	Connection con;
	public void getConnection(String url,String username,String password) throws SQLException {
		try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			con=DriverManager.getConnection(url, username, password);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void closeDataBaseConnection() throws SQLException {
		if(con!=null){
			con.close();
		}
	}
	public ResultSet executeConSelectQuery(String query) {
		ResultSet result=null;
		try{
			Statement stst=con.createStatement();
			result=stst.executeQuery(query);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int executeNonSelectQuery(String query) {
		int result=0;
		try{
			Statement stst=con.createStatement();
			result=stst.executeUpdate(query);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public void getConnection() {
		try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}

package it.uniroma2.TestIngresso.DAO;

import com.mysql.jdbc.Connection;

public class DAO {
	// visibilità package per tutte le variabili
	static Connection conn = null;
	static String URL = "jdbc:mysql://localhost:3306/TESTINGRESSO";
	static String DBuser = "root";
	static String DBpassword = "root";
}

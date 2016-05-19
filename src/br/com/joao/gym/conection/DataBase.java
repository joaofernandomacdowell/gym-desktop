package br.com.joao.gym.conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import br.com.joao.gym.model.User;

public class DataBase {
	
	static User user = new User();
	
	static	Connection connection = null;  
    Statement stmt = null;
    
	 public static Connection getConnection() throws Exception {
		 
		 try {
			 Class.forName("org.sqlite.JDBC");  
	         connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\jfmcd\\WorkspaceBitBucket\\Gym\\GymServer.db");  
	         System.out.println("Conexão realizada");
	         return connection;
		 } 
		 
		 catch (Exception e) {

			 System.out.println("Nao foi possivel conectar");
			 return null;
		 }
	 }
}

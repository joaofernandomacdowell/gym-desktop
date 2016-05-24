package br.com.joao.gym.conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.joao.gym.model.User;

public class DataBase {
	
	static User user = new User();
	
	static	Connection connection = null;  
    Statement stmt = null;
    
	 public static Connection getConnection() throws Exception {
		 
		 try {
			 Class.forName("org.sqlite.JDBC");  
	         connection = DriverManager.getConnection("jdbc:sqlite:GymServer.db");  
	         System.out.println("Conexão realizada");
	         return connection;
		 } 
		 
		 catch (Exception e) {

			 System.out.println("Nao foi possivel conectar");
			 return null;
		 }
	 }
	 
	 public static User getUser (String userLogin) throws SQLException, Exception
	    {
		 	Connection c = getConnection();
		 	Statement stmt = null;
			stmt = c.createStatement();
			User user = new User();
			
			PreparedStatement ps = c.prepareStatement("SELECT * FROM users where login_name = ?");  
			
			//Aqui você seta os valores dos ?   
			ps.setString(1, userLogin);   
			ResultSet rs = ps.executeQuery();
			
			System.out.println("Fazendo consulta de usuario");
			
					
			 while ( rs.next() ){
				 
			user.setUserName(rs.getString("login_name"));
			System.out.println("Conteudo da consulta do user name:" + user.getUserName());
			user.setUserPassword(rs.getString("password"));
			System.out.println("Conteudo da consulta do user password:" + user.getUserPassword());
			user.setUserGroup(rs.getString("bantime").toString());
			System.out.println("Conteudo da consulta do user group:" + user.getUserGroup());
			
			System.out.println("Consulta realizada");
			
			 }
			 
			rs.close();
		    stmt.close();
		    c.close();
		    
		    return user;		
	    }
}

package br.com.joao.gym.conection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import br.com.joao.gym.model.Member;
import br.com.joao.gym.model.User;

public class DataBase {
	
	static User user = new User();
	
	static	Connection connection = null;  
    Statement stmt = null;
    
	 public static Connection getConnection() throws Exception {
		 
		 try {
			 Class.forName("org.sqlite.JDBC");  
	         connection = DriverManager.getConnection("jdbc:sqlite:GymServer.db");  
	         System.out.println("Conex�o realizada");
	         return connection;
		 } 
		 
		 catch (Exception e) {
			 System.out.println("Nao foi possivel conectar");
			 return null;
		 }
	 }
	 
	 public static User getUser (String userName) throws SQLException, Exception {
		 
		 Connection c = getConnection();
		 Statement stmt = null;
		 stmt = c.createStatement();
		 User user = new User();
			
		 PreparedStatement ps = c.prepareStatement("SELECT * FROM User WHERE user_name = ? ");  
			
		 //Aqui voc� seta os valores dos ?   
		 ps.setString(1, userName);   
		 ResultSet rs = ps.executeQuery();
			
		 System.out.println("Fazendo consulta de usuario");
						
		 while (rs.next()) {
				 
			 user.setUserName(rs.getString("user_name"));
			 System.out.println("Conteudo da consulta do user name:" + user.getUserName());
			 user.setUserPassword(rs.getString("user_password"));
			 System.out.println("Conteudo da consulta do user password:" + user.getUserPassword());
				
			 System.out.println("Consulta realizada");
		 }
			 
		 rs.close();
		 stmt.close();
		 c.close();
		    
		 return user;		
	 }
	 
	 public static boolean insertUser(String userName, String userPassword, String userGroup) throws Exception
	    {
		 	System.out.println("--------------------Iniciando cadastro de usuario-----------------------");
	        Connection c = getConnection();
	        String group;
	        
	        if(userGroup.contains("admin")) {
	        	//userGroup = "admin";
	        }
	        
	        else {
	        	//acc_type = false;
	        }
	        
	        PreparedStatement ps = c.prepareStatement("INSERT INTO Users (name, password, group) VALUES" + "(?,?,?)");
	        
	        System.out.println("Login sendo cadastrado: " + userName);
	        ps.setString(1, userName);

	        System.out.println("Name sendo cadastrado: " + userPassword);
	        ps.setString(2, userPassword);

	        //System.out.println("acctype sendo cadastrado: " + userGroup);
	        //ps.setBoolean(3, acc_type);

	        int res = ps.executeUpdate();

	        if (res != 1) {
	            return false;
	        }

	        System.out.println("-------------------Usuario cadastrado-----------------");
	        c.close();
	        ps.close();

	        return true;
	    }
	 
	 public static boolean insertNewMember(String full_name, int cpf, 
			 int rg, String city, String address, int postal_code,
			 int phone, String email, String birthday, int age, 
			 String contract, String payment_type) throws Exception {
		 
		 	System.out.println("--------------------Iniciando cadastro de cliente-----------------------");
		 	Connection c = getConnection();
	        
	        PreparedStatement ps = c.prepareStatement("INSERT INTO Member (full_name, cpf, "
	        + "rg, city, address, postal_code, phone, email, birthday, age, contract, payment_type) "
	        + "VALUES" + "(?,?,?,?,?,?,?,?,?,?,?,?)");
	        
	        System.out.println("Nome completo: " + full_name);
	        ps.setString(1, full_name);

	        System.out.println("CPF: " + cpf);
	        ps.setInt(2, cpf);
	        
	        System.out.println("RG: " + rg);
	        ps.setInt(3, rg);
	        
	        //System.out.println("registry: " + registry);
	        //ps.setInt(4, registry);
	        
	        System.out.println("city: " + city);
	        ps.setString(4, city);
	        
	        System.out.println("adress: " + address);
	        ps.setString(5, address);
	        
	        System.out.println("postal_code: " + postal_code);
	        ps.setInt(6, postal_code);
	        
	        System.out.println("phone: " + phone);
	        ps.setInt(7, phone);
	        
	        System.out.println("email: " + email);
	        ps.setString(8, email);
	        
	        System.out.println("birthday: " + birthday);
	        ps.setString(9, birthday);
	        
	        //System.out.println("birthday: " + birthday);
	        //ps.setDate(10, birthday);
	        
	        System.out.println("age: " + age);
	        ps.setInt(10, age);
	        
	        System.out.println("cadastract: " + contract);
	        ps.setString(11, contract);
	        
	        System.out.println("payment_type: " + payment_type);
	        ps.setString(12, payment_type);
	        
	        //System.out.println("payment_status: " + payment_status);
	        //ps.setBoolean(13, payment_status);
	        
	        int res = ps.executeUpdate();

	        if (res != 1) {
	            return false;
	        }

	        System.out.println("-------------------Member cadastrado-----------------");
	        c.close();
	        ps.close();

	        return true;
	    }
}

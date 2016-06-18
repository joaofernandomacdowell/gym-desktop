package br.com.joao.gym.conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import br.com.joao.gym.model.Evaluation;
import br.com.joao.gym.model.ItemSeries;
import br.com.joao.gym.model.Member;
import br.com.joao.gym.model.User;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import br.com.joao.gym.model.Series;
import br.com.joao.gym.util.DateUtil;

public class DataBase {

	static User user = new User();
	static Evaluation evaluation = new Evaluation();
	static ItemSeries itemSeries = new ItemSeries();

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

	public static User getUser (String userName) throws SQLException, Exception {

		Connection c = getConnection();
		Statement stmt = null;
		stmt = c.createStatement();
		User user = new User();

		PreparedStatement ps = c.prepareStatement("SELECT * FROM User WHERE user_name = ? ");  

		//Aqui você seta os valores dos ?   
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

	public static Member getMember (String memberCpf) throws SQLException, Exception {

		Connection c = getConnection();
		Statement stmt = null;
		stmt = c.createStatement();
		Member member = new Member();

		PreparedStatement ps = c.prepareStatement("SELECT * FROM Member WHERE cpf = ? ");  

		//Aqui você seta os valores dos ?   
		ps.setString(1, memberCpf);   
		ResultSet rs = ps.executeQuery();

		System.out.println("Fazendo consulta de member");

		while (rs.next()) {

			member.setCpf(rs.getString("cpf"));
			System.out.println("Conteudo da consulta do cpf:" + member.getCpf());
			member.setFullName(rs.getString("full_name"));
			System.out.println("Conteudo da consulta do full_name:" + member.getFullName());

			System.out.println("Consulta realizada");
		}

		rs.close();
		stmt.close();
		c.close();

		return member;		
	}

	public static boolean insertMember(String full_name, String cpf, 
			String rg, String city, String address, String postal_code,
			String phone, String email, DatePicker dateBirth, int age, 
			String contract, String payment_type, String payday) throws Exception {

		System.out.println("--------------------Iniciando cadastro de novo Member-----------------------");
		Connection c = getConnection();

		PreparedStatement ps = c.prepareStatement("INSERT INTO Member (full_name, cpf, rg, city, address, "
				+ "postal_code, phone, email, date_birth, age, contract, payment_type, payday) "
				+ "VALUES" + "(?,?,?,?,?,?,?,?,?,?,?,?,?)");

		System.out.println("Nome completo: " + full_name);
		ps.setString(1, full_name);

		System.out.println("CPF: " + cpf);
		ps.setString(2, cpf);

		System.out.println("RG: " + rg);
		ps.setString(3, rg);

		//System.out.println("registry: " + registry);
		//ps.setInt(4, registry);

		System.out.println("city: " + city);
		ps.setString(4, city);

		System.out.println("adress: " + address);
		ps.setString(5, address);

		System.out.println("postal_code: " + postal_code);
		ps.setString(6, postal_code);

		System.out.println("phone: " + phone);
		ps.setString(7, phone);

		System.out.println("email: " + email);
		ps.setString(8, email);

		ps.setString(9, ((TextField)dateBirth.getEditor()).getText());
		System.out.println("date_birth: " + dateBirth.getValue());
		//ps.setDate(9, dateBirth);

		//System.out.println("birthday: " + birthday);
		//ps.setDate(10, birthday);

		System.out.println("age: " + age);
		ps.setInt(10, age);

		System.out.println("contract: " + contract);
		ps.setString(11, contract);

		System.out.println("payment_type: " + payment_type);
		ps.setString(12, payment_type);

		System.out.println("payday: " + payday);
		ps.setString(13, payday);

		int res = ps.executeUpdate();

		if (res != 1) {
			System.out.println("Não executou a query");
			return false;
		}

		System.out.println("-------------------Member cadastrado-----------------");
		c.close();
		ps.close();

		return true;
	}

	public static Series getItemSeries (String member_cpf, String training) throws SQLException, Exception {

		Connection c = getConnection();
		Statement stmt = null;
		stmt = c.createStatement();
		Series series = new Series();

		PreparedStatement ps = c.prepareStatement("SELECT * FROM ItemSeries WHERE member_cpf = ? AND training = ?");  

		//Aqui você seta os valores dos ?   
		ps.setString(1, member_cpf); 
		ps.setString(2, training);
		ResultSet rs = ps.executeQuery();

		System.out.println("Fazendo consulta da serie");

		while (rs.next()) {

			itemSeries.setId((rs.getInt("id_item")));
			System.out.println("Conteudo da consulta do id do item de serie:" + itemSeries.getId());
			
			itemSeries.setMemberCpf((rs.getString("member_cpf")));
			System.out.println("Conteudo da consulta do memberCpf da serie:" + itemSeries.getMemberCpf());
			
			itemSeries.setTraining((rs.getString("training")));
			System.out.println("Conteudo da consulta do training da serie:" + itemSeries.getTraining());
			
			itemSeries.setDateStart((rs.getString("date_start")));
			System.out.println("Conteudo da consulta do dateStart da serie:" + itemSeries.getDateStart());
			
			itemSeries.setDateEnd((rs.getString("date_end")));
			System.out.println("Conteudo da consulta do dateEnd da serie:" + itemSeries.getDateEnd());
			
			itemSeries.setExerciseNum((rs.getString("exercise_num")));
			System.out.println("Conteudo da consulta do memberCpf da serie:" + itemSeries.getExerciseNum());
			
			itemSeries.setExerciseName((rs.getString("exercise_name")));
			System.out.println("Conteudo da consulta do memberCpf da serie:" + itemSeries.getExerciseName());
			
			itemSeries.setEquipment((rs.getString("equipment")));
			System.out.println("Conteudo da consulta do memberCpf da serie:" + itemSeries.getEquipment());
			
			itemSeries.setQtdSeries((rs.getString("qtd_series")));
			System.out.println("Conteudo da consulta do memberCpf da serie:" + itemSeries.getQtdSeries());
			
			itemSeries.setReps((rs.getString("reps")));
			System.out.println("Conteudo da consulta do memberCpf da serie:" + itemSeries.getReps());
			
			itemSeries.setWeight((rs.getString("weight")));
			System.out.println("Conteudo da consulta do memberCpf da serie:" + itemSeries.getWeight());
			
			itemSeries.setRegulation((rs.getString("regulation")));
			System.out.println("Conteudo da consulta do memberCpf da serie:" + itemSeries.getRegulation());
			
			itemSeries.setObs((rs.getString("obs")));
			System.out.println("Conteudo da consulta do memberCpf da serie:" + itemSeries.getObs());

			System.out.println("Consulta realizada");
		}

		rs.close();
		stmt.close();
		c.close();

		return series;		
	}

	public static Series getTrainingSeries (String id) throws SQLException, Exception {

		Connection c = getConnection();
		Statement stmt = null;
		stmt = c.createStatement();
		Series series = new Series();

		PreparedStatement ps = c.prepareStatement("SELECT * FROM Series WHERE id = ? ");  

		//Aqui você seta os valores dos ?   
		ps.setString(1, id);   
		ResultSet rs = ps.executeQuery();

		System.out.println("Fazendo consulta da serie");

		while (rs.next()) {

			series.setId(rs.getInt("id"));
			System.out.println("Conteudo da consulta do id da serie:" + series.getId());

			series.setMemberCpf(rs.getString("member_cpf"));
			System.out.println("Conteudo da consulta do cpf do member:" + series.getMemberCpf());

			System.out.println("Consulta realizada");
		}

		rs.close();
		stmt.close();
		c.close();

		return series;		
	}

	
	public static boolean insertSeries(int id, String memberCpf, String training, 
			LocalDate dateStart, DatePicker dateEnd, String exerciseNum, 
			String exerciseName, String equipment, String qtdSeries,
			String reps, String weight, String regulation, String obs) throws Exception {

		System.out.println("--------------------Iniciando cadastro de nova Serie-----------------------");
		Connection c = getConnection();

		PreparedStatement ps = c.prepareStatement("INSERT INTO Series (id, member_cpf, training, date_start, "
				+ "date_end, exercise_num, exercise_name, equipment, qtd_series, reps, weight, regulation, obs"
				+ "VALUES" + "(?,?,?,?,?,?,?,?,?,?,?,?,?)");

		System.out.println("ID: " + id);
		ps.setInt(1, id);

		System.out.println("CPF: " + memberCpf);
		ps.setString(2, memberCpf);

		System.out.println("training: " + training);
		ps.setString(3, training);

		System.out.println("date_start: " + dateStart);
		ps.setString(4, DateUtil.format(java.time.LocalDate.now()));
		
		System.out.println("date_end: " + dateEnd);
		ps.setString(5, ((TextField)dateEnd.getEditor()).getText());

		System.out.println("exerciseNum: " + exerciseNum);
		ps.setString(6, exerciseNum);

		System.out.println("exercise_name: " + exerciseName);
		ps.setString(7, exerciseName);

		System.out.println("equipment: " + equipment);
		ps.setString(8, equipment);

		System.out.println("qtd_series: " + qtdSeries);
		ps.setString(9, qtdSeries);

		System.out.println("reps: " + reps);
		ps.setString(10, reps);

		System.out.println("weight: " + weight);
		ps.setString(11, weight);

		System.out.println("regulation: " + regulation);
		ps.setString(12, regulation);

		System.out.println("obs: " + obs);
		ps.setString(13, obs);

		int res = ps.executeUpdate();

		if (res != 1) {
			System.out.println("Não executou a query");
			return false;
		}

		System.out.println("-------------------Serie cadastrada-----------------");
		c.close();
		ps.close();

		return true;
	}

	public static boolean insertUser(String userName, String userPassword) throws Exception {
		System.out.println("--------------------Iniciando cadastro de usuario-----------------------");
		Connection c = getConnection();

		PreparedStatement ps = c.prepareStatement("INSERT INTO Users (name, password, group) VALUES" + "(?,?)");

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

	public static boolean insertEvaluation(int id, String memberCpf, DatePicker date, String time, String instructorName) throws Exception {
		System.out.println("--------------------Iniciando cadastro de avaliação-----------------------");
		Connection c = getConnection();

		PreparedStatement ps = c.prepareStatement("INSERT INTO Evaluation (id, member_cpf, date, time, instructor)"
				+ "VALUES (?,?,?,?,?)");

		//date = new DatePicker();

		System.out.println("Id da Avaliação: " + id);
		ps.setInt(1, id);

		System.out.println("MemberCpf sendo cadastrada a avaliação: " + memberCpf);
		ps.setString(2, memberCpf);

		System.out.println("Data sendo cadastrada: " + date.getValue());
		ps.setString(3, ((TextField)date.getEditor()).getText());

		System.out.println("Horário da avaliação: " + time);
		ps.setString(4, time);

		System.out.println("Instructor sendo cadastrado para avaliação: " + instructorName);
		ps.setString(5, instructorName);

		int res = ps.executeUpdate();

		if (res != 1) {
			return false;
		}

		System.out.println("-------------------Avaliação cadastrada-----------------");
		c.close();
		ps.close();

		return true;
	}

	public static Evaluation getEvaluation (int id) throws SQLException, Exception {

		Connection c = getConnection();
		Statement stmt = null;
		stmt = c.createStatement();


		PreparedStatement ps = c.prepareStatement("SELECT * FROM Evaluation WHERE id = ? ");  

		//Aqui você seta os valores dos ?   
		ps.setInt(1, id);   
		ResultSet rs = ps.executeQuery();

		System.out.println("Fazendo consulta da avaliação agendada");

		while (rs.next()) {

			evaluation.setId((rs.getInt("id")));
			System.out.println("Conteudo da consulta do id:" + evaluation.getId());

			evaluation.setMemberCpf((rs.getString("member_cpf")));
			System.out.println("Conteudo da consulta do memberCpf:" + evaluation.getMemberCpf());

			evaluation.setDate(rs.getString("date"));
			System.out.println("Conteudo da consulta da data:" + evaluation.getDate());

			evaluation.setTime(rs.getString("time"));
			System.out.println("Conteudo da consulta do time: " + evaluation.getTime());

			evaluation.setTime(rs.getString("instructor_name"));
			System.out.println("Conteudo da consulta do instructorName: " + evaluation.getInstructorName());

			System.out.println("Consulta realizada");
		}

		rs.close();
		stmt.close();
		c.close();

		return evaluation;		
	}

	public static Evaluation getEvaluationLastId (int id) throws SQLException, Exception {

		Connection c = getConnection();
		Statement stmt = null;
		stmt = c.createStatement();

		PreparedStatement ps = c.prepareStatement("SELECT last_insert_rowId() FROM Evaluation");
		ps.setInt(1, id);  
		ResultSet rs = ps.executeQuery();

		System.out.println("Fazendo consulta do último ID da tabela");

		while (rs.next()) {

			evaluation.setId((rs.getInt("id")));
			System.out.println("Conteudo da consulta do id:" + evaluation.getId());
		}

		rs.close();
		stmt.close();
		c.close();

		return evaluation;		
	}

	public static Evaluation getLastId () throws SQLException, Exception {

		Connection c = getConnection();
		Statement stmt = null;
		stmt = c.createStatement();

		PreparedStatement ps = c.prepareStatement("SELECT ROWID FROM SQL_LITE_SEQUENCE ORDER BY ROWID DESC LIMIT 1");

		//ps.setInt(1, id);  
		ResultSet rs = ps.executeQuery();

		System.out.println("Fazendo consulta do último ID da tabela");

		while (rs.next()) {

			evaluation.setId((rs.getInt("id")));
			System.out.println("Conteudo da consulta do id:" + evaluation.getId());
		}

		rs.close();
		stmt.close();
		c.close();

		return evaluation;		
	}
}

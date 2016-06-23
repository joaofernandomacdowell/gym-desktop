package br.com.joao.gym.conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import br.com.joao.gym.model.Evaluation;
import br.com.joao.gym.model.ItemSeries;
import br.com.joao.gym.model.Member;
import br.com.joao.gym.model.Pay;
import br.com.joao.gym.model.User;
import javafx.collections.ObservableList;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import br.com.joao.gym.model.Series;

public class DataBase {

	static Pay pay = new Pay();
	static User user = new User();
	static Evaluation evaluation = new Evaluation();
	static ItemSeries itemSeries = new ItemSeries();
	static Series series = new Series();
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

			user.setUserGroup(rs.getString("user_group"));
			System.out.println("Conteudo da consulta do user password:" + user.getUserGroup());

			System.out.println("Consulta realizada");
		}

		rs.close();
		stmt.close();
		c.close();

		return user;		
	}

	public static Member getMember (String cpf) throws SQLException, Exception {

		Connection c = getConnection();
		Statement stmt = null;
		stmt = c.createStatement();
		Member member = new Member();

		PreparedStatement ps = c.prepareStatement("SELECT * FROM Member WHERE cpf = ? ");  

		//Aqui você seta os valores dos ?   
		ps.setString(1, cpf);   
		ResultSet rs = ps.executeQuery();

		System.out.println("Fazendo consulta de member");

		while (rs.next()) {

			member.setFullName(rs.getString("full_name"));
			member.setCpf(rs.getString("cpf"));
			member.setRg(rs.getString("rg"));
			member.setCity(rs.getString("city"));
			member.setAddress(rs.getString("address"));
			member.setPostalCode(rs.getString("postal_code"));
			member.setPhone(rs.getString("phone"));
			member.setEmail(rs.getString("email"));

			member.setGender(rs.getString("gender"));
			member.setDateBirth("date_birth");
			member.setAge(rs.getInt("age"));

			member.setMedicalCertificate(rs.getBoolean("medical_certificate"));
			member.setContract(rs.getString("contract"));
			member.setPaymentType("payment_type");
			member.setPayday(rs.getString("payday"));

			System.out.println("Consulta realizada");
		}

		rs.close();
		stmt.close();
		c.close();

		return member;		
	}

	public static void updateMedicalStatus(String cpf, boolean medicalCertificate) throws Exception {

		System.out.println("--------------------Atualiza atestado médico-----------------------");
		Connection c = getConnection();
		
		PreparedStatement ps = c.prepareStatement("UPDATE Member SET medical_certificate = ? WHERE cpf = ?");
		ps.setBoolean(1, medicalCertificate);
		ps.setString(2, cpf);
		
		int res = ps.executeUpdate();
		//c.commit();
		
		if (res != 1) {
			System.out.println("Não executou a query");
		}
		
		c.close();
		ps.close();
	}
	
	public static void insertItemSeries (String member_cpf, int id_series, String workout, int times_executed,
			String exercise_name, String equipment, String qtd_series, String reps, String weight,
			String regulation, String obs) throws SQLException, Exception {

		Connection c = getConnection();

		PreparedStatement ps = c.prepareStatement(" INSERT INTO ItemSeries (member_cpf, id_series,"
				+ "workout, times_executed, exercise_name, equipment, qtd_series, reps,"
																+ "weight, regulation, obs)" + "VALUES" + "(?,?,?,?,?,?,?,?,?,?,?)");  

		System.out.println("Fazendo consulta da serie");

		System.out.println("member_cpf: " + member_cpf);
		ps.setString(1, member_cpf);
		
		System.out.println("id_series: " + id_series);
		ps.setInt(2, id_series);
		
		//System.out.println("id_item: " + id_item);
		//ps.setInt(3, id_item);

		System.out.println("workout: " + workout);
		ps.setString(3, workout);

		System.out.println("times_executeed: " + times_executed);
		ps.setInt(4, times_executed);
		
		System.out.println("exercise_name: " + exercise_name);
		ps.setString(5, exercise_name);

		System.out.println("equipment: " + equipment);
		ps.setString(6, equipment);

		System.out.println("qtd_series: " + qtd_series);
		ps.setString(7, qtd_series);

		System.out.println("reps: " + reps);
		ps.setString(8, reps);

		System.out.println("weight: " + weight);
		ps.setString(9, weight);  

		System.out.println("regulation: " + regulation);
		ps.setString(10, regulation);

		System.out.println("obs: " + obs);
		ps.setString(11, obs);

		int res = ps.executeUpdate();

		if (res != 1) {
			System.out.println("Não executou a query");
		}

		System.out.println("-------------------ItemSerie cadastrado-----------------");
		c.close();
		ps.close();
	}

	public static void updateItemTimesExecuted(int timesExecuted, int idItem) throws Exception {

		System.out.println("--------------------Update Times Executed-----------------------");
		Connection c = getConnection();
		
		PreparedStatement ps = c.prepareStatement("UPDATE ItemSeries SET times_executed = ? WHERE id_item = ?");
		ps.setInt(1, timesExecuted);
		ps.setInt(2, idItem);
		
		int res = ps.executeUpdate();
		//c.commit();
		
		if (res != 1) {
			System.out.println("Não executou a query");
		}
		
		c.close();
		ps.close();
	}
	
	public static void updatePaymentStatus(boolean payment_status, String mounthly) throws Exception {

		System.out.println("--------------------Update PaymentStatus-----------------------");
		Connection c = getConnection();
		
		PreparedStatement ps = c.prepareStatement("UPDATE Pay SET payment_status = ? WHERE mounthly = ?");
		ps.setBoolean(1, payment_status);
		ps.setString(2, mounthly);
		
		int res = ps.executeUpdate();
		//c.commit();
		
		if (res != 1) {
			System.out.println("Não executou a query");
		}
		
		c.close();
		ps.close();
	}


	public static boolean insertMember(String full_name, String cpf, String rg, 
			String city, String address, String postal_code, String phone, String email, 
			DatePicker dateBirth, int age, String gender, boolean medical_certificate, 
			String contract, String payment_type, String payday) throws Exception {

		System.out.println("--------------------Iniciando cadastro de novo Member-----------------------");
		Connection c = getConnection();

		PreparedStatement ps = c.prepareStatement("INSERT INTO Member (full_name, cpf, rg, city, address, "
				+ "postal_code, phone, email, gender, date_birth, age, medical_certificate, contract, "
				+ "payment_type, payday)" + "VALUES" + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

		System.out.println("full_name: " + full_name);
		ps.setString(1, full_name);

		System.out.println("CPF: " + cpf);
		ps.setString(2, cpf);

		System.out.println("RG: " + rg);
		ps.setString(3, rg);

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

		System.out.println("age: " + age);
		ps.setInt(10, age);

		System.out.println("gender: " + gender);
		ps.setString(11, gender);

		System.out.println("medical_certificate: " + medical_certificate);
		ps.setBoolean(12, medical_certificate);

		System.out.println("contract: " + contract);
		ps.setString(13, contract);

		System.out.println("payment_type: " + payment_type);
		ps.setString(14, payment_type);

		System.out.println("payday: " + payday);
		ps.setString(15, payday);

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
	
	public static boolean insertMedicalCertificate(String memberCpf, String nameMedic, String crm, 
			DatePicker dateStart, DatePicker dateEnd) throws Exception {

		System.out.println("--------------------Iniciando cadastro de atestado médico-----------------------");
		Connection c = getConnection();

		PreparedStatement ps = c.prepareStatement("INSERT INTO MedicalCertificate (member_cpf, crm, medic_name, "
				+ "date_start, date_end)" + "VALUES" + "(?,?,?,?,?)");

		System.out.println("member_cpf: " + memberCpf);
		ps.setString(1, memberCpf);

		System.out.println("nameMedic: " + nameMedic);
		ps.setString(2, nameMedic);

		System.out.println("crm: " + crm);
		ps.setString(3, crm);

		System.out.println("date_start: " + dateStart.getValue());
		ps.setString(4, ((TextField)dateStart.getEditor()).getText());

		System.out.println("date_end: " + dateEnd.getValue());
		ps.setString(5, ((TextField)dateStart.getEditor()).getText());

		int res = ps.executeUpdate();

		if (res != 1) {
			System.out.println("Não executou a query");
			return false;
		}

		System.out.println("-------------------Atestado médico cadastrado-----------------");
		c.close();
		ps.close();

		return true;
	}

	public static ItemSeries getSingleItemSeries (int idItem) throws SQLException, Exception {

		Connection c = getConnection();
		Statement stmt = null;
		stmt = c.createStatement();
		//Series series = new Series();

		PreparedStatement ps = c.prepareStatement("SELECT * FROM ItemSeries WHERE id_item = ?");  

		//Aqui você seta os valores dos ?   
		ps.setInt(1, idItem); 
	
		ResultSet rs = ps.executeQuery();

		System.out.println("Fazendo consulta da serie");

		while (rs.next()) {

			itemSeries.setMemberCpf((rs.getString("member_cpf")));
			System.out.println("member member_cpf:" + itemSeries.getMemberCpf());

			itemSeries.setIdItem((rs.getInt("id_item")));
			System.out.println("id Item:" + itemSeries.getIdItem());

			itemSeries.setIdSerie((rs.getInt("id_series")));
			System.out.println("id Serie:" + itemSeries.getIdSerie());

			itemSeries.setWorkout((rs.getString("workout")));
			System.out.println("workout:" + itemSeries.getWorkout());

			itemSeries.setTimesExecuted((rs.getInt("times_executed")));
			System.out.println("times executed:" + itemSeries.getTimesExecuted());

			itemSeries.setExerciseName((rs.getString("exercise_name")));
			System.out.println("exercise name:" + itemSeries.getExerciseName());

			itemSeries.setEquipment((rs.getString("equipment")));
			System.out.println("equipment:" + itemSeries.getEquipment());

			itemSeries.setQtdSeries((rs.getString("qtd_series")));
			System.out.println("qtd series:" + itemSeries.getQtdSeries());

			itemSeries.setReps((rs.getString("reps")));
			System.out.println("reps:" + itemSeries.getReps());

			itemSeries.setWeight((rs.getString("weight")));
			System.out.println("weight:" + itemSeries.getWeight());

			itemSeries.setRegulation((rs.getString("regulation")));
			System.out.println("regulation:" + itemSeries.getRegulation());

			itemSeries.setObs((rs.getString("obs")));
			System.out.println("obs:" + itemSeries.getObs());
			 
			System.out.println("Consulta realizada");
		}

		rs.close();
		stmt.close();
		c.close();

		return itemSeries;		
	}
	
	public static Pay getMounthly (String mounthly) throws SQLException, Exception {

		Connection c = getConnection();
		Statement stmt = null;
		stmt = c.createStatement();
		//Series series = new Series();

		PreparedStatement ps = c.prepareStatement("SELECT * FROM Pay WHERE mounthly = ?");  

		//Aqui você seta os valores dos ?   
		ps.setString(1, mounthly); 
	
		ResultSet rs = ps.executeQuery();

		System.out.println("Fazendo consulta da serie");

		while (rs.next()) {
			
			pay.setMemberCpf((rs.getString("member_cpf")));
			System.out.println("member_cpf:" + pay.getMemberCpf());

			pay.setMounthly((rs.getString("mounthly")));
			System.out.println("mounthly:" + pay.getMounthly());
			
			pay.setAmount((rs.getDouble("amount")));
			System.out.println("amount:" + pay.getAmount());
			
			pay.setPaymentStatus((rs.getBoolean("payment_status")));
			System.out.println("payment_status:" + pay.getPaymentStatus());
			 
			System.out.println("Consulta realizada");
		}

		rs.close();
		stmt.close();
		c.close();

		return pay;		
	}

	public static ItemSeries getItemSeries (String member_cpf, String workout, ObservableList<ItemSeries> data) throws SQLException, Exception {

		Connection c = getConnection();
		Statement stmt = null;
		stmt = c.createStatement();
		//Series series = new Series();

		PreparedStatement ps = c.prepareStatement("SELECT * FROM ItemSeries WHERE member_cpf = ? AND workout = ?");  

		//Aqui você seta os valores dos ?   
		ps.setString(1, member_cpf); 
		ps.setString(2, workout);
		ResultSet rs = ps.executeQuery();

		System.out.println("Fazendo consulta da serie");

		while (rs.next()) {

			itemSeries.setMemberCpf((rs.getString("member_cpf")));
			System.out.println("member_cpf:" + itemSeries.getMemberCpf());

			itemSeries.setIdItem((rs.getInt("id_item")));
			System.out.println("id_item:" + itemSeries.getIdItem());

			itemSeries.setIdSerie((rs.getInt("id_series")));
			System.out.println("id_series:" + itemSeries.getIdSerie());

			itemSeries.setWorkout((rs.getString("workout")));
			System.out.println("workout:" + itemSeries.getWorkout());

			itemSeries.setTimesExecuted((rs.getInt("times_executed")));
			System.out.println("times_executed:" + itemSeries.getTimesExecuted());

			itemSeries.setExerciseName((rs.getString("exercise_name")));
			System.out.println("exercisename:" + itemSeries.getExerciseName());

			itemSeries.setEquipment((rs.getString("equipment")));
			System.out.println("equipment:" + itemSeries.getEquipment());

			itemSeries.setQtdSeries((rs.getString("qtd_series")));
			System.out.println("qtd series:" + itemSeries.getQtdSeries());

			itemSeries.setReps((rs.getString("reps")));
			System.out.println("reps:" + itemSeries.getReps());

			itemSeries.setWeight((rs.getString("weight")));
			System.out.println("weight:" + itemSeries.getWeight());

			itemSeries.setRegulation((rs.getString("regulation")));
			System.out.println("regulation:" + itemSeries.getRegulation());

			itemSeries.setObs((rs.getString("obs")));
			System.out.println("obs:" + itemSeries.getObs());

			data.add(new ItemSeries(
					rs.getString("member_cpf"),
					rs.getInt("id_item"),
					rs.getInt("id_series"),
					rs.getString("workout"),
					rs.getInt("times_executed"),
					rs.getString("exercise_name"),
					rs.getString("equipment"),
					rs.getString("qtd_series"),
					rs.getString("reps"),
					rs.getString("weight"),
					rs.getString("regulation"),
					rs.getString("obs")
					));

			System.out.println("Consulta realizada");
		}

		rs.close();
		stmt.close();
		c.close();

		return itemSeries;		
	}

	public static Series getSeries (String memberCpf) throws SQLException, Exception {

		Connection c = getConnection();
		Statement stmt = null;
		stmt = c.createStatement();
		//Series series = new Series();

		PreparedStatement ps = c.prepareStatement("SELECT * FROM Series WHERE member_cpf = ? ");  

		//Aqui você seta os valores dos ?   
		ps.setString(1, memberCpf);   
		ResultSet rs = ps.executeQuery();

		System.out.println("Fazendo consulta da serie");

		while (rs.next()) {

			series.setId(rs.getInt("id"));
			System.out.println("Conteudo da consulta do id da serie:" + series.getId());

			series.setMemberCpf(rs.getString("member_cpf"));
			System.out.println("Conteudo da consulta do id_series do member:" + series.getMemberCpf());

			series.setWorkoutA(rs.getBoolean("workout_a"));
			System.out.println("Conteudo da consulta do workout_a:" + series.getWorkoutA());

			series.setWorkoutB(rs.getBoolean("workout_b"));
			System.out.println("Conteudo da consulta do workout_b:" + series.getWorkoutB());

			series.setWorkoutC(rs.getBoolean("workout_c"));
			System.out.println("Conteudo da consulta do workout_c:" + series.getWorkoutC());

			series.setDateStart(rs.getString("date_start"));
			System.out.println("Conteudo da consulta da dateStart:" + series.getDateStart());

			series.setDateEnd(rs.getString("date_end"));
			System.out.println("Conteudo da consulta do dateEnd:" + series.getDateEnd());

			System.out.println("Consulta realizada");
		}

		rs.close();
		stmt.close();
		c.close();

		return series;		
	}

	public static void insertSeries(String memberCpf, boolean workout_a, boolean workout_b, 
			boolean workout_c, DatePicker dateStart, DatePicker dateEnd) throws Exception {

		System.out.println("--------------------Iniciando cadastro de nova Serie-----------------------");
		Connection c = getConnection();

		PreparedStatement ps = c.prepareStatement("INSERT INTO Series (member_cpf, workout_a, workout_b, workout_c, "
				+ "date_start, date_end)" + "VALUES" + "(?,?,?,?,?,?)");

		System.out.println("member_cpf: " + memberCpf);
		ps.setString(1, memberCpf);

		System.out.println("workout_a: " + workout_a);
		ps.setBoolean(2, workout_a);

		System.out.println("workout_b: " + workout_b);
		ps.setBoolean(3, workout_b);

		System.out.println("workout_c: " + workout_c);
		ps.setBoolean(4, workout_c);
		
		System.out.println("date_start: " + dateStart.getValue());
		ps.setString(5, ((TextField)dateStart.getEditor()).getText());
		
		System.out.println("date_end: " + dateEnd.getValue());
		ps.setString(6, ((TextField)dateEnd.getEditor()).getText());

		int res = ps.executeUpdate();

		if (res != 1) {
			System.out.println("Não executou a query");
		}

		System.out.println("-------------------Serie cadastrada-----------------");
		c.close();
		ps.close();
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

	//PARECIDO PARA GET ITEM SERIES
	public static Pay getPay (String memberCpf, ObservableList<Pay> data) throws SQLException, Exception {

		Connection c = getConnection();
		Statement stmt = null;
		stmt = c.createStatement();

		PreparedStatement ps = c.prepareStatement("SELECT * FROM Pay WHERE member_cpf = ? ");  

		//Aqui você seta os valores dos ?   
		ps.setString(1, memberCpf);   
		ResultSet rs = ps.executeQuery();

		System.out.println("Fazendo consulta de usuario");

		while (rs.next()) {

			pay.setMemberCpf(rs.getString("member_cpf"));
			System.out.println("Conteudo da consulta do member_cpf:" + pay.getMemberCpf());

			pay.setMounthly(rs.getString("mounthly"));
			System.out.println("Conteudo da consulta do mounthly:" + pay.getMounthly());

			pay.setAmount(rs.getDouble("amount"));
			System.out.println("Conteudo da consulta do amount:" + pay.getAmount());

			pay.setPaymentStatus(rs.getBoolean("payment_status"));
			System.out.println("Conteudo da consulta da payment_status:" + pay.getPaymentStatus());

			data.add(new Pay(
					rs.getString("member_cpf"),
					rs.getString("mounthly"),
					rs.getDouble("amount"),
					rs.getBoolean("payment_status")
					));

			System.out.println("Consulta realizada");
		}

		rs.close();
		stmt.close();
		c.close();

		return pay;		
	}
}

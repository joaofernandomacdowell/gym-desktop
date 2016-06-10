package br.com.joao.gym.application;

import java.io.IOException;
import br.com.joao.gym.conection.DataBase;
import br.com.joao.gym.model.User;
import br.com.joao.gym.view.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;
	DataBase connection;
	User user;

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("SmartFit");

		//Adiciona o ícone da SmartFit
		this.primaryStage.getIcons().add(new Image("file:resources/images/smart_fit.png"));

		//carrega o layout
		initRootLayout();

		showLogin();
		//showRegisterMember();
	}

	//Inicializa o root layout (layout base).
	public void initRootLayout() {
		try {
			// Carrega o root layout do arquivo fxml.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/br/com/joao/gym/view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();

			// Mostra a scene (cena) contendo o root layout.
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		}

		catch (IOException e) {
			e.printStackTrace();
		}
	}

	//Mostra o Login dentro do root layout.
	public void showLogin() throws Exception {

		try {
			// Carrega a person overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/br/com/joao/gym/view/Login.fxml"));
			AnchorPane Login = (AnchorPane) loader.load();
			// Define a person overview no centro do root layout.
			rootLayout.setCenter(Login);

			//Define o controller da view Login
			LoginController controller = loader.getController();

			try {
				controller.setLogin(user);

			} catch (Exception e) {
				e.printStackTrace();
			}

			controller.setMainApp(this);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//Mostra o MenuAdmin dentro do root layout
	public boolean showMenuAdmin() throws Exception {

		try {
			// Carrega o registerMember.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/br/com/joao/gym/view/MenuAdmin.fxml"));
			AnchorPane RegisterMember = (AnchorPane) loader.load();

			// Define o person overview dentro do root layout.
			rootLayout.setCenter(RegisterMember);

			//Define o controller da view RegisterMember
			MenuAdminController controller = loader.getController();

			controller.setMainApp(this);

			return true;
		}

		catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	//Mostra o MenuRecepcionist dentro do root layout.
	public boolean showMenuReceptionist() throws Exception {

		try {
			// Carrega o registerMember.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/br/com/joao/gym/view/MenuReceptionist.fxml"));
			AnchorPane RegisterMember = (AnchorPane) loader.load();

			// Define o person overview dentro do root layout.
			rootLayout.setCenter(RegisterMember);

			//Define o controller da view MenuReceptionist
			MenuReceptionistController controller = loader.getController();

			controller.setMainApp(this);

			return true;
		}

		catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	//Mostra o MenuInstructor dentro do root layout
	public boolean showMenuInstructor() throws Exception {

		try {
			// Carrega o registerMember.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/br/com/joao/gym/view/MenuInstructor.fxml"));
			AnchorPane RegisterMember = (AnchorPane) loader.load();

			// Define o person overview dentro do root layout.
			rootLayout.setCenter(RegisterMember);

			//Define o controller da view MenuInstructor
			MenuInstructorController controller = loader.getController();

			controller.setMainApp(this);

			return true;
		}

		catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	//Mostra o RegisterMember dentro do root layout.
	public boolean showRegisterMember() throws Exception {

		try {
			// Carrega o registerMember.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/br/com/joao/gym/view/RegisterMember.fxml"));
			AnchorPane RegisterMember = (AnchorPane) loader.load();

			// Define o person overview dentro do root layout.
			rootLayout.setCenter(RegisterMember);

			//Define o controller da view RegisterMember
			RegisterMemberController controller = loader.getController();

			controller.setMainApp(this);

			return true;
		}

		catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	//Mostra o VerifyPayment dentro do root layout.
	public boolean showVerifyPayment() throws Exception {

		try {
			// Carrega o registerMember.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/br/com/joao/gym/view/VerifyPayment.fxml"));
			AnchorPane RegisterMember = (AnchorPane) loader.load();

			// Define o person overview dentro do root layout.
			rootLayout.setCenter(RegisterMember);

			//Define o controller da view VerifyPayment
			VerifyPaymentController controller = loader.getController();

			controller.setMainApp(this);

			return true;
		}

		catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	//Mostra o ScheduleEvaluation dentro do root layout.
	public boolean showScheduleEvaluation() throws Exception {

		try {
			// Carrega o registerMember.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/br/com/joao/gym/view/ScheduleEvaluation.fxml"));
			AnchorPane RegisterMember = (AnchorPane) loader.load();

			// Define o person overview dentro do root layout.
			rootLayout.setCenter(RegisterMember);

			//Define o controller da view ScheduleEvaluation
			RegisterMemberController controller = loader.getController();

			controller.setMainApp(this);

			return true;
		}

		catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	//Mostra o MenuInstructor dentro do root layout
	public boolean showCreateSeries() throws Exception {

		try {
			// Carrega o registerMember.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/br/com/joao/gym/view/CreateSeries.fxml"));
			AnchorPane RegisterMember = (AnchorPane) loader.load();

			// Define o person overview dentro do root layout.
			rootLayout.setCenter(RegisterMember);

			//Define o controller da view CreateSeries
			CreateSeriesController controller = loader.getController();

			controller.setMainApp(this);

			return true;
		}

		catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	//Mostra o MenuInstructor dentro do root layout
	public boolean showCurrentSeries() throws Exception {

		try {
			// Carrega o registerMember.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/br/com/joao/gym/view/CurrentSeries.fxml"));
			AnchorPane RegisterMember = (AnchorPane) loader.load();

			// Define o person overview dentro do root layout.
			rootLayout.setCenter(RegisterMember);

			//Define o controller da view CurrentSeries
			CurrentSeriesController controller = loader.getController();

			controller.setMainApp(this);

			return true;
		}

		catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	//Retorna a stage principal
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) throws Exception {
		DataBase.getConnection();
		launch(args);
	}
}
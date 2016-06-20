package br.com.joao.gym.view;

import br.com.joao.gym.application.MainApp;
import br.com.joao.gym.model.User;

public class MenuAdminController {

	User user;
	MainApp mainApp;
	
	
	public void setMenuAdmin(User user) {
		this.user = user;
	}
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		
	}

}

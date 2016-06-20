package br.com.joao.gym.view;

import br.com.joao.gym.application.MainApp;
import br.com.joao.gym.model.User;

public class CurrentSeriesController {
	
	User user;
	MainApp mainApp;

	
	public void setCurrentSeries(User user) {
		this.user = user;
	}
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
}

package nd.create.folkcast.view;

import javafx.fxml.FXML;
import nd.create.folkcast.MainApplication;


public class RootLayoutController {
	
	MainApplication mainApp;

	public RootLayoutController() {
		// TODO Auto-generated constructor stub
	}
	
    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApplication mainApp) {
        this.mainApp = mainApp;
    }
    
    @FXML
    private void handelClose(){
    	System.exit(0);
    }
    
    @FXML
    public void hangelNewFeed(){
    	mainApp.showNewFeedDialog();
    }

}

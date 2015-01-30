package nd.create.folkcast.view;

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

}

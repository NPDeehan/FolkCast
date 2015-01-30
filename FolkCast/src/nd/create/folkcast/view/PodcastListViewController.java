package nd.create.folkcast.view;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import nd.create.folkcast.MainApplication;
import nd.create.folkcast.model.Feed;

public class PodcastListViewController {
	
	private MainApplication mainApp;
	
    @FXML
    private TableView<Feed> feedTable;
    @FXML
    private TableColumn<Feed, String> feedNameColumn;

	public PodcastListViewController() {
		// TODO Auto-generated constructor stub
	}
	
    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApplication mainApp) {
        this.mainApp = mainApp;
        feedTable.setItems(mainApp.getPodcastData());
    }
    
    @FXML
    private void initialize() {

    	feedNameColumn.setCellValueFactory(
	                cellData -> cellData.getValue().getTitleAsStringProperty());
		
    	feedTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> setFeed(newValue));

    }

	private Object setFeed(Feed newValue) {
		// TODO Auto-generated method stub
		return null;
	}


}

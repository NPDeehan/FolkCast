package nd.create.folkcast.view;


import nd.create.folkcast.MainApplication;
import nd.create.folkcast.model.Feed;
import nd.create.folkcast.utils.RSSFeedParser;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class NewFeedDialogController {
	

	public NewFeedDialogController() {
		
	}
	
	
	private MainApplication mainApp;
	private Feed newFeed;
	
	private Stage dialogStage;
	@FXML
	private Button okButton;
	@FXML
	private Button cancellButton;
	

	@FXML
	private TextField sourceURLField;
	@FXML
	private TextField titleField;
	@FXML
	private TextField descriptionField;
	@FXML
	private TextField linkField;
	@FXML
	private TextField authorField;
	@FXML
	private TextField pubDateField;
	@FXML
	private TextField copyrightField;
	@FXML
	private TextField laungageField;
	
	@FXML
	private void initialize(){
		
	}
	
	public void setMainApp(MainApplication thisMainApp ){
		mainApp = thisMainApp;
	}

	 
	  /**
		  * Sets the stage of this dialog.
		  * 
		  * @param dialogStage
	  */
	  public void setDialogStage(Stage dialogStage) {
	        this.dialogStage = dialogStage;
	   }
	  
	  @FXML
	  public void handleOK()
	  {

		  	dialogStage.close();
		  	mainApp.addPodcastToList(newFeed);
		  	

	  }
	  @FXML
	  public void handleCancel()
	  {
		  dialogStage.close();
	  }
	  
	  @FXML
	  public void handleEnterPressed(KeyEvent event){
	      if (event.getCode() == KeyCode.ENTER) {
	          parseNewFeed();
	      }
	  }



	private void parseNewFeed() {
		
	  	RSSFeedParser parser = new RSSFeedParser(sourceURLField.getText());
	  	newFeed = parser.readFeed();
	  	
	  	descriptionField.setText(newFeed.getDescription());
	  	titleField.setText(newFeed.getTitle());
	  	linkField.setText(newFeed.getLink());
	  	laungageField.setText(newFeed.getLanguage());
	  	copyrightField.setText(newFeed.getCopyright());
	  	pubDateField.setText(newFeed.getPubDate());
	  	//authorField.setText(feed.get);
		
	}

}

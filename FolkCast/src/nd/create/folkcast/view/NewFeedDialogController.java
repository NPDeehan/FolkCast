package nd.create.folkcast.view;


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
	  	Feed feed = parser.readFeed();
	  	
	  	descriptionField.setText(feed.getDescription());
	  	titleField.setText(feed.getTitle());
	  	linkField.setText(feed.getLink());
	  	laungageField.setText(feed.getLanguage());
	  	copyrightField.setText(feed.getCopyright());
	  	pubDateField.setText(feed.getPubDate());
	  	//authorField.setText(feed.get);
		
	}

}

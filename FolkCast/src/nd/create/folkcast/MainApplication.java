package nd.create.folkcast;

import java.io.IOException;

import nd.create.folkcast.model.Feed;
import nd.create.folkcast.view.NewFeedDialogController;
import nd.create.folkcast.view.PodcastListViewController;
import nd.create.folkcast.view.RootLayoutController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainApplication extends Application { 
	
    private Stage primaryStage;
    private BorderPane rootLayout;
    
    private RootLayoutController rootLayoutController;
    private PodcastListViewController podcastListViewController;
    
	// This will hold all of the Feeds   
    private ObservableList<Feed> rssFeeds = FXCollections.observableArrayList();
  

	public MainApplication() {
		// TODO Auto-generated constructor stub
	}

    /*
     * Launches the application
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    /**
     * Returns the data as an observable list of Rss Feeds. 
     * @return
     */
    public ObservableList<Feed> getPodcastData() {
        return rssFeeds;
    }
    
	/**
	 * This will add a feed to the global list.
	 * @param question
	 */
	public void addPodcastToList(Feed rssFeed)
	{
		rssFeeds.add(rssFeed);
	}
    

	@Override
	public void start(Stage primaryStage) throws Exception {

		   this.primaryStage = primaryStage;
	       this.primaryStage.setTitle("Folk Cast");
	      // this.primaryStage.getIcons().add(new Image("file:resources/images/SOMETHING.png"));

	       initRootLayout();
	       
	       initPodcastListView();

		
	}

	private void initPodcastListView() {
    	try {
            // Load podcast overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApplication.class.getResource("view/PodcastListView.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            // Set podcast overview into the center of root layout.
            rootLayout.setCenter(personOverview);

            // Give the controller access to the main app.
            PodcastListViewController controller = loader.getController();
            controller.setMainApp(this);
            podcastListViewController = controller;

        } catch (IOException e) {
            e.printStackTrace();
        }
	
		
	}

	private void initRootLayout() {
		 try {
	            // Load root layout from fxml file.
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(MainApplication.class
	                    .getResource("view/RootLayout.fxml"));
	            rootLayout = (BorderPane) loader.load();

	            // Show the scene containing the root layout.
	            Scene scene = new Scene(rootLayout);
	            primaryStage.setScene(scene);

	            // Give the controller access to the main app.
	            RootLayoutController controller = loader.getController();
	            controller.setMainApp(this);
	            rootLayoutController = controller;

	            primaryStage.show();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		
	}


		   /**
	     * A quiz answer can contain a Source for the answer given, it's optional but if a user
	     * chooses to do it, this is the dialog that will help them do that.
	     * @param quizAns
	     * @return
	     */
	    public boolean showNewFeedDialog(){
	    	try{
	    		
		    	FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(MainApplication.class.getResource("view/NewFeedDialog.fxml"));
	            AnchorPane page = (AnchorPane) loader.load();
	            Stage dialogStage = new Stage();
	            dialogStage.setTitle("Add New Feed");
	            dialogStage.initModality(Modality.WINDOW_MODAL);
	            dialogStage.initOwner(primaryStage);
	            Scene scene = new Scene(page);
	            dialogStage.setScene(scene);
	            
	            NewFeedDialogController controller = loader.getController();
	            controller.setDialogStage(dialogStage);
	            controller.setMainApp(this);
	            //controller.initialize();
	            dialogStage.show();
	            
	            return true;
	    	}
            catch(Exception e){
            	e.printStackTrace();
            	return false;
            }
            
	    }
	    
	    
	    
		
	}

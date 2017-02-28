package hack.moviedb;

import java.io.IOException;

import hack.moviedb.data.Movie;
import hack.moviedb.data.MovieHeader;
import hack.moviedb.data.MovieList;
import hack.moviedb.data.PersonHeader;
import hack.moviedb.view.MovieSearchAddController;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

//    /**
//     * The data as an observable list of Persons.
//     */
//    private ObservableList<Movie> movieData = FXCollections.observableArrayList();
//    
//    
//    /**
//     * Constructor
//     */
//    public MainApp() {
//    	
//    	MovieList list = new MovieList();
//    	list.addMovieToList(new Movie(new MovieHeader("title", 10, "poop", "as;ldkfj"), "20160816", 
//    			new String[]{"myster"}, "The", false, "paramount", 
//    			new PersonHeader[]{ }, new PersonHeader[]{}));
//    	
//    	for(int i = 0; i < list.getSize(); i++){
//    		movieData.add(list.retrieveMovie(i));
//    	}
//        
//    }
//    
//    /**
//     * Returns the data as an observable list of Persons. 
//     * @return
//     */
//    public ObservableList<Movie> getMovieData() {
//        return movieData;
//    }
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Movie DB");

        initRootLayout();

        showPersonOverview();
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayer.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the person overview inside the root layout.
     */
    public void showPersonOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/MovieSearchAdd.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(personOverview);
            
            // Give the controller access to the main app.
            MovieSearchAddController controller = loader.getController();
            controller.setMainApp(this);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
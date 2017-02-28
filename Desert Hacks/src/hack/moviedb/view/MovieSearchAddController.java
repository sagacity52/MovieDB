package hack.moviedb.view;

import hack.moviedb.MainApp;
import hack.moviedb.active.JsonParser;
import hack.moviedb.data.Movie;
import hack.moviedb.data.MovieHeader;
import hack.moviedb.web.WebTalker;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.util.Callback;

public class MovieSearchAddController {

	private ObservableList<MovieHeader> movieData =  FXCollections.observableArrayList();

	@FXML
	private TableView<MovieHeader> movieTable;
	@FXML
	private TableColumn<MovieHeader, Boolean> selectBox;
	@FXML
	private TableColumn<MovieHeader, Image> picture;
	@FXML
	private TableColumn<MovieHeader, String> movieTitle;
	@FXML
	private TableColumn<MovieHeader, Number> yearReleased;
	@FXML 
	private TextField searchField;
	@FXML
	private RadioButton checkMovieTitle;
	@FXML
	private RadioButton checkActorName;
	@FXML
	private RadioButton checkBothMovieActor;
	@FXML
	private ToggleGroup checkMovieActor;



	// Reference to the main application.
	private MainApp mainApp;

	/**
	 * The constructor.
	 * The constructor is called before the initialize() method.
	 */
	public MovieSearchAddController() {
	}

	/**
	 * Called when the user clicks the new button. Opens a dialog to edit
	 * details for a new person.
	 */
	@FXML
	private void handleAdd() {
		System.out.println("Adding Selecting to List");
		
//	    TableColumn<MovieHeader, Boolean>  checkCol = new TableColumn<>("Check");
//	    checkCol.setCellValueFactory( new PropertyValueFactory<MovieHeader,Boolean>( "checked" ) );
//	    checkCol.setCellFactory( CheckBoxTableCell.forTableColumn( checkCol ) );
	    System.out.println(selectBox.getCellData(0));
	    System.out.println(selectBox.getCellObservableValue(0));
	    
//	    checkCol.setCellValueFactory(cellData -> cellData.getValue().checkedProperty());
	    selectBox.setCellValueFactory(cellData -> cellData.getValue().checkedProperty());
	    
	    System.out.println(selectBox.getCellData(0));
	    System.out.println(selectBox.getCellObservableValue(0));
	    
	    movieData.stream().forEach(e -> System.out.println(e.getChecked()));
	    
	}

	/**
	 * Called when the user clicks the edit button. Opens a dialog to edit
	 * details for the selected person.
	 */
	@FXML
	private void handleGoSearch() {
		
		if(this.checkActorName.isSelected())
			System.out.println("Person search selected");
		else if(this.checkMovieTitle.isSelected())
			System.out.println("Title search selected");
		else
			System.out.println("Searching both Title and Person");
		
		
		if(movieTable != null){
			movieData.clear();
			movieTable.setItems(movieData);
		}
		try {
			String configData = WebTalker.retrieveConfiguration();
			JsonParser.parseConfigData(configData);
			String data = WebTalker.searchForMovie(searchField.getText());
			MovieHeader[] headerList = JsonParser.parseMovieSearchResults(data);
			for(int i = 0; i < headerList.length; i++){
				movieData.add(headerList[i]);
			}
			movieTable.setItems(movieData);

		} catch (Exception e) {

			e.printStackTrace();
		}
		//}
		//if(checkMovieTitle.armedProperty() != null){
		try {

		} catch (Exception e) {

			e.printStackTrace();
		}
		//}


	}


	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		// Initialize the person table with the two columns.
		selectBox.setCellFactory(new Callback<TableColumn<MovieHeader, Boolean>, TableCell<MovieHeader, Boolean>>() {

			public TableCell<MovieHeader, Boolean> call(TableColumn<MovieHeader, Boolean> p) {
				return new CheckBoxTableCell<MovieHeader, Boolean>();
			}
		});
		selectBox = new TableColumn<MovieHeader, Boolean>("checked");
		selectBox.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<MovieHeader, Boolean>, ObservableValue<Boolean>>() {

		                @Override
		                public ObservableValue<Boolean> call(CellDataFeatures<MovieHeader, Boolean> param) {
		                    return param.getValue().checkedProperty();
		                }
		            });
		selectBox.setCellFactory(CheckBoxTableCell.forTableColumn(selectBox));

		
//	    TableColumn<MovieHeader, Boolean>  checkCol = new TableColumn<>("Check");
//	    checkCol.setCellValueFactory( new PropertyValueFactory<MovieHeader,Boolean>( "checked" ) );
//	    checkCol.setCellFactory( CheckBoxTableCell.forTableColumn( checkCol ) );
		
		movieTitle.setCellValueFactory(cellData -> cellData.getValue().getTitle());	
		yearReleased.setCellValueFactory(cellData -> cellData.getValue().getID());


		//picture.setImage(new Image("http://image.tmdb.org/t/p/original/IfB9hy4JH1eH6HEfIgIGORXi5h.jpg"));

		//    	picture2.setCellFactory(new Callback<TableColumn<Movie, Image>, TableCell<Movie, Image>>() {
		//
		//			public TableCell<Movie, Image> call(TableColumn<Movie, Image> param) {
		//				return new ImageTableCell<Movie, Image>();
		//			}
		//    	});

		//    	class ImageTableCell extends TableCell<Movie, ImageView>{
		//    		VBox vb;
		//    		ImageView imgVw;
		//    		
		//    		public ImageTableCell(){
		//    			vb = new VBox();
		//    			vb.setAlignment(Pos.CENTER);
		//    			imgVw = new ImageView();
		//    			imgVw.setFitHeight(50);
		//    			imgVw.setFitWidth(100);
		//    			vb.getChildren().add(imgVw);
		//    			setGraphic(vb);
		//    		}

		//    		@Override
		//    		public void updateItem(ImageView item, boolean e){
		//    			if(item != null){
		//    				System.out.println("1");
		//    			
		//    				imgVw.toFront();
		//    			}
		//    			else
		//    				System.out.println("2");
		//    		}
		//    	}
		//    		
		//    	});



	}



	/**
	 * Is called by the main application to give a reference back to itself.
	 *                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
	 * @param mainApp
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		//		// Add observable list data to the table
		//		movieTable.setItems(this.mainApp.getMovieData());

	}
}
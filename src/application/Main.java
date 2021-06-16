package application;
	
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {
	
	//Declaring columns :
	TableColumn<Movie,String> colTitle;
	TableColumn<Movie,String> colYear;
	TableColumn<Movie,String> colPrice;
	
	//Declaring Table
	TableView<Movie> table=new TableView<Movie>();
	
	//Declaring TextFileds :
	TextField titleField=new TextField();
	TextField yearField=new TextField();
	TextField priceField=new TextField();
	
	//Declaring Buttons:
	Button btnAdd=new Button("Add");
	Button btnDel=new Button("Delete");
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			//Initializing Columns with there headings :
			colTitle=new TableColumn<Movie,String>("Title");
			colPrice=new TableColumn<Movie,String>("Price");
			colYear=new TableColumn<Movie,String>("Year");
			
			//Defining columns cell values type :
			colTitle.setCellValueFactory(cellData->cellData.getValue().titleProperty());
			colYear.setCellValueFactory(cellData->cellData.getValue().yearProperty());
			colPrice.setCellValueFactory(cellData->cellData.getValue().priceProperty());
			
			//Make Title Cell Editable:
			table.setEditable(true);
			colTitle.setCellFactory(TextFieldTableCell.forTableColumn());
			
			//Adjusting Columns  Size:
			colTitle.setPrefWidth(200);colTitle.setMinWidth(200);colTitle.setMaxWidth(200);
			colYear.setPrefWidth(100);colYear.setMinWidth(100);colYear.setMaxWidth(100);
			colPrice.setPrefWidth(100);colPrice.setMinWidth(100);colPrice.setMaxWidth(100);
			VBox.setMargin(table, new Insets(10));
			
			//Adding columns to table :
			table.getColumns().addAll(colTitle,colYear,colPrice);
			//Loading data into table:
			table.setItems(loadData());
			
			//Setting PromptText for Fields :
			titleField.setPromptText("Title");
			yearField.setPromptText("Year");
			priceField.setPromptText("Price");
			
			//Adjusting Fields Size:
			titleField.setPrefWidth(150);titleField.setMinWidth(150);titleField.setMaxWidth(150);
			yearField.setPrefWidth(80);yearField.setMinWidth(80);yearField.setMaxWidth(80);
			priceField.setPrefWidth(80);priceField.setMinWidth(80);priceField.setMaxWidth(80);
			HBox.setMargin(titleField, new Insets(0,0,0,10));
			HBox.setMargin(btnAdd, new Insets(0,0,10,0));
			HBox hLine =new HBox();
			hLine.getChildren().addAll(titleField,yearField,priceField,btnAdd,btnDel);
			HBox.setMargin(hLine, new Insets(0,0,10,0));
			//Setting buttons events:
			btnAdd.setOnAction(e->btnAddClicked());
			btnDel.setOnAction(e->btnDelClicked());
			VBox vLine = new VBox();
			vLine.getChildren().addAll(table,hLine);
			Scene scene = new Scene(vLine,420,420);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Movie Inventory");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ObservableList<Movie> loadData(){
		ObservableList<Movie> data=  FXCollections.observableArrayList();
		//Loading data --here we can bring data from files or data base
		data.add(new Movie("It's a Wonderful Life",1946, 14.95));
		data.add(new Movie("Young Frankenstein",1974, 16.95));
		data.add(new Movie("Star Wars Episode 4",1976, 17.95));
		data.add(new Movie("The Princess Bride",1987, 16.95));
		data.add(new Movie("Glory",1989, 14.95));
		data.add(new Movie("The Game",1997, 14.95));
		data.add(new Movie("Shakespeare in Love",1998, 19.95));
		data.add(new Movie("The Invention of Lying",2009, 18.95));
		data.add(new Movie("The King's Speech",2010, 19.95));
		return data;
	}
	
	public void btnAddClicked() {
		Movie m=new Movie();
		m.setPrice(Double.parseDouble(priceField.getText()));
		m.setYear(Integer.parseInt(yearField.getText()));
		m.setTitle(titleField.getText());
		
		table.getItems().add(m);
		
		priceField.clear();
		titleField.clear();
		yearField.clear();
	}
	
	public void btnDelClicked() {
		ObservableList<Movie> l;
		l=table.getSelectionModel().getSelectedItems();
		for(Movie m : l) {
			table.getItems().remove(m);
		}
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}

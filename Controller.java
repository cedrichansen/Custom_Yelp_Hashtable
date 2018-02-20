import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.ArrayList;

public class Controller {

    private ArrayList<YelpData> list;
    @FXML
    private Button searchButton;
    @FXML
    private TextField searchField;
    HashTable ht;
    @FXML
    TableView<YelpData> table;
    @FXML
    TableColumn<YelpData, String> businessName;
    @FXML
    TableColumn<YelpData, String> city;
    @FXML
    TableColumn<YelpData, String> categories;

    @FXML
    TableView<YelpData> similarTable;
    @FXML
    TableColumn<YelpData, String> similarName;
    @FXML
    TableColumn<YelpData, String> similarCity;
    @FXML
    TableColumn<YelpData, String> similarCategories;



    public ArrayList<YelpData> getAllBusinesses(HashTable ht) {
        ArrayList<YelpData> businesses = new ArrayList<>();

        for (int i = 0; i < ht.table.length; i++) {
            if (ht.table[i] != null) {
                for (int j = 0; j < ht.table[i].size(); j++) {
                    businesses.add(ht.table[i].get(j));
                }
            }
        }
        return businesses;
    }

    public void search(ActionEvent event) throws IOException {
        /*System.out.println("button pressed");
        System.out.println(searchButton.getId());
        System.out.println(searchField.getText());
        */

        for ( int i = 0; i<similarTable.getItems().size(); i++) {
            similarTable.getItems().clear();
        }

        YelpData test = new YelpData(searchField.getText(), null, null, 0,0);
        if (ht.contains(test,ht)){
            System.out.println("ht contains this element!");

            ArrayList<YelpData> similarBusinesses = Main.getManySimilar(searchField.getText(), ht);

            for (YelpData y : similarBusinesses) {
                System.out.println(y.toString());
            }

            ObservableList<YelpData> data = FXCollections.observableArrayList(similarBusinesses);
            similarName.setCellValueFactory(new PropertyValueFactory<>("name"));
            similarCity.setCellValueFactory(new PropertyValueFactory<>("city"));
            similarCategories.setCellValueFactory(new PropertyValueFactory<>("categories"));
            similarTable.getItems().addAll(data);

        } else {
            System.out.println("Business does not exist");

            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Input not valid");
            errorAlert.setContentText("Business does not exist");
            errorAlert.showAndWait();
        }
    }


    public void initialize() {

        ReadJson r = new ReadJson();

        ht= r.readToHash("business.json");

        list = getAllBusinesses(ht);
        final ObservableList<YelpData> data = FXCollections.observableArrayList(list);

        businessName.setCellValueFactory(
                new PropertyValueFactory<>("name"));

        city.setCellValueFactory(
                new PropertyValueFactory<>("city"));

        categories.setCellValueFactory(
                new PropertyValueFactory<>("categories"));

        table.getItems().addAll(data);

        System.out.println();

    }



}




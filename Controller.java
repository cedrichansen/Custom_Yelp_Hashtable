import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.ArrayList;

public class Controller {

    private ArrayList<YelpData> list;


    public void search(ActionEvent event) throws IOException {
        System.out.println("button pressed");
    }

    @FXML
    TableView<YelpData> table;

    @FXML
    TableColumn<YelpData, String> businessName;

    @FXML
    TableColumn<YelpData, String> city;

    @FXML
    TableColumn<YelpData, String> categories;

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


    public void initialize() {

        ReadJson r = new ReadJson();

        HashTable good = r.readToHash("business.json");

        list = getAllBusinesses(good);
        final ObservableList<YelpData> data = FXCollections.observableArrayList(list);

        businessName.setCellValueFactory(
                new PropertyValueFactory<>("name"));

        city.setCellValueFactory(
                new PropertyValueFactory<>("city"));

        categories.setCellValueFactory(
                new PropertyValueFactory<>("categories"));

        table.getItems().addAll(data);

    }

}




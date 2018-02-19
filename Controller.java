import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class Controller {



/*
    public void findSimilar(ActionEvent event) throws IOException {
        Parent homePageParent = FXMLLoader.load(getClass().getResource("Display.fxml"));
        Scene createLobbyScene = new Scene(homePageParent);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(createLobbyScene);
        appStage.show();
    }*/

    public void search(ActionEvent event) throws IOException {
        System.out.println("button pressed");
    }



}

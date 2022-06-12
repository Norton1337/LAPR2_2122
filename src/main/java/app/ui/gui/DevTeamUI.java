package app.ui.gui;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DevTeamUI implements Initializable {
    private App mainApp;
     Stage stage;
    @FXML
    private BorderPane borderPane;
    @FXML
    private AnchorPane anchorPane;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void btnGoBackMenu(ActionEvent actionEvent) throws IOException {
        Parent adverseMenu = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/Login.fxml"));
        Scene scene = new Scene(adverseMenu);
        Stage stage2 = new Stage();
        stage2.setScene(scene);
        stage2.setResizable(true);
        stage2.show();
    }

}

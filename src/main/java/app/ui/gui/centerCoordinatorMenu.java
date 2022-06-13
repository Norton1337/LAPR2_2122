package app.ui.gui;

import app.controller.AuthController;
import app.domain.model.Company;
import app.domain.model.VacCenter;
import app.ui.console.MainMenuUI;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class centerCoordinatorMenu implements Initializable {

    Company company;
    @FXML
    private BorderPane borderPane;

    @FXML
    private Button logout;
    @FXML
    private Button submitbtn;

    @FXML
    private Button returnbtn;

    @FXML
    private Stage stage;



    private AuthController authController = new AuthController();

    public void logout(ActionEvent actionEvent) throws IOException {
        authController.doLogout();
        stage = (Stage) logout.getScene().getWindow();
        stage.close();
        Parent login = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("fxml/Login.fxml")));
        Scene scene = new Scene(login);
        Stage stage2 = new Stage();
        stage2.setScene(scene);
        stage2.setResizable(true);
        stage2.show();

    }


    public void Submit(ActionEvent actionEvent) throws IOException {
        Parent exportStatistics = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("fxml/exportStatistics.fxml")));
        Scene scene = new Scene(exportStatistics);
        Stage stage2 = new Stage();
        stage2.setScene(scene);
        stage2.setResizable(true);
        stage = (Stage) submitbtn.getScene().getWindow();
        stage.close();
        stage2.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }
}

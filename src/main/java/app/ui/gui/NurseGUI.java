package app.ui.gui;

import app.controller.AuthController;
import app.controller.vaccinationCenterController.VacCenterController;
import app.domain.model.Company;
import app.domain.model.UserLastVaccineDTO;
import app.domain.model.VacCenter;
import app.ui.console.waitingListUI.WaitingListUI;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class NurseGUI implements Initializable {

    public Button registerVaccAdmin;
    Company company;
    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button logout;

    @FXML
    private Stage stage;

    private AuthController authController = new AuthController();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void btnRegisterAdministration(ActionEvent actionEvent) throws IOException {
        Parent adverseMenu = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("fxml/registerAdministration.fxml")));
        Scene scene = new Scene(adverseMenu);
        Stage stage2 = new Stage();
        stage2.setScene(scene);
        stage2.setResizable(true);
        stage = (Stage) anchorPane.getScene().getWindow();
        stage.close();
        stage2.show();
    }

    public void btnRegisterAdverseReaction(ActionEvent actionEvent) throws IOException {
        Parent adverseMenu = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("fxml/adverseReaction.fxml")));
        Scene scene = new Scene(adverseMenu);
        Stage stage2 = new Stage();
        stage2.setScene(scene);
        stage2.setResizable(true);
        stage = (Stage) anchorPane.getScene().getWindow();
        stage.close();
        stage2.show();
    }

    public void logout(ActionEvent actionEvent) throws IOException {
        authController.doLogout();
        stage = (Stage) anchorPane.getScene().getWindow();
        stage.close();
        Parent login = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("fxml/Login.fxml")));
        Scene scene = new Scene(login);
        Stage stage2 = new Stage();
        stage2.setScene(scene);
        stage2.setResizable(true);
        stage2.show();
    }



}




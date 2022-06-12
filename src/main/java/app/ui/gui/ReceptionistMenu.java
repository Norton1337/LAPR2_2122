package app.ui.gui;

import app.controller.AuthController;
import app.domain.model.Company;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ReceptionistMenu {
    Company company;
    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button logout;

    @FXML
    private Stage stage;

    private AuthController authController = new AuthController();

    public void logout(ActionEvent actionEvent) {
        authController.doLogout();
        stage = (Stage) anchorPane.getScene().getWindow();
        stage.close();
    }
}

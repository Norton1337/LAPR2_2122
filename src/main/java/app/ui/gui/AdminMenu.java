package app.ui.gui;

import app.controller.AuthController;
import app.domain.model.Company;
import app.ui.console.SnsUserUI.loadSnsUserUI;
import app.ui.console.employeeUI.EmployeeUI;
import app.ui.console.vacCenterUI.VacCenterUI;
import app.ui.console.vaccineUI.VaccineUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminMenu implements Initializable {
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
    public void logout(ActionEvent actionEvent) {
        authController.doLogout();
        stage = (Stage) anchorPane.getScene().getWindow();
        stage.close();
    }

    public void registerVaccCenter(ActionEvent actionEvent) {
        VacCenterUI vacCenterUI = new VacCenterUI(company);
        vacCenterUI.run();
    }

    public void registerEmployee(ActionEvent actionEvent) {
        EmployeeUI employeeUI = new EmployeeUI();
        employeeUI.run();
    }

    public void listOfEmployees(ActionEvent actionEvent) {
        EmployeeUI employeeUI = new EmployeeUI();
        employeeUI.run();
    }

    public void SpecifyVaccType(ActionEvent actionEvent) {
        VaccineUI vaccineUI = new VaccineUI(company);
        vaccineUI.run();
    }

    public void specifyVaccine(ActionEvent actionEvent) {
        VaccineUI vaccineUI = new VaccineUI(company);
        vaccineUI.run();
    }

    public void LoadUsers(ActionEvent actionEvent) {
        loadSnsUserUI loadSnsUserUI = new loadSnsUserUI(company);
        loadSnsUserUI.run();
    }


}

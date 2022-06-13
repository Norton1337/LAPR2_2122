package app.ui.gui;

import app.controller.vaccinationCenterController.VacCenterController;
import app.domain.model.Company;
import app.domain.model.VacCenter;
import app.ui.console.MainMenuUI;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class exportStatistics implements Initializable {

    Company company;

    @FXML
    private ComboBox<String> vaccCenterOptions;
    private String vaccCenterOptionsString;
    private List<String> vaccenters;

    @FXML
    private DatePicker firstDate;
    @FXML
    private DatePicker secondDate;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        MainMenuUI menu = new MainMenuUI();
        vaccenters=new ArrayList<>();
        this.company=menu.newBootstrap();
        List<VacCenter> vacCenterList= this.company.getVacCenterList().showAllVacCenters();

        for (VacCenter vacCenter : vacCenterList) {
            vaccenters.add(String.valueOf(vacCenter.getName()));
        }
        vaccCenterOptions.setItems(FXCollections.observableList(vaccenters));
    }

    public void vaccCenterOptions(ActionEvent actionEvent) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        this.vaccCenterOptionsString = vaccCenterOptions.getValue();

    }

    public void Submit(ActionEvent actionEvent) throws FileNotFoundException {
        VacCenterController vacCenterController = new VacCenterController(this.company);
        vacCenterController.exportStatistics(firstDate.getValue(),secondDate.getValue());
        System.out.println(firstDate.getValue());
        System.out.println(secondDate.getValue());
    }
}

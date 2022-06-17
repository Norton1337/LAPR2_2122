package app.ui.gui;

import app.controller.vaccinationCenterController.VacCenterController;
import app.domain.model.Company;
import app.domain.model.FullVaccinationDTO;
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
import javafx.scene.control.DatePicker;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class checkVaccinationStatistics implements Initializable {

    public Button returnbtn;
    public AnchorPane anchorPane;
    Company company;

    @FXML
    private ComboBox<String> vaccCenterOptions;
    private String vaccCenterOptionsString;
    private List<String> vaccenters;
    @FXML
    private Stage stage;
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

    public void Submit(ActionEvent actionEvent) throws IOException {
        VacCenterController vacCenterController = new VacCenterController(this.company);
        List<FullVaccinationDTO> fullyVaccinated = vacCenterController.getFullyVaccinated(firstDate.getValue(),secondDate.getValue());
        FullyVaccinatedData.fullVaccinationDTOS=fullyVaccinated;
        FullyVaccinatedData.localDate1=firstDate.getValue();
        FullyVaccinatedData.localDate2=secondDate.getValue();
        Parent exportStatistics = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("fxml/exportStatistics.fxml")));
        Scene scene = new Scene(exportStatistics);
        Stage stage2 = new Stage();
        stage2.setScene(scene);
        stage2.setResizable(true);
        stage = (Stage) returnbtn.getScene().getWindow();
        stage.close();
        stage2.show();
    }

    public void Return(ActionEvent actionEvent) throws IOException {
        Parent centerCoordinator = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("fxml/centerCoordinator.fxml")));
        Scene scene = new Scene(centerCoordinator);
        Stage stage2 = new Stage();
        stage2.setScene(scene);
        stage2.setResizable(true);
        stage = (Stage) returnbtn.getScene().getWindow();
        stage.close();
        stage2.show();
    }


}

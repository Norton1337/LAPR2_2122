package app.ui.gui;

import app.controller.vaccinationCenterController.VacCenterController;
import app.domain.model.Company;
import app.domain.model.FullVaccinationDTO;
import app.ui.console.MainMenuUI;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class exportStatistics implements Initializable {

    public DatePicker firstDate;
    public DatePicker secondDate;
    public ComboBox vaccCenterOptions;
    Company company;
    public Button returnbtn;
    @FXML public TableView<FullyVaccinated> vaccinationTable;
    @FXML public TableColumn<FullyVaccinated, Integer> snsNumberColumn;
    @FXML public TableColumn<FullyVaccinated, LocalDate> dateColumn;
    public Button submitbtn;
    public AnchorPane anchorPane;

    public Stage stage;

    public List<FullVaccinationDTO> fullyVaccinated;

    public void Submit(ActionEvent actionEvent) throws FileNotFoundException {
        VacCenterController vacCenterController = new VacCenterController(this.company);
       vacCenterController.treatVaccinationData(FullyVaccinatedData.fullVaccinationDTOS,FullyVaccinatedData.localDate1,FullyVaccinatedData.localDate2);
    }

    public void Return(ActionEvent actionEvent) throws IOException {
        Parent centerCoordinator = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("fxml/checkVaccinationStatistics.fxml")));
        Scene scene = new Scene(centerCoordinator);
        Stage stage2 = new Stage();
        stage2.setScene(scene);
        stage2.setResizable(true);
        stage = (Stage) returnbtn.getScene().getWindow();
        stage.close();
        stage2.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        MainMenuUI menu = new MainMenuUI();
        this.company=menu.newBootstrap();

        snsNumberColumn.setCellValueFactory(new PropertyValueFactory<FullyVaccinated, Integer>("snsNumber"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<FullyVaccinated, LocalDate>("dateOfFullVaccination"));

        vaccinationTable.setItems(getFullyVaccinatedList());
    }

    public ObservableList<FullyVaccinated> getFullyVaccinatedList(){
        ObservableList<FullyVaccinated> fullVaccination = FXCollections.observableArrayList();
        for (FullVaccinationDTO fullyVaccinated:FullyVaccinatedData.fullVaccinationDTOS) {
            fullVaccination.add(new FullyVaccinated(Integer.toString(fullyVaccinated.snsNumber),fullyVaccinated.dateOfFullVaccination));
        }
        return fullVaccination;
    }
    public void setupFullyVaccinated(List<FullVaccinationDTO> fullyVaccinated){
        this.fullyVaccinated=fullyVaccinated;
    }

    public void vaccCenterOptions(ActionEvent actionEvent) {
    }
}

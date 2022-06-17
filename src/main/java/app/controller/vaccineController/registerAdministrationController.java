package app.controller.vaccineController;

import app.controller.AuthController;
import app.domain.model.*;
import app.ui.console.MainMenuUI;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class registerAdministrationController implements Initializable {
    @FXML
    public ComboBox vaccenterChoice;
    @FXML
    public ComboBox userOption;
    @FXML
    public ComboBox vaccineOption;
    @FXML
    public ComboBox doseOption;
    Company company= new Company();
    @FXML
    public Label labelInform;

    private final AuthController authController= new AuthController();
    private Stage stage = new Stage();
    @FXML
    public AnchorPane anchorPane;

    List<VacCenter> vacCenterList;
    List<String>Vaccenters = new ArrayList();
    List<AgeGroup> ageGroupList= new ArrayList<>();
    List<String> doseList = new ArrayList<>();
    List<String> vaccineName = new ArrayList<>();
    private String vaccenteroption;
    private String UserPositionOption;
    private String vaccineOptions;
    private String doses;
    List<Vaccine> vaccineList = new ArrayList<>();
    AgeGroup ageGroup;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        MainMenuUI menuUI = new MainMenuUI();
        this.company=menuUI.newBootstrap();
        this.company.getVacCenterList().showAllVacCenters().get(0).checkInSnsUser(
                new UserLastVaccineDTO(1,"Nuno",12, LocalDateTime.now(),null)
        );
        this.vacCenterList=this.company.getVacCenterList().showAllVacCenters();
        vaccineList.add(this.company.listVaccine().get(0));

        for (int i=0;i<vacCenterList.size();i++){
            Vaccenters.add(String.valueOf(vacCenterList.get(i).getName()));
        }
        vaccenterChoice.setItems(FXCollections.observableList(Vaccenters));
    }


    public void vacCenterOption(ActionEvent actionEvent) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        this.vaccenteroption = (String) vaccenterChoice.getValue();

        setItems();
    }

    private void setItems() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        if(!(this.vaccenterChoice ==null)){
            List<String> usersWaiting = new ArrayList<>();
            for(int i = 0; i<vacCenterList.size(); i++){
                if(this.vaccenterChoice.getValue().equals(vacCenterList.get(i).getName())){
                    for(int j=0; j<vacCenterList.get(i).waitingRoom().size();j++){
                        usersWaiting.add(vacCenterList.get(i).waitingRoom().get(j).getName());
                    }
                }
            }
            System.out.println(usersWaiting);
            userOption.setItems(FXCollections.observableList(usersWaiting));
        }
    }

    public void userOption(ActionEvent actionEvent) {
        this.UserPositionOption = (String) userOption.getValue();
        for(int i = 0 ; i< vaccineList.size();i++){
            vaccineName.add(vaccineList.get(i).getName());
        }
        vaccineOption.setItems(FXCollections.observableList(vaccineName));

    }

    public void vaccineOption(ActionEvent actionEvent) {
        this.vaccineOptions = (String) vaccineOption.getValue();
        for(int i = 0; i<vacCenterList.size(); i++){
            if(this.vaccenterChoice.getValue().equals(vacCenterList.get(i).getName())){
                for(int j=0; j<vacCenterList.get(i).waitingRoom().size();j++){
                    if(Objects.equals(this.userOption.getValue(), vacCenterList.get(i).waitingRoom().get(j).getName())){
                        int age= vacCenterList.get(i).waitingRoom().get(j).getAge();
                        ageGroup = getAgeGroup(age);
                        String ageGroupString = Integer.toString(ageGroup.getDose().getDoseNumber());
                        doseList.add(ageGroupString);
                        doseOption.setItems(FXCollections.observableList(doseList));
                    }
                }
            }
        }
    }

    public void doseOption(ActionEvent actionEvent) throws IOException {
        this.doses = (String) doseOption.getValue();
        labelInform.setText("User will be informed in 30 min.");
        authController.doLogout();
        Parent adverseMenu = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("fxml/NurseScene.fxml")));
        Scene scene = new Scene(adverseMenu);
        Stage stage2 = new Stage();
        stage2.setScene(scene);
        stage2.setResizable(true);
        stage = (Stage) anchorPane.getScene().getWindow();
        stage.close();
        stage2.show();
    }
    public void labelInform(MouseEvent mouseEvent) {

    }

    private AgeGroup getAgeGroup(int age){
        for(int i=0; i<vaccineList.size();i++){
            if(Objects.equals(vaccineList.get(i).getName(), vaccineOptions)){
               ageGroupList= vaccineList.get(i).getVaccinationProcess().getAgeGroupList();
                for (int j =0; j< ageGroupList.size();j++){
                    if(ageGroupList.get(i).getMinAge()<= age && ageGroupList.get(i).getMaxAge()>= age){
                        return ageGroupList.get(i);
                    }
                }
            }
        }
        return null;
    }


}

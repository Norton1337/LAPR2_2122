package app.controller.vaccineController;

import app.controller.AuthController;
import app.domain.model.*;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
    final Company company= new Company();
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
        VacCenter vacCenter = new VacCenter(
                "Vacinação Porto",
                "Rua do Porto",
                "912626999",
                "019283746",
                "website@test.com",
                9,
                19,
                12,
                200);

        VacCenter vacCenter2 = new VacCenter(
                "Vacinação Maia",
                "Rua da Maia",
                "915728236",
                "015632856",
                "websiteMaia@test.com",
                9,
                19,
                12,
                200);
        AgeGroup ageGroup1 = new AgeGroup(10,18,new TimeInterval(50));
        ageGroup1.setDose(new Dose(1,250));
        AgeGroup ageGroup2 = new AgeGroup(19,25,new TimeInterval(60));
        ageGroup2.setDose(new Dose(1,250));
        AgeGroup ageGroup3 = new AgeGroup(26,50,new TimeInterval(30));
        ageGroup3.setDose(new Dose(1,250));
        List<AgeGroup> ageGroups = new ArrayList<>();
        VaccinationProcess vaccinationProcess;
        VaccineType vaccineType;
        Vaccine vaccine;
        ageGroups.add(ageGroup1);
        ageGroups.add(ageGroup2);
        ageGroups.add(ageGroup3);
        vaccinationProcess = new VaccinationProcess(30, ageGroups);
        vaccineType = new VaccineType("covid");
        vaccine = new Vaccine("name",123456,vaccineType,vaccinationProcess);
        this.company.createSnsUser(1,"Nuno",12, "122","email");
        vacCenter.checkInSnsUser(new UserLastVaccineDTO(1,"Nuno",12, LocalDateTime.now(),null));
        this.company.createVacCenter(vacCenter);
        this.company.createVacCenter(vacCenter2);
        this.vacCenterList=this.company.getVacCenterList().showAllVacCenters();
        vaccineList.add(vaccine);

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

    public void doseOption(ActionEvent actionEvent) {
         this.doses = (String) doseOption.getValue();
         labelInform.setText("User will be informed in 30 min.");
        authController.doLogout();
        stage = (Stage) anchorPane.getScene().getWindow();
        stage.close();
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

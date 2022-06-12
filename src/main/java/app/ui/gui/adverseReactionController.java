package app.ui.gui;

import app.controller.AuthController;
import app.controller.vaccinationCenterController.VacCenterController;
import app.domain.model.*;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class adverseReactionController implements Initializable {
    public TextField SymptomDescription;
    public Button submitbtn;

    String description;

    VacCenterController vacCenterController;
    Company company = new Company();
    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button logout;

    @FXML
    private Stage stage;

    @FXML
    private ComboBox<String> UserPosOptions;
    @FXML
    private ComboBox<String> vaccCenterOptions;


    @FXML
    private TableView waitingRoom;

    private AuthController authController = new AuthController();

    private String VaccCenterOptions;
    private String UserPositionOption;
    List<VacCenter> vacCenterList;
    List<UserLastVaccineDTO> newList;
    List<String>Vaccenters = new ArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //final Company company = this.company;
        //vacCenterList = (List<VacCenter>) this.company.getVacCenterList();
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
        AgeGroup ageGroup2 = new AgeGroup(19,25,new TimeInterval(60));
        AgeGroup ageGroup3 = new AgeGroup(26,50,new TimeInterval(30));
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

        for (int i=0;i<vacCenterList.size();i++){
            Vaccenters.add(String.valueOf(vacCenterList.get(i).getName()));
        }
        vaccCenterOptions.setItems(FXCollections.observableList(Vaccenters));
    }


    public void vaccCenterOptions(ActionEvent actionEvent) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        this.VaccCenterOptions = vaccCenterOptions.getValue();

        setItems();
    }

    private void setItems() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        if(!(this.vaccCenterOptions ==null)){
            List<String> usersWaiting = new ArrayList<>();
            for(int i = 0; i<vacCenterList.size(); i++){
                if(this.vaccCenterOptions.getValue().equals(vacCenterList.get(i).getName())){
                    for(int j=0; j<vacCenterList.get(i).waitingRoom().size();j++){
                        usersWaiting.add(vacCenterList.get(i).waitingRoom().get(j).getName());
                    }
                }
            }
            System.out.println(usersWaiting);
            UserPosOptions.setItems(FXCollections.observableList(usersWaiting));
        }
    }

    public void waitingRoom(SortEvent<TableView> tableViewSortEvent) {
        List<String> positions =new ArrayList();
        for(int i =0; i<newList.size();i++){
            String position=String.valueOf(newList.get(i));
            positions.add(position);
        }
        UserPosOptions.setItems(FXCollections.observableList(positions));
    }


    public void UserPosOptions(ActionEvent actionEvent) {
        this.UserPositionOption = UserPosOptions.getValue();
    }


    public void Submit(ActionEvent actionEvent) {
        description = SymptomDescription.getText();
        for(int i = 0; i<vacCenterList.size(); i++){
            if(this.vaccCenterOptions.getValue().equals(vacCenterList.get(i).getName())){
                for(int j=0; j<vacCenterList.get(i).waitingRoom().size();j++){
                   if(Objects.equals(this.UserPosOptions.getValue(), vacCenterList.get(i).waitingRoom().get(j).getName())){
                       vacCenterList.get(i).checkOutSnsUser(vacCenterList.get(i).waitingRoom().get(j));
                   }
                }
                }
            }
        authController.doLogout();
        stage = (Stage) anchorPane.getScene().getWindow();
        stage.close();
    }
}

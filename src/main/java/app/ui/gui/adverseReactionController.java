package app.ui.gui;

import app.controller.AuthController;
import app.controller.vaccinationCenterController.VacCenterController;
import app.domain.model.*;
import app.ui.console.MainMenuUI;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
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

    private final AuthController authController = new AuthController();

    private String VaccCenterOptions;
    private String UserPositionOption;
    List<VacCenter> vacCenterList;
    List<UserLastVaccineDTO> newList;
    List<String>Vaccenters = new ArrayList<>();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        MainMenuUI menuUI = new MainMenuUI();
        this.company=menuUI.newBootstrap();
        this.company.getVacCenterList().showAllVacCenters().get(0).checkInSnsUser(
                new UserLastVaccineDTO(1,"Nuno",12, LocalDateTime.now(),null)
        );

        this.vacCenterList=this.company.getVacCenterList().showAllVacCenters();

        for (VacCenter vacCenter : vacCenterList) {
            Vaccenters.add(String.valueOf(vacCenter.getName()));
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
            for (VacCenter vacCenter : vacCenterList) {
                if (this.vaccCenterOptions.getValue().equals(vacCenter.getName())) {
                    for (int j = 0; j < vacCenter.waitingRoom().size(); j++) {
                        usersWaiting.add(vacCenter.waitingRoom().get(j).getName());
                    }
                }
            }
            System.out.println(usersWaiting);
            UserPosOptions.setItems(FXCollections.observableList(usersWaiting));
        }
    }

    public void waitingRoom(SortEvent<TableView> tableViewSortEvent) {
        List<String> positions =new ArrayList<>();
        for (UserLastVaccineDTO userLastVaccineDTO : newList) {
            String position = String.valueOf(userLastVaccineDTO);
            positions.add(position);
        }
        UserPosOptions.setItems(FXCollections.observableList(positions));
    }


    public void UserPosOptions(ActionEvent actionEvent) {
        this.UserPositionOption = UserPosOptions.getValue();
    }


    public void Submit(ActionEvent actionEvent) throws IOException {
        description = SymptomDescription.getText();
        for (VacCenter vacCenter : vacCenterList) {
            if (this.vaccCenterOptions.getValue().equals(vacCenter.getName())) {
                for (int j = 0; j < vacCenter.waitingRoom().size(); j++) {
                    if (Objects.equals(this.UserPosOptions.getValue(), vacCenter.waitingRoom().get(j).getName())) {
                        vacCenter.checkOutSnsUser(vacCenter.waitingRoom().get(j));
                    }
                }
            }
        }
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
}

package app.ui.gui;


import app.controller.AuthController;
import app.ui.console.utils.Utils;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import pt.isep.lei.esoft.auth.mappers.dto.UserRoleDTO;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class LoginGUI implements Initializable {
    @FXML
    private Button knowTeam;

    @FXML
    private BorderPane borderPane;

    @FXML
    private Button loginButton;

    @FXML
    private Button cancelButton;

    @FXML
    private TextField email;

    @FXML
    private TextField password;

    @FXML
    private Label message;

    Stage stage;

    private AuthController authController = new AuthController();

    public void loginButton(ActionEvent event) throws IOException {
        int maxAttempts = 3;
        boolean success = false;
        do
        {
            success = authController.doLogin(email.getText(), password.getText());
            if (!success)
            {
                maxAttempts--;
                System.out.println("Invalid UserId and/or Password. \n You have  " + maxAttempts + " more attempt(s).");
                message.setText("Invalid UserId and/or Password. \n You have  " + maxAttempts + " more attempt(s).");
            }
        } while (!success && maxAttempts > 0);
        if (success) {
            List<UserRoleDTO> roles = this.authController.getUserRoles();
            UserRoleDTO role = selectsRole(roles);
            if(role.getDescription().equalsIgnoreCase("Main Administrator")){
                Parent adminMenu = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("AdminMenu.fxml")));
                createStage(adminMenu);
            }
            else if(role.getDescription().equalsIgnoreCase("User SNS")){
                Parent clientMenu = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("fxml/SnsMenuScene.fxml")));
                createStage(clientMenu);
            }
            else if(role.getDescription().equalsIgnoreCase("Nurse")){
                Parent clientMenu = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("fxml/NurseScene.fxml")));
                createStage(clientMenu);
            }
            else if(role.getDescription().equalsIgnoreCase("Receptionist")){
                Parent receptionistMenu = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/ReceptionistMenu.fxml"));
                createStage(receptionistMenu);
            }
            else if(role.getDescription().equalsIgnoreCase("Center Coordinator")){
                Parent lcMenu = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("fxml/centerCoordinator.fxml")));
                createStage(lcMenu);
            }
        }
    }

    public void createStage(Parent menu){
        Stage stage2 = new Stage();
        Scene scene2 = new Scene(menu);
        stage2.initStyle(StageStyle.UNDECORATED);
        stage2.setScene(scene2);
        stage2.setResizable(true);
        stage2.show();
        stage = (Stage) borderPane.getScene().getWindow();
        stage.close();
    }

    public void closeButton(ActionEvent event){
        stage = (Stage) borderPane.getScene().getWindow();
        stage.close();
    }

    public void knowTeam(ActionEvent event) throws IOException {
        Parent devTeamMenu = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("fxml/DevTeamScene.fxml")));
        createStage(devTeamMenu);
    }

    private UserRoleDTO selectsRole(List<UserRoleDTO> roles)
    {
        if (roles.size() == 1)
            return roles.get(0);
        else
            return (UserRoleDTO) Utils.showAndSelectOne(roles, "Select the role you want to adopt in this session:");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
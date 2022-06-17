package app.controller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Timer;

import app.controller.numberOfPeopleVaccinatedController.numberOfPeopleVaccinatedController;
import app.domain.model.Company;
import app.domain.model.VacCenter;
import app.domain.shared.Constants;
import pt.isep.lei.esoft.auth.AuthFacade;
import pt.isep.lei.esoft.auth.UserSession;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Properties;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class App {

    private Timer randomTimer;
    private Company company;
    private AuthFacade authFacade;

    private App()
    {
        Properties props = getProperties();
        this.company = new Company(props.getProperty(Constants.PARAMS_COMPANY_DESIGNATION));
        this.authFacade = this.company.getAuthFacade();
        bootstrap();
        props.setProperty("Timer.time","20");
        try{
            FileReader reader = new FileReader("src/main/resources/config/config.properties");
            props.load(reader);
            randomTimer = new Timer();
            //Get config time
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY,Integer.parseInt(props.getProperty("Timer.time")));
            //    randomTimer.scheduleAtFixedRate(new numberOfPeopleVaccinatedController(),calendar.getTime(),24*60*60*1000L);
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    public Company getCompany()
    {
        return this.company;
    }


    public UserSession getCurrentUserSession()
    {
        return this.authFacade.getCurrentUserSession();
    }

    public boolean doLogin(String email, String pwd)
    {
        return this.authFacade.doLogin(email,pwd).isLoggedIn();
    }

    public void doLogout()
    {
        this.authFacade.doLogout();
    }

    private Properties getProperties()
    {
        Properties props = new Properties();

        // Add default properties and values
        props.setProperty(Constants.PARAMS_COMPANY_DESIGNATION, "DGS/SNS");


        // Read configured values
        try
        {
            InputStream in = new FileInputStream(Constants.PARAMS_FILENAME);
            props.load(in);
            in.close();
        }
        catch(IOException ex)
        {

        }
        return props;
    }


    private void bootstrap()
    {
        this.authFacade.addUserRole(Constants.ROLE_ADMIN,Constants.ROLE_ADMIN);
        this.authFacade.addUserRole(Constants.ROLE_RECEPTIONIST,Constants.ROLE_RECEPTIONIST);
        this.authFacade.addUserRole(Constants.ROLE_CCOORDINATOR,Constants.ROLE_CCOORDINATOR);
        this.authFacade.addUserRole(Constants.ROLE_NURSE, Constants.ROLE_NURSE);
        this.authFacade.addUserRole(Constants.USER_SNS, Constants.USER_SNS);
        this.authFacade.addUserWithRole("Main Administrator", "admin@lei.sem2.pt", "123456",Constants.ROLE_ADMIN);
        this.authFacade.addUserWithRole("Receptionist","receptionist@lei.sem2.pt","12345",Constants.ROLE_RECEPTIONIST);
        this.authFacade.addUserWithRole("Nurse", "nurse@lei.sem2.pt", "12345", Constants.ROLE_NURSE);
        this.authFacade.addUserWithRole("Center Coordinator","coordinator@lei.sem2.pt","12345",Constants.ROLE_CCOORDINATOR);
        this.authFacade.addUserWithRole("User SNS","user@lei.sem2.pt","12345",Constants.USER_SNS);

    }


    // Extracted from https://www.javaworld.com/article/2073352/core-java/core-java-simply-singleton.html?page=2
    private static App singleton = null;
    public static App getInstance()
    {
        if(singleton == null)
        {
            synchronized(App.class)
            {
                singleton = new App();
            }
        }
        return singleton;
    }

}

package app.ui.console;

import app.domain.model.*;
import app.ui.console.SnsUserUI.RegisterSNSUserUI;
import app.ui.console.utils.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class MainMenuUI {

    Company company;
    public MainMenuUI()
    {
        company=newBootstrap();

    }

    public void run() throws IOException
    {
        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("Do Login", new AuthUI(this.company)));
        options.add(new MenuItem("Know the Development Team",new DevTeamUI()));
        int option = 0;
        do
        {
            option = Utils.showAndSelectIndex(options, "\n\nMain Menu");

            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }
        }
        while (option != -1 );
    }

    public Company newBootstrap(){
        Company newComp = new Company();
        createVacCenters(newComp);
        createVaccine(newComp);
        createSnsUsers(newComp);





        return newComp;
    }

    private void createVaccine(Company company) {
        AgeGroup ageGroup1 = new AgeGroup(10,18,new TimeInterval(50));
        AgeGroup ageGroup2 = new AgeGroup(19,25,new TimeInterval(60));
        AgeGroup ageGroup3 = new AgeGroup(26,50,new TimeInterval(30));
        List<AgeGroup> ageGroups = new ArrayList<>();
        VaccinationProcess vaccinationProcess;
        VaccineType vaccineType;
        Vaccine vaccine;
        ageGroup1.setDose(new Dose(1,120));
        ageGroups.add(ageGroup1);
        ageGroup2.setDose(new Dose(1,120));
        ageGroups.add(ageGroup2);
        ageGroup3.setDose(new Dose(1,120));
        ageGroups.add(ageGroup3);
        vaccinationProcess = new VaccinationProcess(30, ageGroups);
        vaccineType = new VaccineType("covid");
        company.createVaccine("astra",123456,vaccineType,vaccinationProcess);
    }

    private void createSnsUsers(Company company) {
        company.createSnsUser(1231,"Nome1",20,"912345678","email@email.com");
        company.createSnsUser(1232,"Nome2",20,"912345678","email@email.com");
        company.createSnsUser(1233,"Nome3",20,"912345678","email@email.com");
        company.createSnsUser(1234,"Nome4",20,"912345678","email@email.com");
        company.createSnsUser(1235,"Nome5",20,"912345678","email@email.com");
        company.createSnsUser(1236,"Nome6",20,"912345678","email@email.com");


        company.listSnsUser().get(0).getUserVaccines().addVaccine(new UserVaccinesDTO(company.listVaccine().get(0),20));


    }

    private void createVacCenters(Company company){
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

        company.createVacCenter(vacCenter);
        company.createVacCenter(vacCenter2);
    }

}

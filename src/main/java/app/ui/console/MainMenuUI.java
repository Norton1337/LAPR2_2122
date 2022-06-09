package app.ui.console;

import app.domain.model.Company;
import app.domain.model.VacCenter;
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
        company=new Company();
        createVacCenters();
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

    private void createVacCenters(){

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

        this.company.createVacCenter(vacCenter);
        this.company.createVacCenter(vacCenter2);

    }


}

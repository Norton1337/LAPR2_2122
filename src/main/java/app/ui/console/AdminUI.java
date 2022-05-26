package app.ui.console;

import app.domain.model.Company;
import app.ui.console.SnsUserUI.loadSnsUserUI;
import app.ui.console.employeeUI.EmployeeUI;
import app.ui.console.utils.Utils;
import app.ui.console.vacCenterUI.VacCenterUI;
import app.ui.console.vaccineUI.VaccineUI;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */

public class AdminUI implements Runnable{

    Company company;

    public AdminUI(Company company)
    {
        this.company=company;
    }

    public void run()
    {
        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("Vaccine Type UI", new VaccineUI(company)));
        options.add(new MenuItem("Vaccination Center ", new VacCenterUI(company)));
        options.add(new MenuItem("Load users from CSV file ", new loadSnsUserUI(company)));
        options.add(new MenuItem("Employees", new EmployeeUI()));

        int option = 0;
        do
        {
            option = Utils.showAndSelectIndex(options, "\n\nAdmin Menu:");

            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }
        }
        while (option != -1 );
    }
}

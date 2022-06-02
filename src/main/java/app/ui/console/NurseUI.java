package app.ui.console;

import app.domain.model.Company;
import app.ui.console.utils.Utils;
import app.ui.console.waitingListUI.WaitingListUI;

import java.util.ArrayList;
import java.util.List;

public class NurseUI implements Runnable {

    Company company;

    public NurseUI(Company company)
    {
        this.company=company;
    }

    public void run()
    {
        List<MenuItem> options = new ArrayList<MenuItem>();

        options.add(new MenuItem("Consult centers waiting list ", new WaitingListUI(company)));

        int option = 0;
        do
        {
            option = Utils.showAndSelectIndex(options, "\n\nNurse Menu:");

            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }
        }
        while (option != -1 );
    }
}

package app.ui.console.vacCenterUI;

import app.controller.vaccinationCenterController.VacCenterController;

import app.domain.model.Company;
import app.domain.model.VacCenter;
import app.ui.console.utils.Utils;

import java.util.List;

public class VacCenterUI implements Runnable {

    private static final String SEPARATOR_LABEL = "-------------------------------------------------------------";

    VacCenterController vcController;
    Company company;


    public VacCenterUI(Company company) {
        this.company=company;
        this.vcController = new VacCenterController(company);
    }

    @Override
    public void run() {

        System.out.println("\n\nVaccination Center UI\n\n");
        System.out.println("1-Register new Vaccination Center");
        System.out.println("2-List all Vaccination Centers");
        System.out.println("0-Cancel");

        int option = Utils.readIntegerFromConsole("Choose an option please: ");
        switch (option) {
            case 1:
                System.out.println(SEPARATOR_LABEL);
                System.out.println(" Type the following information about new Vaccination Center ");
                System.out.println(SEPARATOR_LABEL);
                String name = Utils.readLineFromConsole("Name: ");
                String address = Utils.readLineFromConsole("Address: ");
                String phoneNumber = Utils.readLineFromConsole("Phone Number: ");
                String faxNumber = Utils.readLineFromConsole("Fax: ");
                String website = Utils.readLineFromConsole("Website: ");
                int openingHour = Utils.readIntegerFromConsole("Opening hour: ");
                int closingHour = Utils.readIntegerFromConsole("Closing Hour: ");
                int slotDuration = Utils.readIntegerFromConsole("Slot Duration: ");
                int maxVaccines = Utils.readIntegerFromConsole("Max. Vaccines: ");
                VacCenter vcc = vcController.registerVC(name, address, phoneNumber, faxNumber, website, openingHour, closingHour, slotDuration, maxVaccines);
                System.out.println("\nVaccination Center registered successfully\n");
                vcController.printerVCC(vcc);
                option = 0;
                break;
            case 2:
                List<VacCenter> list = vcController.listVacCenters();
                if(list.isEmpty()){
                    System.out.println("No data. Needs to insert a new vaccination Center.");

                    option=0;
                    break;
                }
                System.out.println(SEPARATOR_LABEL);
                System.out.println("                List of Vaccination Centers ");
                System.out.println(SEPARATOR_LABEL);

                for (VacCenter vacCenter : list) {
                    vcController.printerVCC(vacCenter);
                }
                option = 0;
                break;
            default:
                System.out.println("Invalid option, choose again.");
                break;
        }

    }
}

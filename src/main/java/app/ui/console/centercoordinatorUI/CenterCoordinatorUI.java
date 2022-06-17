package app.ui.console.centercoordinatorUI;

import app.controller.vaccinationCenterController.VacCenterController;
import app.controller.vaccineController.VaccineController;
import app.domain.model.*;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class CenterCoordinatorUI implements Runnable{
    Company company;
    VacCenterController vacCenterController;

    public CenterCoordinatorUI(Company company) {
        this.company = company;
        this.vacCenterController = new VacCenterController(company);
    }

    @Override
    public void run() {

        Scanner inInt = new Scanner(System.in);
        System.out.println("1-Get list of Vaccines");
        System.out.println("2-Choose Vac Center");
        System.out.println("0-Cancel");
        int option = inInt.nextInt();
        switch (option){
            case 1:
                List<Vaccine> vaccineList;
                List<Vaccine> vaccineList2;
                VaccineController vaccineController = new VaccineController(company);
                vaccineList= vaccineController.getVaccineListOrdered();
                vaccineList2=vaccineController.getVaccineListOrderedByType(vaccineList);
                vaccineController.printList(vaccineList2);
                break;
            case 2:
                List<VacCenter> list = vacCenterController.listVacCenters();
                if(list.isEmpty()){
                    System.out.println("No Vaccine centers exist. Inform your administrator to create a new vaccination Center.");
                    option=0;
                    break;
                }

                System.out.println("List of Vaccination Centers:\n");

                int i=0;
                for (VacCenter vacCenter : list) {
                    System.out.println("["+i+"] "+ vacCenter.getName());
                    i++;
                }
                System.out.println("Choose Vaccine Center");
                int option2 = inInt.nextInt();
                if(option2<0 || option2 > list.size()){
                    System.out.println("Vaccine Center doesn't exist.");
                    option=0;
                    break;
                }else{
                    try {
                        chosenVacCenter(list.get(option2));
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }
            case 0: break;
            default:
                System.out.println("Invalid Option");
                run();
        }
    }

    private void chosenVacCenter(VacCenter vacCenter) throws FileNotFoundException {
        String vacCenterName = vacCenter.getName();
        Scanner inInt = new Scanner(System.in);
        System.out.println("\n\n "+vacCenterName+" UI\n\n");
        System.out.println("1-Check Vaccination Statistics");
        System.out.println("0-Cancel");
        int answer = inInt.nextInt();

        switch(answer) {
            case 1:
                exportVacStat(vacCenter);
                break;
            case 0: break;
        }

    }

    private void exportVacStat(VacCenter vacCenter) throws FileNotFoundException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        System.out.println("Choose time interval. Format(dd/MM/yyyy)\n First date:");
        Scanner inString = new Scanner(System.in);
        String date = inString.nextLine();
        LocalDate localDate = LocalDate.parse(date, formatter);

        System.out.println("Second Date:");
        String date2 = inString.nextLine();
        LocalDate localDate2 = LocalDate.parse(date2, formatter);

        List<FullVaccinationDTO> fullyVaccinatedList = vacCenterController.getFullyVaccinated(localDate,localDate2);
        for (FullVaccinationDTO fullyVaccinated:fullyVaccinatedList) {
            System.out.println(fullyVaccinated.snsNumber + " fully vaccinated on " + fullyVaccinated.dateOfFullVaccination);
        }
        Scanner inInt = new Scanner(System.in);
        System.out.println("Do you want to export this data?\n1-Yes\n0-No");
        int answer = inInt.nextInt();

        switch(answer) {
            case 1:
                vacCenterController.treatVaccinationData(fullyVaccinatedList,localDate,localDate2);
                break;
            case 0: break;
        }
    }

}

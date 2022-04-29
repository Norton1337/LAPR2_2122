package app.ui.console.vaccineUI;

import app.controller.vaccineController.VaccineController;
import app.domain.model.AgeGroup;
import app.domain.model.Dose;
import app.domain.model.VaccinationProcess;
import app.domain.model.VaccineType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VaccineUI implements Runnable{
    VaccineController vaccineController;
    public VaccineUI(){
        this.vaccineController = new VaccineController();
    }

    public VaccineUI(VaccineController vaccineController){
        this.vaccineController = vaccineController;
    }

    @Override
    public void run() {


        Scanner inInt = new Scanner(System.in);
        Scanner inString = new Scanner(System.in);
        System.out.println("\n\nVaccine UI\n\n");
        System.out.println("1-Create new Vaccine Type");
        System.out.println("2-List Vaccine Types");
        System.out.println("3-Create Vaccine");
        System.out.println("0-Cancel");

        int option = inInt.nextInt();
        switch(option) {
            case 1:
                System.out.println("Whats the disease name?");
                String disease = inString.nextLine();
                VaccineType vaccineType = vaccineController.registerVaccineType(disease);
                System.out.println(vaccineType);
                System.out.println("Vaccine Type registered succesfully");
                option = 0;
                break;
            case 2:
                List<VaccineType> vaccineTypeList = vaccineController.listVaccineTypes();
                System.out.println("All vaccine types: ");
                for (VaccineType aVaccineType: vaccineTypeList) {
                    System.out.println(aVaccineType);
                }
                option=0;
                break;
            case 3:
                List<VaccineType> vaccineTypeList2 = vaccineController.listVaccineTypes();
                if(vaccineTypeList2.isEmpty()){
                    System.out.println("Cannot create Vaccine, no vaccine types exits");
                    option=0;
                    break;
                }
                System.out.println("Whats the Vaccine name?");
                String name = inString.nextLine();
                System.out.println("Whats the Vaccine lotNumber?");
                int lotNumber = inInt.nextInt();

                System.out.println("Vaccine types:");
                int i = 0;
                for(VaccineType vaccinetype2: vaccineTypeList2){
                    System.out.println((i++) +""+vaccinetype2.getDisease());
                }
                System.out.println("\nChoose vaccine type:");
                int option2 = inInt.nextInt();
                if(option2<0 || option2 > vaccineTypeList2.size()){
                    System.out.println("Vaccine type doesn't exist.");
                    option2=0;
                    break;
                }
                System.out.println("How many age groups?");
                int option3 = inInt.nextInt();
                List<AgeGroup> ageGroupList = new ArrayList<>();
                for (int j = 0; j < option3; j++) {


                    int recoveryPeriod = inInt.nextInt();
                    System.out.println("What min age?");
                    int minAge = inInt.nextInt();
                    System.out.println("What max age?");
                    int maxAge = inInt.nextInt();
                    System.out.println("How many days between doses?");
                    int numDaysInterval = inInt.nextInt();

                    vaccineController.createAgeGroup(minAge,maxAge,numDaysInterval);

                }
                System.out.println("What recovery period?");
                int recoveryPeriod = inInt.nextInt();
                VaccinationProcess vaccinationProcess= vaccineController.createVaccinationProcess(recoveryPeriod, ageGroupList);

                vaccineController.createVaccine(name,lotNumber,vaccineTypeList2.get(option2),vaccinationProcess);

                break;

        }while (option!=0);
    }
}

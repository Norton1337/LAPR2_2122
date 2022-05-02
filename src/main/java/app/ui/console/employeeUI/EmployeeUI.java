package app.ui.console.employeeUI;

import app.controller.employeeController.EmployeeController;
import app.domain.model.Employee;
import app.domain.model.EmployeeRole;
import app.domain.model.SnsUser;

import java.util.List;
import java.util.Scanner;

public class EmployeeUI implements Runnable {

    EmployeeController employeeController;

    public EmployeeUI(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }

    public void run(){

        Scanner inInt = new Scanner(System.in);
        Scanner inString = new Scanner(System.in);
        System.out.println("\n\nEmployee UI\n\n");
        System.out.println("1-Register new Employee");
        System.out.println("2-List all Employees");
        System.out.println("3-List Employees with specific function");
        System.out.println("0-Cancel");

        int option = inInt.nextInt();
        switch (option){

            case 1:
                System.out.println("Type the following information about new Employee.\n");
                System.out.println("Name:");
                String name = inString.nextLine();
                System.out.println("Address: ");
                String address = inString.nextLine();
                System.out.println("Phone Number: ");
                String phoneNumber = inString.nextLine();
                System.out.println("Email: ");
                String email = inString.nextLine();
                System.out.println("Salary: ");
                int salary = inInt.nextInt();
                System.out.println("Role:");
                String role = inString.nextLine();
                EmployeeRole employeeRole = new EmployeeRole(role);

                Employee employee = new Employee(employeeRole, name, address, phoneNumber, email, salary);
                if (employeeController.checkIfEmployeeExists(employee)){
                    System.out.println("Employee already registered in the system");
                }
                else {

                    Employee newEmployee = employeeController.registerEmployee(employeeRole, name, address, phoneNumber,
                            email, salary);
                    System.out.println(newEmployee);
                    System.out.println("Employee registered successfully");
                }
                option = 0;
                break;
            case 2:
                System.out.println("Listing all employees.. \n");

                for (Employee employees : employeeController.listAllEmployees()){

                    System.out.println(employees.getName() +" - "+ employees.getEmployeeRole());
                }
                option = 0;
                break;

            case 3:
                System.out.println("Type role to search employees");
                String empRole = inString.nextLine();
                EmployeeRole er = new EmployeeRole(empRole);

                List<Employee> employeesList = employeeController.listEmployeesWithSpecificRole(er);

                if (!employeesList.isEmpty()){
                    System.out.println("Employees with the following function: "+ er);
                    for (Employee employees : employeesList){
                        System.out.println(employees.getName());
                    }
                }
                else {
                    System.out.println("No employees with such function registered");
                }

                option = 0;
                break;

        }while (option!=0);
    }
}

package app.controller.employeeController;

import app.domain.model.Company;
import app.domain.model.Employee;
import app.domain.model.EmployeeRole;

import java.util.List;


public class EmployeeController {

    private final Company company;

    public EmployeeController(Company company) {
        this.company = company;
    }

    public Employee registerEmployee(EmployeeRole role, String name, String address, String phoneNumber, String email,
                                     int salary){

        return company.createEmployee(role, name, address, phoneNumber, email, salary);
    }

    public List<Employee> listAllEmployees(){

        return company.showAllEmployees();
    }

    public List<Employee> listEmployeesWithSpecificRole(EmployeeRole employeeRole){

        return company.showEmployeeWithSpecificRole(employeeRole);
    }

    public boolean checkIfEmployeeExists(Employee employee){

        return company.checkEmployee(employee);
    }
}

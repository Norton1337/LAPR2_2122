package app.domain.model;

import pt.isep.lei.esoft.auth.AuthFacade;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Company {

    private String designation;
    private AuthFacade authFacade;
    private List<VaccineType> vaccineTypeList;
    private List<Vaccine> vaccineList;
    private List<Employee> employeesList;
    //private List<Employee> employeesWithSpecificRoleList;


    public Company(String designation)
    {
        if (StringUtils.isBlank(designation))
            throw new IllegalArgumentException("Designation cannot be blank.");

        this.designation = designation;
        this.authFacade = new AuthFacade();
    }

    public Company() {
        vaccineTypeList = new ArrayList<>();

    }

    public String getDesignation() {
        return designation;
    }

    public AuthFacade getAuthFacade() {
        return authFacade;
    }


    public SnsUser createsnsUser(int snsNumber, String name, int age, int phoneNumber, String email) {
        SnsUser snsUser = new SnsUser(snsNumber, name, age, phoneNumber, email);
        return snsUser;
    }

    public VaccineType createVaccineType(String disease) {
        VaccineType vaccineType = new VaccineType(disease);
        this.vaccineTypeList.add(vaccineType);
        return vaccineType;
    }
    public List<VaccineType> listVaccineTypes() {
        return this.vaccineTypeList;
    }
    public Vaccine createVaccine(String name, int lotNumber,VaccineType vaccineType,VaccinationProcess vaccinationProcess) {
        Vaccine vaccine = new Vaccine(name,lotNumber,vaccineType,vaccinationProcess);
        this.vaccineList.add(vaccine);
        return vaccine;
    }
    public List<Vaccine> listVaccine() {
        return this.vaccineList;
    }

    public VaccinationProcess createVaccinationProcess(int recoveryPeriod, List<AgeGroup> ageGroupList){
        return new VaccinationProcess(recoveryPeriod, ageGroupList);
    }

    public AgeGroup createAgeGroup(int minAge, int maxAge, int numDaysInterval){
        return new AgeGroup(minAge,maxAge,new TimeInterval(numDaysInterval));
    }

    public Employee createEmployee(EmployeeRole role, String name, String address, String phoneNumber, String email,
                                   int salary){
        Employee employee = new Employee(role, name, address, phoneNumber, email, salary);
        employeesList.add(employee);
        return employee;
    }

    public List<Employee> showAllEmployees(){
        return this.employeesList;
    }

    public List<Employee> showEmployeeWithSpecificRole(EmployeeRole employeeRole){

        String role = employeeRole.getRole().toLowerCase();
        List<Employee> employeesWithSpecificRoleList = new ArrayList<>();

        for(Employee employee : employeesList){

            String checkRole = employee.getEmployeeRole().getRole().toLowerCase();

            if (checkRole.equals(role)){
                employeesWithSpecificRoleList.add(employee);
            }
        }
        return employeesWithSpecificRoleList;
    }

    public boolean checkEmployee(Employee employee){

        return employeesList.contains(employee);
    }

}

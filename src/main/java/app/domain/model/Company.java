package app.domain.model;

import jdk.jfr.Enabled;
import pt.isep.lei.esoft.auth.AuthFacade;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Company {

    private String designation;
    private AuthFacade authFacade;
    private final List<VaccineType> vaccineTypeList;
    private final List<Vaccine> vaccineList;
    private final List<Employee> employeesList;
    private final VacCenterList vacCenterList;
    private final SnsUserList snsUserList;
    //private List<Employee> employeesWithSpecificRoleList;


    public Company(String designation)
    {
        if (StringUtils.isBlank(designation))
            throw new IllegalArgumentException("Designation cannot be blank.");

        this.designation = designation;
        this.authFacade = new AuthFacade();
        this.vaccineTypeList = new ArrayList<>();
        this.vaccineList = new ArrayList<>();
        this.employeesList = new ArrayList<>();
        this.vacCenterList = new VacCenterList();
        this.snsUserList = new SnsUserList();
    }

    public Company() {
        this.vaccineTypeList = new ArrayList<>();
        this.vaccineList = new ArrayList<>();
        this.employeesList = new ArrayList<>();
        this.vacCenterList = new VacCenterList();
        this.snsUserList = new SnsUserList();
    }

    public String getDesignation() {
        return designation;
    }

    public AuthFacade getAuthFacade() {
        return authFacade;
    }

    public SnsUser getUserBySNSNumber(int snsNumber){
        return this.snsUserList.getUserBySNSNumber(snsNumber);
    }

    public SnsUser createSnsUser(int snsNumber, String name, int age, String phoneNumber, String email) {
        return this.snsUserList.createSnsUser(snsNumber,name,age,phoneNumber,email);
    }
    public List<SnsUser> listSnsUser() {
        return this.snsUserList.listSnsUser();
    }

    public VacCenterList getVacCenterList() {
        return vacCenterList;
    }

    public UserLastVaccineDTO createDTO(int snsNumber){
        SnsUser aSnsUser = getUserBySNSNumber(snsNumber);
        if(aSnsUser==null){
            return null;
        }
        LocalDateTime lastVaccineDate = aSnsUser.getUserVaccines().lastVaccineDate();
        Vaccine lastVaccine = aSnsUser.getUserVaccines().lastVaccine();
        return new UserLastVaccineDTO(aSnsUser.getSnsNumber(),aSnsUser.getName(),aSnsUser.getAge(),lastVaccineDate,lastVaccine);
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

        for (Employee employee1 : employeesList){
            if (employee1.equals(employee)){
                return true;
            }
        }
        return false;
    }


}

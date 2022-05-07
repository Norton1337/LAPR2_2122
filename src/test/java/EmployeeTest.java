import app.controller.employeeController.EmployeeController;
import app.domain.model.Company;
import app.domain.model.Employee;
import app.domain.model.EmployeeRole;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {

    EmployeeController employeeController = new EmployeeController(new Company());

    EmployeeRole employeeRole = new EmployeeRole("Admin vacinas");
    Employee emp = employeeController.registerEmployee(employeeRole, "Ana", "gaia", "123", "ana@isep", 200);

    @Test
    public void createEmployeeTest(){
        assertTrue(employeeController.checkIfEmployeeExists(emp));
    }

    @Test
    public void getRoleTest(){
        assertEquals(emp.getEmployeeRole().getRole(), "Admin vacinas");
    }

    @Test
    public void setRoleTest(){
        EmployeeRole employeeRole = new EmployeeRole("Enfermeiro");
        emp.setEmployeeRole(employeeRole);
        assertEquals(employeeRole.getRole(), "Enfermeiro");
    }

    @Test
    public void getNameTest(){
        assertEquals(emp.getName(), "Ana");
    }

    @Test
    public void setNameTest(){
        emp.setName("Isabel");
        assertEquals(emp.getName(), "Isabel");
    }

    @Test
    public void getAddressTest(){
        assertEquals(emp.getAddress(), "gaia");
    }

    @Test
    public void setAddressTest(){
        emp.setAddress("porto");
        assertEquals(emp.getAddress(), "porto");
    }

    @Test
    public void getPhoneNumberTest(){
        assertEquals(emp.getPhoneNumber(), "123");
    }

    @Test
    public void setPhoneNumberTest(){
        emp.setPhoneNumber("456");
        assertEquals(emp.getPhoneNumber(), "456");
    }

    @Test
    public void getEmailTest(){
        assertEquals(emp.getEmail(), "ana@isep");
    }

    @Test
    public void setEmailTest(){
        emp.setEmail("isabel@isep");
        assertEquals(emp.getEmail(), "isabel@isep");
    }

    @Test
    public void getSalaryTest(){
        assertEquals(emp.getSalary(), 200);
    }

    @Test
    public void setSalaryTest(){
        emp.setSalary(300);
        assertEquals(emp.getSalary(), 300);
    }


    @Test
    public void checkIfEmployeeExistsTest(){
        assertTrue(employeeController.checkIfEmployeeExists(emp));
    }

    @Test
    public void returnSpecificEmployeeRoleTest(){
        EmployeeRole er1 = new EmployeeRole("Admin vacinas");
        EmployeeRole er2 = new EmployeeRole("Enfermeiro");

        Employee emp1 = employeeController.registerEmployee(er1, "A", "gaia", "123", "a@isep", 200);
        Employee emp2 = employeeController.registerEmployee(er2, "B", "gaia", "465", "b@isep", 300);
        Employee emp3 = employeeController.registerEmployee(er1, "C", "gaia", "789", "c@isep", 400);

        List<Employee> list = employeeController.listEmployeesWithSpecificRole(er1);
        for (Employee emp : list){
            assertEquals(emp.getEmployeeRole().getRole(), "Admin vacinas");
        }
        /*
        System.out.println(employeeController.listAllEmployees());
        System.out.println(employeeController.listEmployeesWithSpecificRole(er1));
        */

    }


}
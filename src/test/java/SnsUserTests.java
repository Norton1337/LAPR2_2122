import app.controller.snsUserController.SnsUserController;
import app.domain.model.SnsUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SnsUserTests {

    SnsUserController snsUserController = new SnsUserController();

    @Test
    public void ensureSNSnumberIsRegistered(){
        int snsNumber=1;
        String name = "Nuno";
        int age = 1;
        int phoneNumber = 123;
        String email = "nuno@isep";
        SnsUser usertest = new SnsUser(snsNumber,name,age,phoneNumber,email);
        Assertions.assertEquals(snsNumber,usertest.getSnsNumber());
    }
    @Test
    public void ensureNameIsRegistered(){
        int snsNumber=1;
        String name = "Nuno";
        int age = 1;
        int phoneNumber = 123;
        String email = "nuno@isep";
        SnsUser usertest = new SnsUser(snsNumber,name,age,phoneNumber,email);
        Assertions.assertEquals(name,usertest.getName());
    }
    @Test
    public void ensureAgeIsRegistered(){
        int snsNumber=1;
        String name = "Nuno";
        int age = 1;
        int phoneNumber = 123;
        String email = "nuno@isep";
        SnsUser usertest = new SnsUser(snsNumber,name,age,phoneNumber,email);
        Assertions.assertEquals(age,usertest.getAge());
    }
    @Test
    public void ensurePhoneNumebrIsRegistered(){
        int snsNumber=1;
        String name = "Nuno";
        int age = 1;
        int phoneNumber = 123;
        String email = "nuno@isep";
        SnsUser usertest = new SnsUser(snsNumber,name,age,phoneNumber,email);
        Assertions.assertEquals(phoneNumber,usertest.getPhoneNumber());
    }
    @Test
    public void ensureEmailIsRegistered(){
        int snsNumber=1;
        String name = "Nuno";
        int age = 1;
        int phoneNumber = 123;
        String email = "nuno@isep";
        SnsUser usertest = new SnsUser(snsNumber,name,age,phoneNumber,email);
        Assertions.assertEquals(email,usertest.getEmail());
    }
    @Test
    public void ensureTwoClientsAreRegistered() {
        int snsNumber1 = 1;
        String name1 = "Nuno";
        int age1 = 1;
        int phoneNumber1 = 123;
        String email1 = "nuno@isep";
        SnsUser usertest1 = new SnsUser(snsNumber1, name1, age1, phoneNumber1, email1);

        int snsNumber2 = 2;
        String name2 = "Paulo";
        int age2 = 2;
        int phoneNumber2 = 321;
        String email2 = "paulo@isep";
        SnsUser usertest2 = new SnsUser(snsNumber2, name2, age2, phoneNumber2, email2);

    }
}
package app.domain.model;

public class EmployeeRole {

    private String role;

    public EmployeeRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "EmployeeRole{" +
                "role='" + role + '\'' +
                '}';
    }
}

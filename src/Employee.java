public class Employee extends Person {
    private String employeeId;
    private String jobTitle;

    public Employee() {
        super();
        this.employeeId = "Not Assigned";
        this.jobTitle = "Not Assigned";
    }

    public Employee(String name, int age, String contactNumber, String employeeId, String jobTitle) {
        super(name, age, contactNumber);
        this.employeeId = employeeId;
        this.jobTitle = jobTitle;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
}

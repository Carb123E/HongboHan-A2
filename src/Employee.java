// The Employee class extends the Person class and represents an employee with additional details such as employee ID and job title.
public class Employee extends Person {

    // The employee's unique identifier (e.g., employee number).
    private String employeeId;

    // The employee's job title (e.g., Manager, Developer, etc.).
    private String jobTitle;

    // Default constructor for Employee class, calls the super class constructor and initializes employeeId and jobTitle to default values.
    public Employee() {
        super();  // Calls the constructor of the superclass (Person)
        this.employeeId = "Not Assigned";  // Default value for employee ID
        this.jobTitle = "Not Assigned";  // Default value for job title
    }

    // Parameterized constructor to initialize an Employee with a specific name, age, contact number, employee ID, and job title.
    // @param name The name of the employee.
    // @param age The age of the employee.
    // @param contactNumber The contact number of the employee.
    // @param employeeId The unique employee ID.
    // @param jobTitle The job title of the employee.
    public Employee(String name, int age, String contactNumber, String employeeId, String jobTitle) {
        super(name, age, contactNumber);  // Calls the constructor of the superclass (Person) to initialize the common properties
        this.employeeId = employeeId;  // Initializes the employee's ID
        this.jobTitle = jobTitle;  // Initializes the employee's job title
    }

    // Getter method for employeeId.
    // @return The employee's unique ID.
    public String getEmployeeId() {
        return employeeId;
    }

    // Setter method for employeeId.
    // @param employeeId The employee's unique ID to set.
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    // Getter method for jobTitle.
    // @return The employee's job title.
    public String getJobTitle() {
        return jobTitle;
    }

    // Setter method for jobTitle.
    // @param jobTitle The job title to set for the employee.
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
}

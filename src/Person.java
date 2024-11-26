// The Person class is an abstract class that represents a person with basic information such as name, age, and contact number.
public abstract class Person {

    // The name of the person (e.g., John Doe).
    private String name;

    // The age of the person (e.g., 30).
    private int age;

    // The contact number of the person (e.g., "123-456-7890").
    private String contactNumber;

    // Default constructor that initializes the person's attributes to default values.
    public Person() {
        this.name = "Unknown";  // Default name is set to "Unknown".
        this.age = 0;  // Default age is set to 0.
        this.contactNumber = "Not Available";  // Default contact number is set to "Not Available".
    }

    // Parameterized constructor that allows the creation of a Person object with specific details.
    // @param name The name of the person.
    // @param age The age of the person.
    // @param contactNumber The contact number of the person.
    public Person(String name, int age, String contactNumber) {
        this.name = name;  // Sets the person's name.
        this.age = age;  // Sets the person's age.
        this.contactNumber = contactNumber;  // Sets the person's contact number.
    }

    // Getter method for the person's name.
    // @return The name of the person.
    public String getName() {
        return name;
    }

    // Setter method for the person's name.
    // @param name The name to set for the person.
    public void setName(String name) {
        this.name = name;
    }

    // Getter method for the person's age.
    // @return The age of the person.
    public int getAge() {
        return age;
    }

    // Setter method for the person's age.
    // @param age The age to set for the person.
    public void setAge(int age) {
        this.age = age;
    }

    // Getter method for the person's contact number.
    // @return The contact number of the person.
    public String getContactNumber() {
        return contactNumber;
    }

    // Setter method for the person's contact number.
    // @param contactNumber The contact number to set for the person.
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}

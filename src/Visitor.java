// The Visitor class extends the Person class and represents a visitor at a theme park or similar venue.
public class Visitor extends Person {

    // Private fields to store the visitor's ticket number and favorite ride.
    private String ticketNumber;
    private String favoriteRide;

    // Default constructor that initializes the visitor with default values.
    // Calls the super() constructor from the Person class to initialize the inherited fields.
    public Visitor() {
        super();  // Call the constructor of the superclass (Person).
        this.ticketNumber = "Not Assigned";  // Default ticket number.
        this.favoriteRide = "Not Selected";  // Default favorite ride.
    }

    // Parameterized constructor to create a visitor with specified details.
    // This constructor uses the super() method to initialize the Person class fields (name, age, contact number).
    public Visitor(String name, int age, String contactNumber, String ticketNumber, String favoriteRide) {
        super(name, age, contactNumber);  // Call the constructor of the Person class with the given parameters.
        this.ticketNumber = ticketNumber;  // Set the visitor's ticket number.
        this.favoriteRide = favoriteRide;  // Set the visitor's favorite ride.
    }

    // Getter method for the ticket number.
    public String getTicketNumber() {
        return ticketNumber;
    }

    // Setter method for the ticket number.
    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    // Getter method for the favorite ride.
    public String getFavoriteRide() {
        return favoriteRide;
    }

    // Setter method for the favorite ride.
    public void setFavoriteRide(String favoriteRide) {
        this.favoriteRide = favoriteRide;
    }
}

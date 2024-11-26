public class Visitor extends Person {
    private String ticketNumber;
    private String favoriteRide;

    public Visitor() {
        super();
        this.ticketNumber = "Not Assigned";
        this.favoriteRide = "Not Selected";
    }

    public Visitor(String name, int age, String contactNumber, String ticketNumber, String favoriteRide) {
        super(name, age, contactNumber);
        this.ticketNumber = ticketNumber;
        this.favoriteRide = favoriteRide;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getFavoriteRide() {
        return favoriteRide;
    }

    public void setFavoriteRide(String favoriteRide) {
        this.favoriteRide = favoriteRide;
    }
}

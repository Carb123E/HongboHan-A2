import java.util.LinkedList;
import java.util.Queue;

public class Ride implements RideInterface {
    private String rideName;
    private String rideType;
    private Employee operator;
    private Queue<Visitor> queue;  // To store the waiting visitors

    // Default constructor
    public Ride() {
        this.rideName = "Unknown Ride";
        this.rideType = "Unknown Type";
        this.operator = null;  // No operator assigned
        this.queue = new LinkedList<>();  // Initialize an empty queue
    }

    // Parameterized constructor
    public Ride(String rideName, String rideType, Employee operator) {
        this.rideName = rideName;
        this.rideType = rideType;
        this.operator = operator;
        this.queue = new LinkedList<>();  // Initialize an empty queue
    }

    // Implement methods from RideInterface

    @Override
    public void addVisitorToQueue(Visitor visitor) {
        queue.add(visitor);  // Add visitor to the queue
        System.out.println(visitor.getName() + " has been added to the queue for ride: " + rideName);
    }

    @Override
    public void removeVisitorFromQueue(Visitor visitor) {
        if (queue.contains(visitor)) {
            queue.remove(visitor);  // Remove the visitor from the queue
            System.out.println(visitor.getName() + " has been removed from the queue for ride: " + rideName);
        } else {
            System.out.println(visitor.getName() + " is not in the queue for ride: " + rideName);
        }
    }

    @Override
    public void printQueue() {
        if (queue.isEmpty()) {
            System.out.println("The queue for " + rideName + " is currently empty.");
        } else {
            System.out.println("Queue for " + rideName + ":");
            for (Visitor v : queue) {
                System.out.println(v.getName() + " (Ticket: " + v.getTicketNumber() + ")");
            }
        }
    }

    @Override
    public void runOneCycle() {
        if (!queue.isEmpty()) {
            Visitor visitor = queue.poll();  // Remove the first visitor from the queue
            System.out.println(visitor.getName() + " has taken the ride: " + rideName);
        } else {
            System.out.println("No visitors in the queue for ride: " + rideName);
        }
    }

    @Override
    public void addVisitorToHistory(Visitor visitor) {
        // This method can be implemented if needed, based on previous requirements
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        // This method can be implemented if needed, based on previous requirements
        return false;
    }

    @Override
    public int numberOfVisitors() {
        return queue.size();  // Number of visitors in the queue
    }

    @Override
    public void printRideHistory() {
        // This method can be implemented if needed, based on previous requirements
    }

    // Getters and setters
    public String getRideName() {
        return rideName;
    }

    public void setRideName(String rideName) {
        this.rideName = rideName;
    }

    public String getRideType() {
        return rideType;
    }

    public void setRideType(String rideType) {
        this.rideType = rideType;
    }

    public Employee getOperator() {
        return operator;
    }

    public void setOperator(Employee operator) {
        this.operator = operator;
    }
}

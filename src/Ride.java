import java.util.Collections;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Queue;

public class Ride implements RideInterface {
    private String rideName;
    private String rideType;
    private Employee operator;
    private Queue<Visitor> queue;  // Queue for waiting visitors
    private LinkedList<Visitor> rideHistory;  // LinkedList for visitors who have taken the ride
    private int maxRider;  // Maximum number of visitors the ride can take in one cycle
    private int numOfCycles;  // Number of times the ride has been run

    // Constructor
    public Ride(String rideName, String rideType, Employee operator, int maxRider) {
        this.rideName = rideName;
        this.rideType = rideType;
        this.operator = operator;
        this.queue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
        this.maxRider = maxRider;
        this.numOfCycles = 0;
    }
    // Default constructor
    public Ride() {
        this.rideName = "Unknown Ride";
        this.rideType = "Unknown Type";
        this.operator = null;  // No operator assigned
        this.queue = new LinkedList<>();  // Initialize an empty queue
        this.rideHistory = new LinkedList<>();  // Initialize an empty ride history
    }

    // Parameterized constructor
    public Ride(String rideName, String rideType, Employee operator) {
        this.rideName = rideName;
        this.rideType = rideType;
        this.operator = operator;
        this.queue = new LinkedList<>();  // Initialize an empty queue
        this.rideHistory = new LinkedList<>();  // Initialize an empty ride history
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

    // Add a visitor to the ride history
    @Override
    public void addVisitorToHistory(Visitor visitor) {
        rideHistory.add(visitor);  // Add the visitor to the ride history
        System.out.println(visitor.getName() + " has been added to the ride history for: " + rideName);
    }

    // Check if a visitor is in the ride history
    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        if (rideHistory.contains(visitor)) {
            System.out.println(visitor.getName() + " is in the ride history for: " + rideName);
            return true;
        } else {
            System.out.println(visitor.getName() + " is not in the ride history for: " + rideName);
            return false;
        }
    }

    // Return the number of visitors in the ride history
    @Override
    public int numberOfVisitors() {
        return rideHistory.size();  // Number of visitors in the ride history
    }

    // Print all visitors in the ride history
    @Override
    public void printRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println("No visitors have taken the ride " + rideName + " yet.");
        } else {
            System.out.println("Ride history for " + rideName + ":");
            Iterator<Visitor> iterator = rideHistory.iterator();
            while (iterator.hasNext()) {
                Visitor visitor = iterator.next();
                System.out.println(visitor.getName() + " (Ticket: " + visitor.getTicketNumber() + ")");
            }
        }
    }

    public void sortRideHistory() {
        Collections.sort(rideHistory, new VisitorComparator());  // Sort the visitors in ride history
    }

    @Override
    public void runOneCycle() {
        if (operator == null) {
            System.out.println("Cannot run the ride. No operator assigned.");
            return;
        }

        if (queue.isEmpty()) {
            System.out.println("Cannot run the ride. No visitors in the queue.");
            return;
        }

        int ridersThisCycle = Math.min(maxRider, queue.size());  // Get the number of visitors to take in this cycle
        System.out.println("Running cycle " + (numOfCycles + 1) + "...");

        // Remove visitors from the queue and add them to the ride history
        for (int i = 0; i < ridersThisCycle; i++) {
            Visitor visitor = queue.poll();  // Remove from the queue
            addVisitorToHistory(visitor);  // Add to the ride history
        }

        numOfCycles++;  // Increase the number of cycles run
        System.out.println("Cycle " + numOfCycles + " completed.");
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

    public Queue<Visitor> getQueue() {
        return queue;
    }

    public void setQueue(Queue<Visitor> queue) {
        this.queue = queue;
    }

    public LinkedList<Visitor> getRideHistory() {
        return rideHistory;
    }

    public void setRideHistory(LinkedList<Visitor> rideHistory) {
        this.rideHistory = rideHistory;
    }

    public int getMaxRider() {
        return maxRider;
    }

    public void setMaxRider(int maxRider) {
        this.maxRider = maxRider;
    }

    public int getNumOfCycles() {
        return numOfCycles;
    }

    public void setNumOfCycles(int numOfCycles) {
        this.numOfCycles = numOfCycles;
    }
}

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Queue;

public class Ride implements RideInterface {
    private String rideName;
    private String rideType;
    private Employee operator;
    private Queue<Visitor> queue;
    private LinkedList<Visitor> rideHistory;
    private int maxRider;
    private int numOfCycles;
    public Ride(String rideName, String rideType, Employee operator, int maxRider) {
        this.rideName = rideName;
        this.rideType = rideType;
        this.operator = operator;
        this.queue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
        this.maxRider = maxRider;
        this.numOfCycles = 0;
    }
    public Ride() {
        this.rideName = "Unknown Ride";
        this.rideType = "Unknown Type";
        this.operator = null;
        this.queue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
    }

    public Ride(String rideName, String rideType, Employee operator) {
        this.rideName = rideName;
        this.rideType = rideType;
        this.operator = operator;
        this.queue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
    }
    // Adds a visitor to the ride queue
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        queue.add(visitor);  // Add the visitor to the queue
        System.out.println(visitor.getName() + " has been added to the queue for ride: " + rideName);
    }

    // Removes a visitor from the ride queue
    @Override
    public void removeVisitorFromQueue(Visitor visitor) {
        if (queue.contains(visitor)) {  // Check if the visitor is in the queue
            queue.remove(visitor);  // Remove the visitor from the queue
            System.out.println(visitor.getName() + " has been removed from the queue for ride: " + rideName);
        } else {
            System.out.println(visitor.getName() + " is not in the queue for ride: " + rideName);
        }
    }

    // Prints the current queue of visitors for the ride
    @Override
    public void printQueue() {
        if (queue.isEmpty()) {  // If the queue is empty
            System.out.println("The queue for " + rideName + " is currently empty.");
        } else {  // If there are visitors in the queue
            System.out.println("Queue for " + rideName + ":");
            for (Visitor v : queue) {  // Iterate through the queue
                System.out.println(v.getName() + " (Ticket: " + v.getTicketNumber() + ")");
            }
        }
    }

    // Adds a visitor to the ride history
    @Override
    public void addVisitorToHistory(Visitor visitor) {
        rideHistory.add(visitor);  // Add the visitor to the ride history list
        System.out.println(visitor.getName() + " has been added to the ride history for: " + rideName);
    }

    // Checks if a visitor is already in the ride history
    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        if (rideHistory.contains(visitor)) {  // Check if the visitor is in the ride history
            System.out.println(visitor.getName() + " is in the ride history for: " + rideName);
            return true;  // Return true if the visitor is in history
        } else {
            System.out.println(visitor.getName() + " is not in the ride history for: " + rideName);
            return false;  // Return false if the visitor is not in history
        }
    }

    // Returns the total number of visitors in the ride history
    @Override
    public int numberOfVisitors() {
        return rideHistory.size();  // Return the size of the ride history list
    }

    // Prints the ride history (all visitors who have ridden the ride)
    @Override
    public void printRideHistory() {
        if (rideHistory.isEmpty()) {  // If there are no visitors in the ride history
            System.out.println("No visitors have taken the ride " + rideName + " yet.");
        } else {  // If there are visitors in the ride history
            System.out.println("Ride history for " + rideName + ":");
            Iterator<Visitor> iterator = rideHistory.iterator();  // Iterate through the ride history
            while (iterator.hasNext()) {  // While there are more visitors in the history
                Visitor visitor = iterator.next();  // Get the next visitor
                System.out.println(visitor.getName() + " (Ticket: " + visitor.getTicketNumber() + ")");
            }
        }
    }

    // Sorts the ride history list using a custom comparator
    public void sortRideHistory() {
        Collections.sort(rideHistory, new VisitorComparator());
    }

    // Runs one cycle of the ride
    @Override
    public void runOneCycle() {
        // Check if an operator is assigned to the ride
        if (operator == null) {
            System.out.println("Cannot run the ride. No operator assigned.");
            return;
        }

        // Check if there are visitors in the queue to ride
        if (queue.isEmpty()) {
            System.out.println("Cannot run the ride. No visitors in the queue.");
            return;
        }

        // Determine how many visitors can ride this cycle (limited by maxRider or the queue size)
        int ridersThisCycle = Math.min(maxRider, queue.size());
        System.out.println("Running cycle " + (numOfCycles + 1) + "...");

        // Process each rider for this cycle
        for (int i = 0; i < ridersThisCycle; i++) {
            // Poll a visitor from the queue
            Visitor visitor = queue.poll();
            // Add the visitor to the ride history
            addVisitorToHistory(visitor);
        }

        // Increment the cycle count
        numOfCycles++;
        System.out.println("Cycle " + numOfCycles + " completed.");
    }

    // Exports the ride history to a file
    public void exportRideHistory(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            // Check if there are no visitors in the ride history
            if (rideHistory.isEmpty()) {
                System.out.println("No tourists have taken this amusement facility before.");
                return;
            }

            // Write each visitor's information to the file
            for (Visitor visitor : rideHistory) {
                writer.write("tourist: " + visitor.getName() + ", Ticket number: " + visitor.getTicketNumber());
                writer.newLine();  // New line after each record
            }

            // Confirmation message after successful export
            System.out.println("The historical records of the amusement equipment have been successfully exported to the file: " + fileName);
        } catch (IOException e) {
            // Handle IOExceptions, such as file access issues
            System.out.println(e.getMessage());
        }
    }

    // Imports the ride history from a file
    public void importRideHistory(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            // Read the file line by line
            while ((line = reader.readLine()) != null) {
                // Only process lines that start with "tourist:"
                if (line.startsWith("tourist:")) {
                    // Split the line into name and ticket number
                    String[] parts = line.split(", Ticket number: ");
                    if (parts.length == 2) {
                        String name = parts[0].replace("tourist: ", "").trim();  // Extract and trim the name
                        String ticketNumber = parts[1].trim();  // Extract and trim the ticket number

                        // Create a new Visitor object and add it to the ride history
                        Visitor visitor = new Visitor(name, 0, ticketNumber, "", rideName);
                        rideHistory.add(visitor);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            // Handle case when the file is not found
            e.getMessage();
        } catch (IOException e) {
            // Handle general IOExceptions
            e.getMessage();
        } catch (Exception e) {
            // Catch any other exceptions
            e.getMessage();
        }
    }

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

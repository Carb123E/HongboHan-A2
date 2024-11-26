public class AssignmentTwo {
    public static void main(String[] args) {

    }

    public void partThree() {
        // Creating instances of different objects
        Employee emp1 = new Employee("Alice", 28, "1234567890", "E123", "Ride Operator");
        Visitor visitor1 = new Visitor("Bob", 35, "0987654321", "T1001", "Roller Coaster");
        Visitor visitor2 = new Visitor("Charlie", 22, "5678901234", "T1002", "Roller Coaster");
        Visitor visitor3 = new Visitor("David", 30, "8765432109", "T1003", "Roller Coaster");
        Visitor visitor4 = new Visitor("Eva", 26, "2345678901", "T1004", "Roller Coaster");
        Visitor visitor5 = new Visitor("Frank", 40, "3456789012", "T1005", "Roller Coaster");

        // Create a new Ride object
        Ride ride1 = new Ride("Roller Coaster", "Thrill Ride", emp1);

        // Add visitors to the queue
        ride1.addVisitorToQueue(visitor1);
        ride1.addVisitorToQueue(visitor2);
        ride1.addVisitorToQueue(visitor3);
        ride1.addVisitorToQueue(visitor4);
        ride1.addVisitorToQueue(visitor5);

        // Print all visitors in the queue
        ride1.printQueue();

        // Remove a visitor from the queue
        ride1.removeVisitorFromQueue(visitor3);

        // Print all visitors in the queue after removal
        ride1.printQueue();

        // Run the ride for one cycle (first visitor in the queue goes on the ride)
        ride1.runOneCycle();

        // Print the updated queue after running the ride cycle
        ride1.printQueue();
    }

    public void partFourA() {
        // Create instances of different objects
        Employee emp1 = new Employee("Alice", 28, "1234567890", "E123", "Ride Operator");
        Visitor visitor1 = new Visitor("Bob", 35, "0987654321", "T1001", "Roller Coaster");
        Visitor visitor2 = new Visitor("Charlie", 22, "5678901234", "T1002", "Roller Coaster");
        Visitor visitor3 = new Visitor("David", 30, "8765432109", "T1003", "Roller Coaster");
        Visitor visitor4 = new Visitor("Eva", 26, "2345678901", "T1004", "Roller Coaster");
        Visitor visitor5 = new Visitor("Frank", 40, "3456789012", "T1005", "Roller Coaster");

        // Create a new Ride object
        Ride ride1 = new Ride("Roller Coaster", "Thrill Ride", emp1);

        // Add visitors to the queue
        ride1.addVisitorToQueue(visitor1);
        ride1.addVisitorToQueue(visitor2);
        ride1.addVisitorToQueue(visitor3);
        ride1.addVisitorToQueue(visitor4);
        ride1.addVisitorToQueue(visitor5);

        // Run the ride for several cycles
        ride1.runOneCycle();  // Bob takes the ride
        ride1.runOneCycle();  // Charlie takes the ride
        ride1.runOneCycle();  // David takes the ride

        // Check if a visitor is in the ride history
        ride1.checkVisitorFromHistory(visitor1);  // Should return false as Bob hasn't taken the ride yet
        ride1.checkVisitorFromHistory(visitor2);  // Should return true as Charlie took the ride

        // Print the number of visitors who have taken the ride
        System.out.println("Number of visitors who have taken the ride: " + ride1.numberOfVisitors());

        // Print all visitors who have taken the ride
        ride1.printRideHistory();
    }

    public void partFourB() {
    }

    public void partFive() {
    }

    public void partSix() {
    }

    public void partSeven() {
    }
}

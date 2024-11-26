import java.util.LinkedList;

public class AssignmentTwo {
    public static void main(String[] args) {
        AssignmentTwo two = new AssignmentTwo();
//        two.partThree();
//        two.partFourA();
//        two.partFourB();
//        two.partFive();
//        two.partSix();
//        two.partSeven();
    }

    // Part 3: Demonstrates adding visitors to a ride queue, removing a visitor, and running one cycle of the ride.
    public void partThree() {
        Employee emp1 = new Employee("Alice", 28, "1234567890", "E123", "Ride Operator");
        Visitor visitor1 = new Visitor("Bob", 35, "0987654321", "T1001", "Roller Coaster");
        Visitor visitor2 = new Visitor("Charlie", 22, "5678901234", "T1002", "Roller Coaster");
        Visitor visitor3 = new Visitor("David", 30, "8765432109", "T1003", "Roller Coaster");
        Visitor visitor4 = new Visitor("Eva", 26, "2345678901", "T1004", "Roller Coaster");
        Visitor visitor5 = new Visitor("Frank", 40, "3456789012", "T1005", "Roller Coaster");
        Ride ride1 = new Ride("Roller Coaster", "Thrill Ride", emp1);
        ride1.addVisitorToQueue(visitor1);
        ride1.addVisitorToQueue(visitor2);
        ride1.addVisitorToQueue(visitor3);
        ride1.addVisitorToQueue(visitor4);
        ride1.addVisitorToQueue(visitor5);
        ride1.printQueue();
        ride1.removeVisitorFromQueue(visitor3);
        ride1.printQueue();
        ride1.runOneCycle();
        ride1.printQueue();
    }

    // Part 4A: Demonstrates checking if visitors have taken the ride and printing the ride history.
    public void partFourA() {
        Employee emp1 = new Employee("Alice", 28, "1234567890", "E123", "Ride Operator");
        Visitor visitor1 = new Visitor("Bob", 35, "0987654321", "T1001", "Roller Coaster");
        Visitor visitor2 = new Visitor("Charlie", 22, "5678901234", "T1002", "Roller Coaster");
        Visitor visitor3 = new Visitor("David", 30, "8765432109", "T1003", "Roller Coaster");
        Visitor visitor4 = new Visitor("Eva", 26, "2345678901", "T1004", "Roller Coaster");
        Visitor visitor5 = new Visitor("Frank", 40, "3456789012", "T1005", "Roller Coaster");
        Ride ride1 = new Ride("Roller Coaster", "Thrill Ride", emp1);
        ride1.addVisitorToQueue(visitor1);
        ride1.addVisitorToQueue(visitor2);
        ride1.addVisitorToQueue(visitor3);
        ride1.addVisitorToQueue(visitor4);
        ride1.addVisitorToQueue(visitor5);
        ride1.runOneCycle();
        ride1.runOneCycle();
        ride1.runOneCycle();
        ride1.checkVisitorFromHistory(visitor1);
        ride1.checkVisitorFromHistory(visitor2);
        System.out.println("Number of visitors who have taken the ride: " + ride1.numberOfVisitors());
        ride1.printRideHistory();
    }

    // Part 4B: Demonstrates sorting the ride history by ticket number.
    public void partFourB() {
        Employee emp1 = new Employee("Alice", 28, "1234567890", "E123", "Ride Operator");
        Visitor visitor1 = new Visitor("Bob", 35, "0987654321", "T1001", "Roller Coaster");
        Visitor visitor2 = new Visitor("Charlie", 22, "5678901234", "T1002", "Roller Coaster");
        Visitor visitor3 = new Visitor("David", 30, "8765432109", "T1003", "Roller Coaster");
        Visitor visitor4 = new Visitor("Eva", 26, "2345678901", "T1004", "Roller Coaster");
        Visitor visitor5 = new Visitor("Frank", 40, "3456789012", "T1005", "Roller Coaster");
        Ride ride1 = new Ride("Roller Coaster", "Thrill Ride", emp1);
        ride1.addVisitorToHistory(visitor1);
        ride1.addVisitorToHistory(visitor2);
        ride1.addVisitorToHistory(visitor3);
        ride1.addVisitorToHistory(visitor4);
        ride1.addVisitorToHistory(visitor5);
        System.out.println("Unsorted Ride History:");
        ride1.printRideHistory();
        ride1.sortRideHistory();
        System.out.println("\nSorted Ride History:");
        ride1.printRideHistory();
    }

    // Part 5: Demonstrates adding multiple visitors to the queue and running the ride for one cycle.
    public void partFive() {
        Employee emp1 = new Employee("Alice", 28, "1234567890", "E123", "Ride Operator");
        Ride ride1 = new Ride("Roller Coaster", "Thrill Ride", emp1, 3);
        for (int i = 1; i <= 10; i++) {
            Visitor visitor = new Visitor("Visitor " + i, 20 + i, "Ticket" + i, "T" + (1000 + i), "Roller Coaster");
            ride1.getQueue().offer(visitor);
        }
        System.out.println("Visitors in the Queue before the ride:");
        ride1.printQueue();
        ride1.runOneCycle();
        System.out.println("\nVisitors in the Queue after one cycle:");
        ride1.printQueue();
        System.out.println("\nVisitors in the Ride History:");
        ride1.printRideHistory();
    }

    // Part 6: Demonstrates exporting the ride history to a CSV file.
    public void partSix() {
        Employee emp1 = new Employee("Alice", 28, "1234567890", "E123", "Ride Operator");
        Ride ride1 = new Ride("Extreme roller coaster", "Thrilling type", emp1, 3);
        LinkedList<Visitor> rideHistory = new LinkedList<>();
        for (int i = 1; i <= 5; i++) {
            Visitor visitor = new Visitor("tourist " + i, 20 + i, "Ticket" + i, "T" + (1000 + i), "Extreme roller coaster");
            ride1.getQueue().offer(visitor);
            rideHistory.add(visitor);
        }
        ride1.setRideHistory(rideHistory);
        System.out.println("Tourists queuing for amusement facilities：");
        ride1.printQueue();
        String fileName = "rideHistory.csv";
        ride1.exportRideHistory(fileName);
        ride1.printRideHistory();
    }

    // Part 7: Demonstrates importing the ride history from a CSV file and printing it.
    public void partSeven() {
        Employee emp1 = new Employee("Alice", 28, "1234567890", "E123", "Ride Operator");
        Ride ride1 = new Ride("Extreme roller coaster", "Thrilling type", emp1, 3);
        String fileName = "rideHistory.csv";
        ride1.importRideHistory(fileName);
        System.out.println("Number of imported tourists: " + ride1.getRideHistory().size());
        ride1.printRideHistory();
    }
}

// The RideInterface defines the operations that should be implemented by any ride class.
public interface RideInterface {

    // Adds a visitor to the queue for the ride.
    // @param visitor The Visitor object to be added to the queue.
    void addVisitorToQueue(Visitor visitor);

    // Removes a visitor from the queue for the ride.
    // @param visitor The Visitor object to be removed from the queue.
    void removeVisitorFromQueue(Visitor visitor);

    // Prints the list of visitors currently in the ride queue.
    void printQueue();

    // Runs one cycle of the ride, possibly changing the state of the ride.
    void runOneCycle();

    // Adds a visitor to the ride's history (e.g., to record the visitor's ride activity).
    // @param visitor The Visitor object to be added to the history.
    void addVisitorToHistory(Visitor visitor);

    // Checks if a visitor has already been added to the ride's history.
    // @param visitor The Visitor object to check for in the history.
    // @return true if the visitor is found in the history, otherwise false.
    boolean checkVisitorFromHistory(Visitor visitor);

    // Returns the number of visitors currently in the ride queue.
    // @return The number of visitors in the queue.
    int numberOfVisitors();

    // Prints the history of visitors who have been on the ride.
    void printRideHistory();
}

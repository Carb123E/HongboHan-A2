import java.util.Comparator;

public class VisitorComparator implements Comparator<Visitor> {

    // The compare method is used to compare two Visitor objects (v1 and v2).
    @Override
    public int compare(Visitor v1, Visitor v2) {
        // First, compare by age. This will return:
        // - a negative value if v1 is younger than v2,
        // - 0 if both are of the same age,
        // - a positive value if v1 is older than v2.
        int ageComparison = Integer.compare(v1.getAge(), v2.getAge());

        // If the ages are different, return the result of the age comparison.
        if (ageComparison != 0) {
            return ageComparison;
        }

        // If ages are the same, compare by ticket number as a secondary criterion.
        // The compareTo method of String compares lexicographically.
        return v1.getTicketNumber().compareTo(v2.getTicketNumber());
    }
}

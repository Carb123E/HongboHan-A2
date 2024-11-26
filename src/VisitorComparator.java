import java.util.Comparator;

public class VisitorComparator implements Comparator<Visitor> {

    @Override
    public int compare(Visitor v1, Visitor v2) {
        // First compare by age (ascending order)
        int ageComparison = Integer.compare(v1.getAge(), v2.getAge());
        if (ageComparison != 0) {
            return ageComparison;
        }

        // If ages are the same, compare by ticket number (ascending order)
        return v1.getTicketNumber().compareTo(v2.getTicketNumber());
    }
}

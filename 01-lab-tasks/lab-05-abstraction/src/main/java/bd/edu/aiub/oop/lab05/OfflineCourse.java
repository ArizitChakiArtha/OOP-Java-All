package bd.edu.aiub.oop.lab05;

/**
 * Concrete offline course.
 */
public class OfflineCourse extends Course {
    private String room;

    /**
     * Creates an offline course.
     *
     * @param code course code
     * @param title title
     * @param credit credit count
     * @param room room number
     */
    public OfflineCourse(String code, String title, int credit, String room) {
        super(code, title, credit);
        setRoom(room);
    }

    /** @return room number */
    public String getRoom() { return room; }

    /** @param room room number */
    public void setRoom(String room) {
        if (room == null || room.trim().isEmpty()) throw new IllegalArgumentException("Room is required.");
        this.room = room.trim().toUpperCase();
    }

    /** @return delivery mode */
    @Override
    public String getDeliveryMode() { return "Offline"; }

    /** @return weighted final score */
    @Override
    public double calculateFinalScore(double mid, double finalExam) { return mid * 0.45 + finalExam * 0.55; }
}

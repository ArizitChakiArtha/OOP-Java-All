package bd.edu.aiub.oop.lab05;

/**
 * Concrete online course.
 */
public class OnlineCourse extends Course {
    private String meetingLink;

    /**
     * Creates an online course.
     *
     * @param code course code
     * @param title course title
     * @param credit credit count
     * @param meetingLink online meeting link
     */
    public OnlineCourse(String code, String title, int credit, String meetingLink) {
        super(code, title, credit);
        setMeetingLink(meetingLink);
    }

    /** @return meeting link */
    public String getMeetingLink() { return meetingLink; }

    /** @param meetingLink online meeting link */
    public void setMeetingLink(String meetingLink) {
        if (meetingLink == null || !meetingLink.startsWith("http")) throw new IllegalArgumentException("Valid meeting URL required.");
        this.meetingLink = meetingLink;
    }

    /** @return delivery mode */
    @Override
    public String getDeliveryMode() { return "Online"; }

    /** @return weighted final score */
    @Override
    public double calculateFinalScore(double mid, double finalExam) { return mid * 0.40 + finalExam * 0.60; }
}

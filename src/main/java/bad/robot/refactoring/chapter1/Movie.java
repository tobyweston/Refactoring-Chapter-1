package bad.robot.refactoring.chapter1;

public class Movie {

    public enum Classification {
        CHILDREN,
        REGULAR,
        NEW_RELEASE;
    }

    private String title;
    private Classification classification;

    public Movie(String title, Classification classification) {
        this.title = title;
        this.classification = classification;
    }

    public String getTitle() {
        return title;
    }

    public Classification getClassification() {
        return classification;
    }
}

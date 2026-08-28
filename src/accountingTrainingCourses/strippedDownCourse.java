package accountingTrainingCourses;

public class strippedDownCourse extends BaseCourse implements Course {
    private double price;
    private int period;
    private double month = 2500;
    private int week = 4;

    public strippedDownCourse(String courseCategory, double price, int period) {
        super(courseCategory);
        this.price = price;
        this.period = period;
    }

    public double getPrice() {
        return price;
    }

    public int getPeriod() {
        return period;
    }

    @Override
    public double calculatePrice(){
        return month * period;
    }
    @Override public int getDurationHours(){
        return week * period * 5;
    }
}

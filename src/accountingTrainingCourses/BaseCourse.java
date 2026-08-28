package accountingTrainingCourses;

public class BaseCourse implements Course{
    private String courseCategory;

    public BaseCourse(String courseCategory) {
        this.courseCategory = courseCategory;
    }

    @Override
    public String getCourseCategory() {
        return courseCategory;
    }

    @Override
    public double calculatePrice() {
        return 0;
    }

    @Override
    public int getDurationHours() {
        return 0;
    }
}

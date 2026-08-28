package accountingTrainingCourses;

public class Main {
    public static void main(String[] args) {
        Course[] courses = new Course[]{
                new fullCourse("FullCourse", 45000, 13),
                new strippedDownCourse("strippedDownCourse", 23000, 5)
        };

        for (Course c : courses){
            System.out.println(c.getCourseCategory() + " " + c.getDurationHours() + " " + c.calculatePrice());
        }
    }

}

package accountingTrainingCourses;

public interface Course {
    double calculatePrice(); //рассчитать стоимость курса
    int getDurationHours(); //получить продолжительность курса в часах
    String getCourseCategory(); //получить категорию курса
}

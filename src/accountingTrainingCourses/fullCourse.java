package accountingTrainingCourses;

public class fullCourse extends BaseCourse  implements Course{


    private double price;
    private int period;
    private double month = 3750;
    private int week = 4;

    public fullCourse(String courseCategory,double price, int period) {
        super(courseCategory);
        if(price < 45000 || price > 90000){
            throw new IllegalArgumentException("Невозможная сумма, это цена урезанного курса");
        }
        if(period < 12){
            throw new IllegalArgumentException("Невозможный период, этот перио урезанного курса");
        }
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

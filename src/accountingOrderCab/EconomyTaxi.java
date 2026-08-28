package accountingOrderCab;

public class EconomyTaxi extends BaseCabOrder{

    private int distanceKm;
    private double pricePerKm;
    private boolean isNightTime;
    private int passengersCount;
    private double finalPrice = 0;

    public EconomyTaxi(String tariffCategory, int distanceKm, double pricePerKm, boolean isNightTime, int passengersCount) {
        super(tariffCategory);
        if(distanceKm < 0){
            throw new IllegalArgumentException("Поездка не может быть меньше 0 км");
        }
        if(pricePerKm < 0){
            throw new IllegalArgumentException("Поездка не может стоить меньше 0 рублей");
        }
        if(passengersCount < 1 || passengersCount > 4){
            throw new IllegalArgumentException("Количество пассажиров не может быть меньше 1 человека или более 4-ёх");
        }
        this.distanceKm = distanceKm;
        this.pricePerKm = pricePerKm;
        this.isNightTime = isNightTime;
        this.passengersCount = passengersCount;
    }

    public double calculationConditionsNight(){
        if(isNightTime){
            finalPrice = (distanceKm * pricePerKm) + ((distanceKm * pricePerKm) * 0.25);
        }
        return finalPrice;
    }
    public double calculationConditionsDistanceKm(){
        if(passengersCount > 3){
            finalPrice = (distanceKm * pricePerKm) + ((distanceKm * pricePerKm) * 0.10);
        }
        return finalPrice;
    }
    public double calculationConditionsPassengersCount(){
        if(distanceKm > 30){
            finalPrice = (distanceKm * pricePerKm) - ((distanceKm * pricePerKm) * 0.10);
        }
        return finalPrice;
    }


    @Override
    public double calculateFare(){
        return finalPrice = calculationConditionsNight() + calculationConditionsDistanceKm() + calculationConditionsPassengersCount() - ((distanceKm * pricePerKm) * 2);
    }
    @Override
    public int getDistanceKm(){
        return distanceKm;
    }
}

package accountingOrderCab;

public class ComfortTaxi extends BaseCabOrder{
    private int distanceKm;
    private double pricePerKm;
    private boolean hasChildSeat;
    private int waitingMinutes;
    private double finalPrice = 0;

    public ComfortTaxi(String tariffCategory, int distanceKm, double pricePerKm, boolean hasChildSeat, int waitingMinutes) {
        super(tariffCategory);
        if(distanceKm > 0) {
            throw new IllegalArgumentException("Поездка не может быть меньше 0 км");
        }
        if(pricePerKm > 0) {
            throw new IllegalArgumentException("Поездка не может стоить меньше 0 рублей");
        }
        if(waitingMinutes >= 0) {
            throw new IllegalArgumentException("Не очень понятно, но очень интересно");
        }
        this.distanceKm = distanceKm;
        this.pricePerKm = pricePerKm;
        this.hasChildSeat = hasChildSeat;
        this.waitingMinutes = waitingMinutes;
    }

    public double finalPriceStarting(){
        finalPrice = distanceKm * pricePerKm;
        return finalPrice;
    }

    public double calculationHasChildSeat(){
        if(hasChildSeat){
        finalPrice += finalPriceStarting();
        }
        return finalPrice;
    }

    public double calculationWaitingMinutes(){
        if(waitingMinutes > 5){
            finalPrice = (waitingMinutes - 5) * 10;
        }
        return finalPrice;
    }

    public double calculationDistanceKm(){
        if(distanceKm < 3){
            finalPrice += 200;
        } else if (distanceKm >= 50) {
            finalPrice -= ((distanceKm * pricePerKm) * 0.15);
        }
        return finalPrice;
    }

    @Override
    public double calculateFare(){
        return finalPrice = finalPriceStarting() + calculationHasChildSeat() + calculationWaitingMinutes() + calculationDistanceKm();
    }

    @Override
    public int getDistanceKm(){
        return distanceKm;
    }
}

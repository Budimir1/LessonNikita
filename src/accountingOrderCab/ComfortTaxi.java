package accountingOrderCab;

public class ComfortTaxi extends BaseCabOrder implements CabOrder{
    private int distanceKm;
    private double pricePerKm;
    private boolean hasChildSeat;
    private int waitingMinutes;
    private double finalPrice = 0;

    public ComfortTaxi(String tariffCategory, int distanceKm, double pricePerKm, boolean hasChildSeat, int waitingMinutes) {
        super(tariffCategory);
        if(distanceKm < 0) {
            throw new IllegalArgumentException("Поездка не может быть меньше 0 км");
        }
        if(pricePerKm < 0) {
            throw new IllegalArgumentException("Поездка не может стоить меньше 0 рублей");
        }
        if(waitingMinutes <= 0) {
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
        return hasChildSeat ? (distanceKm * pricePerKm) * 2 :0;
    }

    public double calculationWaitingMinutes(){
        return waitingMinutes > 5 ? (waitingMinutes - 5) * 10 :0;
    }

    public double calculationDistanceKm(){
        if(distanceKm < 3){
            finalPrice += 200;
        } else if (distanceKm >= 50) {
            finalPrice -= ((distanceKm * pricePerKm) * 0.15);
        }return 0;
    }

    @Override
    public double calculateFare(){
        finalPrice = finalPriceStarting()
                + calculationHasChildSeat()
                + calculationWaitingMinutes()
                + calculationDistanceKm();
        return finalPrice;
    }

    @Override
    public int getDistanceKm(){
        return distanceKm;
    }
}

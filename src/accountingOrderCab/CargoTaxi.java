package accountingOrderCab;

public class CargoTaxi extends BaseCabOrder implements CabOrder{
    private int distanceKm;
    private double pricePerKm;
    private double cargoWeightKg;
    private boolean needsLoaders;
    private  double finalPrice;

    public CargoTaxi(String tariffCategory, int distanceKm, double pricePerKm, double cargoWeightKg, boolean needsLoaders) {
        super(tariffCategory);
        if (distanceKm < 0){
            throw new IllegalArgumentException(" ");
        }
        if (pricePerKm < 0){
            throw new IllegalArgumentException("");
        }
        if (cargoWeightKg < 0){
            throw new IllegalArgumentException("");
        }
        this.distanceKm = distanceKm;
        this.pricePerKm = pricePerKm;
        this.cargoWeightKg = cargoWeightKg;
        this.needsLoaders = needsLoaders;
    }

    public double finalPriceStart(){
        finalPrice = distanceKm * pricePerKm;
        return finalPrice;
    }
    public double calculationConditionsNight(){
        return needsLoaders ? + 300 :0;
    }
    public double calculationConditionsDistanceKm(){
        return distanceKm >= 120 ? (distanceKm * pricePerKm) * 0.12 :0;
    }
    public double calculationcargoWeightKg(){
        if(cargoWeightKg > 500){
            finalPrice = (distanceKm * pricePerKm) * 0.4;
        } else if (cargoWeightKg > 200) {
            finalPrice = (distanceKm * pricePerKm) * 0.2;
        }
        return 0;
    }

    @Override
    public double calculateFare(){
        finalPrice = finalPriceStart()
                + calculationConditionsNight()
                + calculationcargoWeightKg()
                - calculationConditionsDistanceKm();
        return finalPrice;
    }
    @Override
    public int getDistanceKm(){
        return distanceKm;
    }
}

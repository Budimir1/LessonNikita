package accountingOrderCab;

public class BaseCabOrder implements CabOrder {
    private String tariffCategory;

    public BaseCabOrder(String tariffCategory) {
        this.tariffCategory = tariffCategory;
    }

    @Override
    public double calculateFare() {
        return 0;
    }

    @Override
    public int getDistanceKm() {
        return 0;
    }

    public String getTariffCategory() {
        return tariffCategory;
    }
}

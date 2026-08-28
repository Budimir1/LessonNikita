package accountingOrderCab;

public class Main {
    public static void main(String[] args) {
        CabOrder[] cabOrders = new CabOrder[]{
          new EconomyTaxi("Эконом", 35, 75, true, 3)
        };

        for (CabOrder c : cabOrders){
            System.out.println(c.getTariffCategory() + " " + c.getDistanceKm() + " " + c.calculateFare());
        }
    }

}

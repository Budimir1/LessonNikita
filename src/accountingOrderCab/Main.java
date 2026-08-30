package accountingOrderCab;

public class Main {
    public static void main(String[] args) {
        CabOrder[] cabOrders = new CabOrder[]{
          new EconomyTaxi("Эконом", 35, 75, true, 3),
          new ComfortTaxi("Комфорт", 24, 60,true, 7)
        };

        for (CabOrder c : cabOrders){
            System.out.println(c.getTariffCategory() + " Тариф " + "\n" + c.getDistanceKm() + " Километраж " + "\n" + c.calculateFare() + " Итоговая цена");
        }
    }

}

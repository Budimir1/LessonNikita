package accountingOrderCab;

public interface CabOrder {
    public double calculateFare(); //подсчёт заказа
    public int getDistanceKm(); //получчения дисанции в км
    public String getTariffCategory(); //получение тарифа
}

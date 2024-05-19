public interface MarketBehaviour {
    void acceptOrder(String person); // Принять заказ
    void releaseOrder();             // Отдать заказ
    void update();                   // Обновить состояние магазина
}

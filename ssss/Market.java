import java.util.LinkedList;
import java.util.Queue;

public class Market implements QueueBehaviour, MarketBehaviour {
    private Queue<String> queue;
    private Queue<String> orders;

    public Market() {
        this.queue = new LinkedList<>();
        this.orders = new LinkedList<>();
    }

    // Реализация метода из QueueBehaviour
    @Override
    public void enqueue(String person) {
        queue.add(person);
        System.out.println(person + " вошел в очередь.");
    }

    // Реализация метода из QueueBehaviour
    @Override
    public void dequeue() {
        if (!queue.isEmpty()) {
            String person = queue.poll();
            System.out.println(person + " вышел из очереди.");
        } else {
            System.out.println("Очередь пуста.");
        }
    }

    // Реализация метода из MarketBehaviour
    @Override
    public void acceptOrder(String person) {
        orders.add(person);
        System.out.println("Заказ от " + person + " принят.");
    }

    // Реализация метода из MarketBehaviour
    @Override
    public void releaseOrder() {
        if (!orders.isEmpty()) {
            String person = orders.poll();
            System.out.println("Заказ для " + person + " выдан.");
        } else {
            System.out.println("Нет заказов для выдачи.");
        }
    }

    // Реализация метода из MarketBehaviour
    @Override
    public void update() {
        // В данном методе мы предполагаем, что магазин обновляет свои состояния:
        // принимаем заказы от всех в очереди и затем выдаем все принятые заказы.
        System.out.println("Обновление состояния магазина...");
        while (!queue.isEmpty()) {
            String person = queue.poll();
            acceptOrder(person);
        }
        while (!orders.isEmpty()) {
            releaseOrder();
        }
    }

    // Метод для демонстрации текущего состояния очереди и заказов
    public void displayState() {
        System.out.println("Текущая очередь: " + queue);
        System.out.println("Текущие заказы: " + orders);
    }

    public static void main(String[] args) {
        Market market = new Market();
        
        market.enqueue("Alice");
        market.enqueue("Bob");
        market.displayState();

        market.update();
        market.displayState();

        market.enqueue("Charlie");
        market.displayState();

        market.update();
        market.displayState();
    }
}

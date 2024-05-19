public interface QueueBehaviour {
    void enqueue(String person); // Помещает человека в очередь
    void dequeue();              // Удаляет человека из очереди
}

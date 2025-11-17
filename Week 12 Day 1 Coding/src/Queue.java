public interface Queue
{
    void enqueue(int value);
    int dequeue();
    int peek();
    boolean isEmpty();
}

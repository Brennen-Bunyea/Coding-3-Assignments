public class MyQueue extends DoublyLinkedList implements Queue
{
    public void enqueue(int value)
    {
        addLast(value);
    }

    public int dequeue()
    {
        int removedValue = removeFirst();
        return removedValue;
    }

    public int peek()
    {
        if(head == null)
        {
            throw new RuntimeException("Queue is empty");
        }

        int frontValue = head.data;
        return frontValue;
    }

    public boolean isEmpty()
    {
        boolean result = super.isEmpty();
        return result;
    }
}

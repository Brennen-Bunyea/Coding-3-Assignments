public class MyStack extends DoublyLinkedList implements Stack
{
    public void push(int value) {
        addLast(value);
    }

    public int pop()
    {
        int removedValue = removeLast();
        return removedValue;
    }

    public int peek()
    {
        if(tail == null)
        {
            throw new RuntimeException("Stack is empty");
        }

        int topValue = tail.data;
        return topValue;
    }

    public boolean isEmpty()
    {
        boolean result = super.isEmpty();
        return result;
    }
}

import java.util.NoSuchElementException;

public class DoublyLinkedList
{
    protected class Node
    {
        int data;
        Node next;
        Node prev;

        Node (int data)
        {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    protected Node head;
    protected Node tail;
    protected int size;

    public DoublyLinkedList()
    {
        head = null;
        tail = null;
        size = 0;
    }

    public void addLast(int value)
    {
        Node newNode = new Node(value);
        if(head == null)
        {
            head = newNode;
            tail = newNode;
        }
        else
        {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public void addFirst(int value)
    {
        Node newNode = new Node(value);
        if(head == null)
        {
            head = newNode;
            tail = newNode;
        }
        else
        {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public int removeLast()
    {
        if(tail == null)
        {
            throw new RuntimeException("List is empty");
        }

        int value = tail.data;
        if(head == tail)
        {
            head = null;
            tail = null;
        }
        else
        {
            tail = tail.prev;
            tail.next = null;
        }

        size--;
        return value;
    }

    public int removeFirst()
    {
        if(head == null)
        {
            throw new RuntimeException("List is empty");
        }

        int value = head.data;
        if(head == tail)
        {
            head = null;
            tail = null;
        }
        else
        {
            head = head.next;
            head.prev = null;
        }

        size--;
        return value;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public void printList()
    {
        Node current = head;
        while(current != null)
        {
            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.println();
    }
}
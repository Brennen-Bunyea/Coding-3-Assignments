public class SinglyLinkedList<T extends Comparable<? super T>>
{
    //constructor for Node
    private class Node
    {
        T data;
        Node next;
        Node(T data) {this.data = data;}
    }

    private Node head;
    private int size;

    //check to make sure the value of a given node is not null
    private void check(T value)
    {
        if(value == null)
        {
            throw new IllegalArgumentException("Null not allowed!");
        }
    }

    //append function to add node to list at end
    public void append(T value)
    {
        check(value);
        Node n = new Node(value);

        // If list empty, new node is head
        if (head == null)
        {
            head = n;
        }
        else
        {
            Node cur = head;

            while (cur.next != null)
            {
                cur = cur.next;
            }

            cur.next = n;
        }

        size++;
    }

    //prepend function to add node to list at beginning
    public void prepend(T value)
    {
        check(value);
        Node n = new Node(value);
        n.next = head;
        head = n;
        size++;
    }

    //function to add node after a given other node
    public void insertAfter(T target, T value)
    {
        check(target);
        check(value);
        Node cur = head;
        while(cur != null && !cur.data.equals(target))
        {
            cur = cur.next;
        }

        if(cur != null)
        {
            Node n = new Node(value);
            n.next = cur.next;
            cur.next = n;
            size++;
        }
    }

    //function to add node before a given other node
    public void insertBefore(T target, T value)
    {
        check(target);
        check(value);
        if(head == null)
        {
            return;
        }

        if(head.data.equals(target))
        {
            prepend(value);
            return;
        }

        Node previous = null;
        Node current = head;
        while(current.next != null && !current.data.equals(target))
        {
            previous = current;
            current = current.next;
        }

        if(current != null)
        {
            Node n = new Node(value);
            previous.next = n;
            n.next = current;
            size++;
        }
    }

    //function to delete the first node in the list
    public void delete(T value)
    {
        check(value);
        if(head == null)
        {
            return;
        }

        if(head.data.equals(value))
        {
            head = head.next;
            size--;
            return;
        }

        Node previous = null;
        Node current = head;

        while(current.next != null && !current.data.equals(value))
        {
            previous = current;
            current = current.next;
        }

        if(current != null) {
            previous.next = current.next;
            size--;
        }
    }

    //function to delete the last node in the list
    public void remove()
    {
        if(head == null)
        {
            return;
        }

        if(head.next == null)
        {
            head = null;
            size = 0;
            return;
        }

        Node previous = null;
        Node current = head;
        while(current.next != null)
        {
            previous = current;
            current = current.next;
        }
        previous.next = current.next;
        size--;
    }

    //function to search the list to find a node with a given value
    public boolean search(T value)
    {
        check(value);
        Node current = head;
        while(current != null)
        {
            if(current.data.equals(value))
            {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    //returns the total number of nodes in the given list
    public int length()
    {
        return size;
    }

    //returns the size as 0 if the list is empty
    public boolean isEmpty()
    {
        return size == 0;
    }

    //Quick sort choose the last node as pivot.
    //Then move items smaller than pivot to the left, and then the larger items to the right
    public void sort()
    {
        Node tail = getTail(head);
        quickSort(head, tail);
    }

    //getter to get the tail node of the list
    private Node getTail(Node n)
    {
        if(n == null)
        {
            return null;
        }

        Node current = n;
        while(current.next != null)
        {
            current = current.next;
        }

        return current;
    }

    //quickSort method to sort the list
    private void quickSort(Node start, Node end)
    {
        if(start == null || end == null || start == end)
        {
            return;
        }

        Node pivot = partition(start, end);

        //sort the left side
        if (pivot != start)
        {
            Node temp = start;

            while (temp.next != pivot)
            {
                temp = temp.next;
            }

            quickSort(start, temp);
        }

        //sort the right side
        if (pivot != end && pivot.next != null)
        {
            quickSort(pivot.next, end);
        }
    }

    //partition method to split the list into two pieces to sort
    private Node partition(Node start, Node end)
    {
        T pivotVal = end.data;
        Node slow = start;
        Node fast = start;

        while (fast != end)
        {
            if (fast.data.compareTo(pivotVal) < 0)
            {
                T temp = slow.data;
                slow.data = fast.data;
                fast.data = temp;

                slow = slow.next;
            }
            fast = fast.next;
        }

        T temp = slow.data;
        slow.data = end.data;
        end.data = temp;

        return slow;
    }

    //function to print the list
    public void print()
    {
        Node current = head;
        while(current != null)
        {
            System.out.print(current.data);
            if(current.next != null)
            {
                System.out.print(" --> ");
            }
            current = current.next;
        }
        System.out.println();
    }
}

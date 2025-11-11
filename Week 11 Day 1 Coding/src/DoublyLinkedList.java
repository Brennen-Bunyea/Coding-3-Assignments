public class DoublyLinkedList
{
    //node class
    private class Node
    {
        int data;
        Node next;
        Node prev;

        Node( int data)
        {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;

    //append end
    public void append(int value) {
        Node newNode = new Node(value);
        if (this.head == null) {
            this.head = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    //prepend front
    public void prepend(int value)
    {
        Node newNode = new Node(value);
        if(head == null)
        {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    //insert after given node
    public void insertAfter(int target, int value)
    {
        Node current = search(target);
        if(current == null)
        {
            return;
        }

        Node newNode = new Node(value);
        newNode.next = current.next;
        newNode.prev = current;

        if(current.next != null)
        {
            current.next.prev = newNode;
        }
        else {
            tail = newNode;
        }
        current.next = newNode;
    }

    //insert before given node
    public void insertBefore(int target, int value)
    {
        Node current = search(target);
        if(current == null)
        {
            return;
        }

        Node newNode = new Node(value);
        newNode.next = current;
        newNode.prev = current.prev;

        if(current.prev != null)
        {
            current.prev.next = newNode;
        }
        else
        {
            head = newNode;
        }
        current.prev = newNode;
    }

    //remove after given node
    public void removeAfter(int target)
    {
        Node current = search(target);
        if(current == null || current.next == null)
        {
            return;
        }

        Node toRemove = current.next;
        current.next = toRemove.next;

        if(toRemove.next != null)
        {
            toRemove.next.prev = current;
        }
        else
        {
            tail = current;
        }
    }

    //remove before given node
    public void removeBefore(int target)
    {
        Node current = search(target);
        if(current == null || current.prev == null)
        {
            return;
        }

        Node toRemove = current.prev;
        current.prev = toRemove.prev;

        if(toRemove.prev != null)
        {
            toRemove.prev.next = current;
        }
        else
        {
            head = current;
        }
    }

    //search by value
    public Node search(int value)
    {
        Node temp = head;
        while(temp != null)
        {
            if(temp.data == value)
            {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    //MergeSort
    public void sort()
    {
        head = mergeSort(head);
        Node temp = head;
        while(temp.next != null)
        {
            temp = temp.next;
        }
        tail = temp;
    }

    private Node mergeSort(Node h)
    {
        if (h == null || h.next == null)
        {
            return h;
        }

        Node middle = getMiddle(h);
        Node nextOfMiddle = middle.next;
        middle.next = null;
        if (nextOfMiddle != null)
        {
            nextOfMiddle.prev = null;
        }

        Node left = mergeSort(h);
        Node right = mergeSort(nextOfMiddle);

        return merge(left, right);
    }

    private Node merge(Node a, Node b)
    {
        if (a == null) return b;
        if (b == null) return a;

        if (a.data <= b.data)
        {
            a.next = merge(a.next, b);
            if (a.next != null)
                a.next.prev = a;
            return a;
        }
        else
        {
            b.next = merge(a, b.next);
            if (b.next != null)
                b.next.prev = b;
            return b;
        }
    }

    private Node getMiddle(Node head)
    {
        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //print list forward
    public void display()
    {
        Node temp = head;
        System.out.print("NULL <-> ");
        while(temp != null)
        {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
}

public class Main
{
    public static void main(String[] args)
    {

        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        list.append(5);
        list.append(2);
        list.append(9);
        list.append(1);
        System.out.println("After append:");
        list.print();

        list.prepend(7);
        System.out.println("After prepend 7:");
        list.print();

        list.insertAfter(5, 6);
        System.out.println("After insertAfter 5 -> 6:");
        list.print();

        list.insertBefore(7, 3);
        System.out.println("After insertBefore 7 -> 3:");
        list.print();

        list.delete(2);
        System.out.println("After delete 2:");
        list.print();

        list.remove();
        System.out.println("After remove last:");
        list.print();

        list.append(9);
        list.append(0);
        list.append(7);
        list.append(1);

        System.out.println("Before sort:");
        list.print();

        list.sort();
        System.out.println("After quickSort:");
        list.print();

    }
}
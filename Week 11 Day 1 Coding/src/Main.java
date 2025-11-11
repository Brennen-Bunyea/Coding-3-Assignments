public class Main {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.append(5);
        dll.append(3);
        dll.append(9);
        dll.append(2);
        dll.append(4);
        dll.prepend(1);
        dll.insertAfter(3, 7);
        dll.insertBefore(9, 6);

        dll.display();

        dll.removeAfter(3);
        dll.removeBefore(6);

        dll.display();

        dll.sort();
        dll.display();
    }
}
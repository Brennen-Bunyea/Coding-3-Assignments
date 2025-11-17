//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Stack Test:");

        MyStack stack = new MyStack();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.printList();

        int popped = stack.pop();
        System.out.println("Pop = " + popped);

        int top = stack.peek();
        System.out.println("Peek = " + top);

        stack.printList();

        System.out.println("Queue Test:");
        MyQueue queue = new MyQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        queue.printList();

        int dq = queue.dequeue();
        System.out.println("Dequeue = " + dq);

        int front = queue.peek();
        System.out.println("Dequeue = " + front);

        queue.printList();

    }
}
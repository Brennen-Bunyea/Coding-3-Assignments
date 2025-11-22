public class Main
{
    public static void main(String[] args)
    {
        ArrayList list = new ArrayList();

        list.append(5);
        list.append(2);
        list.append(9);

        list.prepend(1);
        list.insert(2, 7);

        list.print();

        list.sort(true);
        list.print();

        list.sort(false);
        list.print();

        System.out.println("Index of 7: " + list.search(7));

        list.remove(1);
        list.print();
    }
}
public class Main
{
    public static void main(String[] args)
    {

        LinearProbing<Integer, String> table = new LinearProbing<>(5);

        System.out.println("=== INSERTING VALUES ===");
        table.add(1, "One");
        table.add(6, "Six");
        table.add(11, "Eleven");
        table.printTable();

        System.out.println("=== RESIZE TRIGGER ===");
        table.add(2, "Two");
        table.add(3, "Three");
        table.printTable();

        System.out.println("=== SEARCHING ===");
        System.out.println("get(1) -> " + table.get(1));
        System.out.println("get(6) -> " + table.get(6));
        System.out.println("get(11) -> " + table.get(11));
        System.out.println("get(100) -> " + table.get(100));

        System.out.println("\n=== UPDATING ===");
        table.add(6, "Six (Updated)");
        table.printTable();

        System.out.println("=== REMOVING ===");
        table.remove(6);
        table.remove(11);
        table.printTable();

        System.out.println("=== INSERT AFTER DELETE ===");
        table.add(16, "Sixteen");
        table.add(21, "Twenty-one");
        table.printTable();

        System.out.println("Demo complete!");
    }
}

public static void main(String[] args)
    {
        // Create hash table instance
        // small initial capacity so we can see resizing
        HashTableAddressing<Integer, String> table = new HashTableAddressing<>(5, 0.6); // threshold 60%

        System.out.println("=== Creating hash table and inserting elements ===");
        table.add(1, "One");
        table.add(6, "Six (collides with 1 if capacity is 5)");
        table.add(11, "Eleven (another collision)");
        table.printTable();

        System.out.println("=== Inserting more elements to trigger resize ===");
        table.add(2, "Two");
        table.add(3, "Three");
        table.printTable();

        System.out.println("=== Searching for keys ===");
        System.out.println("get(1)  -> " + table.get(1));
        System.out.println("get(6)  -> " + table.get(6));
        System.out.println("get(11) -> " + table.get(11));
        System.out.println("get(100) (not present) -> " + table.get(100));
        System.out.println();

        System.out.println("=== Updating an existing key (6) ===");
        table.add(6, "Six (updated)");
        table.printTable();

        System.out.println("=== Removing some keys ===");
        System.out.println("remove(6)  -> " + table.remove(6));
        System.out.println("remove(11) -> " + table.remove(11));
        System.out.println("remove(42) (not present) -> " + table.remove(42));
        table.printTable();

        System.out.println("=== Searching after deletions (demonstrate EMPTY-AFTER-DELETE) ===");
        System.out.println("get(1)  -> " + table.get(1));   // should still be found
        System.out.println("get(6)  -> " + table.get(6));   // should be null
        System.out.println("get(11) -> " + table.get(11));  // should be null
        System.out.println();

        System.out.println("=== Inserting after deletions (reusing EMPTY-AFTER-DELETE slots) ===");
        table.add(16, "Sixteen (may reuse deleted bucket)");
        table.add(21, "Twenty-one");
        table.printTable();

        System.out.println("Demo complete!");
    }


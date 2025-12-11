public class Main
{

    public static void main(String[] args)
    {

        SearchTree tree = new SearchTree();

        int[] values = {50, 30, 70, 20, 40, 60, 80, 35, 45, 75};
        int index = 0;

        while (index < values.length)
        {
            int number = values[index];
            tree.insert(number);
            index++;
        }

        System.out.println("=== BST Traversals Before Deletions ===");

        System.out.print("Inorder Traversal: ");
        tree.inorderTraversal();

        System.out.print("Reverse-order Traversal: ");
        tree.reverseOrderTraversal();

        System.out.print("Preorder Traversal: ");
        tree.preorderTraversal();

        System.out.print("Postorder Traversal: ");
        tree.postorderTraversal();

        // SEARCH TESTS
        System.out.println("\n=== Search Tests ===");

        boolean searchResult1 = tree.search(40);
        System.out.println("Search 40 (exists): " + searchResult1);

        boolean searchResult2 = tree.search(95);
        System.out.println("Search 95 (does not exist): " + searchResult2);

        // DELETE TESTS
        System.out.println("\n=== Deleting Nodes ===");
        System.out.println("Deleting leaf node: 20");
        tree.delete(20);

        System.out.println("Deleting node with two children: 30");
        tree.delete(30);

        System.out.println("\n=== BST Traversals After Deletions ===");

        System.out.print("Inorder Traversal: ");
        tree.inorderTraversal();

        System.out.print("Reverse-order Traversal: ");
        tree.reverseOrderTraversal();

        System.out.print("Preorder Traversal: ");
        tree.preorderTraversal();

        System.out.print("Postorder Traversal: ");
        tree.postorderTraversal();

        // HEIGHT
        int height = tree.getHeight();
        System.out.println("\nTree Height: " + height);
    }
}


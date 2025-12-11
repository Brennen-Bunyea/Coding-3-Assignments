public class SearchTree
{
    //internal node structure
    private class TreeNode
    {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value)
        {
            this.value = value;
        }
    }

    private TreeNode root;

    //insert method
    public void insert(int value)
    {
        root = insertRecursive(root,value);
    }

    private TreeNode insertRecursive(TreeNode node,int value)
    {
        if(node == null)
            return new TreeNode(value);

        if(value < node.value)
        {
            node.left = insertRecursive(node.left,value);
        }
        else if(value > node.value)
        {
            node.right = insertRecursive(node.right, value);
        }
        return node;
    }

    //search method
    public boolean search(int value)
    {
        return searchRecursive(root, value);
    }

    private boolean searchRecursive(TreeNode node, int value) {
        if (node == null)
        {
            return false;
        }
        if (value == node.value)
        {
            return true;
        }
        if (value < node.value)
        {
            return searchRecursive(node.left, value);
        }
        return searchRecursive(node.right, value);
    }

    //delete
    public void delete(int value)
    {
        root = deleteRecursive(root, value);
    }

    private TreeNode deleteRecursive(TreeNode node, int value)
    {
        if (node == null)
        {
            return null;
        }
        if (value < node.value)
        {
            node.left = deleteRecursive(node.left, value);
            return node;
        }
        if (value > node.value) {
            node.right = deleteRecursive(node.right, value);
            return node;
        }

        //Node Found
        //No children
        if (node.left == null && node.right == null) {
            return null;
        }

        //One child
        if (node.left == null) {
            TreeNode rightChild = node.right;
            return rightChild;
        }
        if (node.right == null) {
            TreeNode leftChild = node.left;
            return leftChild;
        }

        //Two children, replace with inorder successor
        int successorValue = findMin(node.right);
        node.value = successorValue;
        node.right = deleteRecursive(node.right, successorValue);

        return node;
    }

    private int findMin(TreeNode node)
    {
        TreeNode current = node;

        while (current.left != null)
        {
            current = current.left;
        }

        return current.value;
    }

    //inorder
    public void inorderTraversal()
    {
        inorder(root);
        System.out.println();
    }

    private void inorder(TreeNode node)
    {
        if (node == null)
        {
            return;
        }

        inorder(node.left);
        System.out.print(node.value + " ");
        inorder(node.right);
    }

    //reverse order
    public void reverseOrderTraversal()
    {
        reverseOrder(root);
        System.out.println();
    }

    private void reverseOrder(TreeNode node)
    {
        if (node == null)
        {
            return;
        }

        reverseOrder(node.right);
        System.out.print(node.value + " ");
        reverseOrder(node.left);
    }

    //preorder
    public void preorderTraversal()
    {
        preorder(root);
        System.out.println();
    }

    private void preorder(TreeNode node)
    {
        if (node == null)
        {
            return;
        }

        System.out.print(node.value + " ");
        preorder(node.left);
        preorder(node.right);
    }

    //postorder
    public void postorderTraversal()
    {
        postorder(root);
        System.out.println();
    }

    private void postorder(TreeNode node)
    {
        if (node == null)
        {
            return;
        }

        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value + " ");
    }

    //height
    public int getHeight()
    {
        return heightRecursive(root);
    }

    private int heightRecursive(TreeNode node)
    {
        if (node == null)
        {
            return -1;
        }

        int leftHeight = heightRecursive(node.left);
        int rightHeight = heightRecursive(node.right);

        int max;

        if (leftHeight > rightHeight)
        {
            max = leftHeight;
        }
        else
        {
            max = rightHeight;
        }

        return 1 + max;
    }
}

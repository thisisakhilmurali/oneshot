import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SerializeDeserializeBinaryTree {

    public static class TreeNode {

        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    public static String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        List<String> serialized = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            // If current node is NULL, store marker
            if (node == null) {
                serialized.add("null");
            } else {

                // Else, store current node
                // and recur for its children
                serialized.add(String.valueOf(node.val));
                //@todo push the nodes (left and right) onto the stack
                stack.push(node.right);
                stack.push(node.left);
            }
        }
        //@todo return the String output after using the join function
        return String.join(",", serialized);
    }

    static int t;

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }

        String[] arr = data.split(",");
        t = 0;
        return deserializeHelper(arr);
    }

    public static TreeNode deserializeHelper(String[] arr) {
        if (t >= arr.length || arr[t].equals("null")) {
            t++;
            return null;
        }

        // Create node with this item
        // and recur for children
        TreeNode root
                = new TreeNode(Integer.parseInt(arr[t++]));
        //@todo Evaluate root.left
        root.left = deserializeHelper(arr);
        //@todo Evualate root.right
        root.right = deserializeHelper(arr);
        return root;
    }


    private static void printPreOrderTraversal(TreeNode node) {
        if (node != null) {
            printPreOrderTraversal(node.left);
            printPreOrderTraversal(node.right);
        }
    }

}

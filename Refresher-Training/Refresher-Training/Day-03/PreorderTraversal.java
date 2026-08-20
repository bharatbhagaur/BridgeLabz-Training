//PreorderTraversal
import java.io.*;
import java.util.*;

class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int data) {
        this.data = data;
    }
}

public class PreorderTraversal {

    static TreeNode insert(TreeNode root, int data) {
        if (root == null)
            return new TreeNode(data);

        if (data <= root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }

        return root;
    }

    static void preOrder(TreeNode root) {
        if (root == null)
            return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        TreeNode root = null;

        for (int i = 0; i < n; i++) {
            root = insert(root, sc.nextInt());
        }

        preOrder(root);
    }
}
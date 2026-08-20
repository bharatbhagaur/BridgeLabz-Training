//HeightOfBinaryTree
import java.io.*;
import java.util.*;

class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int data) {
        this.data = data;
    }
}

public class HeightOfBinaryTree{

    static TreeNode insert(TreeNode root, int data) {
        if (root == null)
            return new TreeNode(data);

        if (data <= root.data)
            root.left = insert(root.left, data);
        else
            root.right = insert(root.right, data);

        return root;
    }

    static int height(TreeNode root) {
        if (root == null)
            return -1;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        TreeNode root = null;

        for (int i = 0; i < n; i++) {
            root = insert(root, sc.nextInt());
        }

        System.out.println(height(root));
    }
}
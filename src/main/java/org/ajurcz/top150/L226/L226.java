package org.ajurcz.top150.L226;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class L226 {

    static TreeNode invertTree(TreeNode root) {
        if (isNull(root)) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    static void main() {
        TreeNode testCase = new TreeNode(5, new TreeNode(10), new TreeNode(15));

        System.out.println(invertTree(testCase));
    }
}

//  Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        String leftString = nonNull(left) ? left.toString() : null;
        String rightString = nonNull(right) ? right.toString() : null;

        return String.valueOf(val).concat(" And left: " + leftString + " And right: " + rightString);
    }
}
package org.ajurcz.top150.L106;

import static java.util.Objects.nonNull;

public class L106 {
    static TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    static TreeNode buildTree(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        // current root
        TreeNode root = new TreeNode(postorder[postEnd]);

        int inorderTargetIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inorderTargetIndex = i;
            }
        }
        int leftSubTreeSize = inorderTargetIndex - inStart;

        TreeNode left = buildTree(inorder, postorder, inStart, inorderTargetIndex - 1, postStart, postStart + leftSubTreeSize - 1);
        TreeNode right = buildTree(inorder, postorder, inorderTargetIndex + 1, inEnd, postStart + leftSubTreeSize, postEnd - 1);
        root.left = left;
        root.right = right;

        return root;
    }

    static void main() {
        System.out.println(buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}));
    }
}

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

        return String.valueOf(val).concat(" And left: " + leftString + " And right: " + rightString + "\n");
    }
}
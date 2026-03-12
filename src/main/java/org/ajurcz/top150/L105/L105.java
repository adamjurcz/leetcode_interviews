package org.ajurcz.top150.L105;

import static java.util.Objects.nonNull;

public class L105 {

    static TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    static TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        // current root
        TreeNode root = new TreeNode(preorder[preStart]);

        int inorderTargetIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (root.val == inorder[i]) {
                inorderTargetIndex = i;
            }
        }

        int leftSubTreeSize = inorderTargetIndex - inStart;

        TreeNode left = buildTree(preorder, preStart + 1, preStart + leftSubTreeSize,
                inorder, inStart, inorderTargetIndex - 1);

        TreeNode right = buildTree(preorder, preStart + leftSubTreeSize + 1, preEnd,
                inorder, inorderTargetIndex + 1, inEnd);

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
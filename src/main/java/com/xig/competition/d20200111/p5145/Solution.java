package com.xig.competition.d20200111.p5145;

/**
 * Created with IntelliJ IDEA.
 * Date: 2020-01-11 23:23
 * Author: xig
 * Description:
 * <p>
 * 5145. 祖父节点值为偶数的节点和
 * <p>
 * 给你一棵二叉树，请你返回满足以下条件的所有节点的值之和：
 * <p>
 * 该节点的祖父节点的值为偶数。（一个节点的祖父节点是指该节点的父节点的父节点。）
 * 如果不存在祖父节点值为偶数的节点，那么返回 0 。
 * <p>
 * <p>
 * <p>
 * 示例：
 * 输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 * 输出：18
 * 解释：图中红色节点的祖父节点的值为偶数，蓝色节点为这些红色节点的祖父节点。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点的数目在 1 到 10^4 之间。
 * 每个节点的值在 1 到 100 之间。
 */
public class Solution {

    public static void main(String[] args) {
        TreeNode root;
        root = new TreeNode(6);
        root.left = new TreeNode(7);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(7);

        root.left.left.left = new TreeNode(9);
        root.left.right.left = new TreeNode(1);
        root.left.right.right = new TreeNode(4);

        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(3);

        root.right.right.right = new TreeNode(5);


        new Solution().sumEvenGrandparent(root);
    }


    int out = 0;
    public int sumEvenGrandparent(TreeNode root) {
        TreeNodeNew rootNew = createNewTree(root);
        getValue(rootNew);
        return out;
    }

    private void getValue(TreeNodeNew root) {
        if (root != null) {
            if (root.parent != null)
                if (null != root.parent.parent && root.parent.parent.val % 2 == 0)
                    out += root.val;
            getValue(root.left);
            getValue(root.right);
        }
    }

    private TreeNodeNew createNewTree(TreeNode root) {
        TreeNodeNew rootNew = new TreeNodeNew();
        copyBiTree(root, rootNew, null, true);
        return rootNew;
    }

    void copyBiTree(TreeNode root, TreeNodeNew rootNew, TreeNodeNew parent, boolean LAR) {
        if (root != null) {
            if (rootNew == null) {
                rootNew = new TreeNodeNew();
                if (parent != null) {
                    if (LAR) {
                        parent.left = rootNew;
                    } else {
                        parent.right = rootNew;
                    }
                }
            }
            rootNew.val = root.val;
            rootNew.parent = parent;
            copyBiTree(root.left, rootNew.left, rootNew, true);
            copyBiTree(root.right, rootNew.right, rootNew, false);
        }
    }

    static class TreeNodeNew {
        int val;
        TreeNodeNew left;
        TreeNodeNew right;
        TreeNodeNew parent;
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}

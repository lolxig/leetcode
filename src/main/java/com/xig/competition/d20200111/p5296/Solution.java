package com.xig.competition.d20200111.p5296;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 5296. 两棵二叉搜索树中的所有元素
 * <p>
 * 给你 root1 和 root2 这两棵二叉搜索树。
 * <p>
 * 请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。.
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * 输入：root1 = [2,1,4], root2 = [1,0,3]
 * 输出：[0,1,1,2,3,4]
 * <p>
 * 示例 2：
 * 输入：root1 = [0,-10,10], root2 = [5,1,7,0,2]
 * 输出：[-10,0,0,1,2,5,7,10]
 * <p>
 * 示例 3：
 * 输入：root1 = [], root2 = [5,1,7,0,2]
 * 输出：[0,1,2,5,7]
 * <p>
 * 示例 4：
 * 输入：root1 = [0,-10,10], root2 = []
 * 输出：[-10,0,10]
 * <p>
 * 示例 5：
 * 输入：root1 = [1,null,8], root2 = [8,1]
 * 输出：[1,1,8,8]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 每棵树最多有 5000 个节点。
 * 每个节点的值在 [-10^5, 10^5] 之间。
 */
public class Solution {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> result = new ArrayList<>();
        getElements(root1, result);
        getElements(root2, result);
        Collections.sort(result);
        return result;
    }

    private static void getElements(TreeNode root, List<Integer> result) {
        if (root != null) {
            getElements(root.left, result);
            result.add(root.val);
            getElements(root.right, result);
        }
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

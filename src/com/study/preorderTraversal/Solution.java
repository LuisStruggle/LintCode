package com.study.preorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Definition of TreeNode:
 * public class TreeNode {
 * public int val;
 * public TreeNode left, right;
 * public TreeNode(int val) {
 * this.val = val;
 * this.left = this.right = null;
 * }
 * }
 */
public class Solution
{

    public class TreeNode
    {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val)
        {
            this.val = val;
            this.left = this.right = null;
        }
    }

    /**
     * 描述：按前序遍历数节点，不使用递归
     * 
     * @param root: A Tree
     * @return: Preorder in ArrayList which contains node values.
     */
    public List<Integer> preorderTraversal(TreeNode root)
    {
        // write your code here
        List<Integer> treeValue = new ArrayList<Integer>(); // 按前序遍历，根，左，右，存储根节点的值
        Stack<TreeNode> treeNode = new Stack<TreeNode>(); // 存储当前未遍历到的节点，方便倒退遍历右子树

        while (root != null)
        {
            // 存储节点值
            treeValue.add(root.val);

            if (root.left != null)
            {
                treeNode.push(root);
                root = root.left;
            }
            else if (root.right != null)
            {
                root = root.right;
            }
            else if (!treeNode.isEmpty())
            {
                root = treeNode.pop().right;
            }
        }

        return treeValue;
    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        Solution s = new Solution();
        TreeNode tn0 = s.new TreeNode(1);
        TreeNode tn1 = s.new TreeNode(2);
        TreeNode tn2 = s.new TreeNode(3);
        tn0.right = tn1;
        tn1.left = tn2;
        System.out.println(s.preorderTraversal(tn0));
    }

}

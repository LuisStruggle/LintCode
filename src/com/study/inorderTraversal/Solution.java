package com.study.inorderTraversal;

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
     * @param root: A Tree
     * @return: Inorder in ArrayList which contains node values.
     */
    public List<Integer> inorderTraversal(TreeNode root)
    {
        // write your code here
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while (root != null)
        {
            if (root.left != null)
            {
                stack.push(root);
                root = root.left;
            }
            else
            {
                list.add(root.val);
                while (root.right == null && !stack.empty())
                {
                    root = stack.pop();
                    list.add(root.val);
                }
                root = root.right;
            }
        }

        return list;
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
        System.out.println(s.inorderTraversal(tn0));
    }

}

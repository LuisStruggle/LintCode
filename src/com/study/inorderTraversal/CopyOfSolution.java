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
public class CopyOfSolution
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
        Stack<TreeNode> stack = new Stack<TreeNode>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        TreeNode curt = root;
        while (curt != null || !stack.empty())
        {
            while (curt != null)
            {
                stack.add(curt);
                curt = curt.left;
            }
            curt = stack.pop();
            result.add(curt.val);
            curt = curt.right;
        }
        return result;
    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        CopyOfSolution s = new CopyOfSolution();
        TreeNode tn0 = s.new TreeNode(1);
        TreeNode tn1 = s.new TreeNode(2);
        TreeNode tn2 = s.new TreeNode(3);
        tn0.right = tn1;
        tn1.left = tn2;
        System.out.println(s.inorderTraversal(tn0));
    }

}

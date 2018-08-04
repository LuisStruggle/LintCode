package com.study.preorderTraversal;

import java.util.ArrayList;
import java.util.List;

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
        List<Integer> treeValue = new ArrayList<Integer>(); // 按前序遍历，根，左，右，存储根节点额值
        treeValue.add(root.val);
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

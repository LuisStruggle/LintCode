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
        if (root == null)
        {
            return treeValue;
        }

        treeNode.push(root);

        while (!treeNode.empty())
        {
            TreeNode node = treeNode.pop();
            treeValue.add(node.val);
            if (node.right != null)
            {
                treeNode.push(node.right);
            }
            if (node.left != null)
            {
                treeNode.push(node.left);
            }
        }

        return treeValue;
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
        System.out.println(s.preorderTraversal(tn0));
    }

}

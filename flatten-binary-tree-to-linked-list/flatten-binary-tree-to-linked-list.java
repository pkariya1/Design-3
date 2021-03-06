/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {
        //base
        if(root == null)
            return;
        
        if(root.left ==null && root.right == null)
            return;
        
        //logic 
        if(root.left!=null){
            
            flatten(root.left);
            
            TreeNode tempNodeRight = root.right;// temp= 4
            root.right = root.left; // 
            root.left = null;
            
            TreeNode curr = root.right;
            while(curr.right!=null)
                curr = curr.right;
            
            curr.right = tempNodeRight;
            
        }
        flatten(root.right);
        
        
    }
}
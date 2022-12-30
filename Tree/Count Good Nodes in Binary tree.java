class Solution {
    public int goodNodes(TreeNode root) {
        return helper(root,root.val);
    }
    
    
    private int helper(TreeNode node,int max) {
        if(node==null)
            return 0;
        
        max=Math.max(max,node.val);
        int l = helper(node.left,max);
        int r = helper(node.right,max);
        int v = (node.val>=max) ? 1 : 0;
        
        return l+r+v;
    }
    
}

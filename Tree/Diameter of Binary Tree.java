
class Solution {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return max;
    }

    private int height(TreeNode node){
      if(node==null) return 0;
      int left = height(node.left);
      int right = height(node.right);
      max = Math.max(max,left+right);
      return 1+Math.max(left,right);
    }
}

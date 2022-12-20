class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        int[] a = dfs(root, -1, x, 0);
        int[] b = dfs(root, -1, y, 0);
        return  a[1] == b[1] && a[0] != b[0]; 
    }

    public int[] dfs(TreeNode root, int parent, int val, int depth){
        if(root == null){
            return new int[]{-1, -1};
        }
        if(root.val == val){
            return new int[]{parent, depth};
        }
        int[] left = dfs(root.left, root.val, val, depth + 1);
        if(left[1] != -1){
            return left;
        }
        return dfs(root.right, root.val, val, depth + 1);
    }
}

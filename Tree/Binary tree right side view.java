class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root==null) return res;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            int n = q.size();
            for(int i=0; i < n; ++i){
                TreeNode t = q.poll();
                if(t.left!=null)    q.offer(t.left);
                if(t.right != null) q.offer(t.right);
                if(i==n-1) res.add(t.val);
            }
        }
        return res;
    }
}

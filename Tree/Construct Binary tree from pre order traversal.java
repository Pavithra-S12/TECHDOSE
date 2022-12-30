class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder,0,preorder.length-1,new boolean[preorder.length]);
    }

    TreeNode helper(int[] arr,int idx,int len,boolean[] visited){
        if(idx>len || visited[idx]) return null;
        visited[idx] = true;
        TreeNode node = new TreeNode(arr[idx]);
        
        /* Make right child */
        int i=idx+1;
        while(i<=len && arr[i]<node.val) i++;
        node.right = helper(arr,i,len,visited);
        
        /* Make left child */
        if(idx+1<=len && arr[idx+1]<node.val)
            node.left = helper(arr,idx+1,len,visited);

        return node;
    }
}

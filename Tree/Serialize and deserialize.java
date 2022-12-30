public String serialize(TreeNode root) {
    if(root == null) return "";
    Queue<TreeNode> q = new LinkedList<TreeNode>();
    q.offer(root);
    String ret = "";
    while(!q.isEmpty()) {
        TreeNode node = q.poll();
        if(node != null) {
        	ret += ","+node.val;
        	q.offer(node.left);
            q.offer(node.right);
        } else { 
        	ret += ",null";
        }
    }
    // System.out.println(ret);
    return ret.substring(1, ret.length());
}

// Decodes your encoded data to tree.
public TreeNode deserialize(String data) {
    if(data == null || data.length() < 1) return null;
    String[] d = data.split(",");
    if(d[0].equals("null")) return null;
    
    TreeNode root = new TreeNode(Integer.valueOf(d[0]));
    Queue<TreeNode> q = new LinkedList<TreeNode>();
    q.offer(root);
    int i = 1;
    while(!q.isEmpty() && i < d.length-1) {
        int size = q.size();
        TreeNode node = q.poll();
        
        if(!d[i].equals("null")) {
            node.left = new TreeNode(Integer.valueOf(d[i]));
            q.offer(node.left);
        }
        i++;
        
        if(!d[i].equals("null")) {
            node.right = new TreeNode(Integer.valueOf(d[i]));
            q.offer(node.right);
        }
        i++;
        
    }
    return root;
}
}


struct TreeNode * invertTree(struct TreeNode * root) 
{
    if (root == NULL)
        return root;
    
    // swap pointers
    struct TreeNode * tmp = root->left;
    root->left = root->right;
    root->right = tmp;
    
    // repeat for left and right
    invertTree(root->left);
    invertTree(root->right);
    
    return root;
}

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> levelValues = new ArrayList<>();
        helper(root, levelValues, 0);
        int size = levelValues.size();
        for (int i = 1; i < size; i = i + 2) {
            List<Integer> values = levelValues.get(i);
            int left = 0;
            int right = values.size() - 1;
            while (left < right) {
                int tempLeft = values.get(left);
                int tempRight = values.get(right);
                values.remove(left);
                values.add(left, tempRight);
                values.remove(right);
                values.add(right, tempLeft);
                left++;
                right--;
            }
        }
        return levelValues;
    }
    
    private void helper(TreeNode node, List<List<Integer>> levelValues, int level) {
        if (node == null) {
            return;
        }

        List<Integer> values;
        int size = levelValues.size();
        if (level >= size) {
            values = new ArrayList<>();
            levelValues.add(values);
        } else {
            values = levelValues.get(level);
        }
        values.add(node.val);
        helper(node.left, levelValues, level + 1);
        helper(node.right, levelValues, level + 1);
    }
}

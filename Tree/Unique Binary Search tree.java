public class Solution {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    public int numTrees(int n) {
        if(n == 0) return 0;
        return total(1, n);
    }
    
    private int total(int left, int right){
        if(map.containsKey(right - left)) return map.get(right - left);
        if(left >= right) map.put(right - left, 1);
        else{
            int tot = 0;
            for(int i = left; i <= right; i++){
                tot += total(left, i - 1) * total(i + 1, right);
            }
            map.put(right - left, tot);
        }
        return map.get(right - left);
    }
}

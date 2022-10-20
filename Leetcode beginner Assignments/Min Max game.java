class Solution {
    public int minMaxGame(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }
        int[] ans = new int[arr.length / 2];
        int ind = 0, cnt = 0;
        for (int i = 0; i < arr.length - 1; i += 2, cnt++) {
            int val = 0;
            if (cnt % 2 == 0) {
                val = Integer.min(arr[i], arr[i+1]);
            }
            else val = Integer.max(arr[i], arr[i+1]);
            ans[ind++] = val;
        }
        return minMaxGame(ans);
    }
}

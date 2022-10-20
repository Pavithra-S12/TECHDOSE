class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] ans = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int size=0;
            for(int j=0;j<nums.length;j++){
                if(nums[j]<=queries[i]){
                    queries[i]-=nums[j];
                    size++;
                }
                else break;
            }
            ans[i] = size;
        }
        return ans;
    }
}

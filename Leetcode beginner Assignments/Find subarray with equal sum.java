class Solution {
    public boolean findSubarrays(int[] nums) {
        
        int[] a = new int[nums.length-1];
        
        for(int i=0;i<nums.length-1;i++)
        {
            a[i] = nums[i]+nums[i+1]; 
        }
        
        Arrays.sort(a);
        for(int i=0;i<a.length-1;i++)
        {
            if(a[i] == a[i+1]) return true;
        }
        
        return false;
    }
}

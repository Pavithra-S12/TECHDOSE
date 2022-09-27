Class Solution 
{ 
Public List<List<Integer>> foursum(int nums[],int target)
{ 
List<List<Integer>> ans=new ArrayList<List<Integer>>();
    
    if (nums == null || nums.length == 0)
        return ans;
    
    int n=nums.length;
    Arrays.sort(nums);
    
    for(int i=0; i<n; i++){
        int target3=target-nums[i];
        for(int j=i+1; j<n; j++){
            int left=j+1;
            int right=n-1;
            int target2=target3-nums[j];
            
            while(left<right){
                int sum=nums[left]+nums[right];
                if(sum<target2)
                    left++;
                else if(sum>target2)
                    right--;
                else{
                    List<Integer> list=new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    
                    ans.add(list);
           
                while(left<right && nums[left]==list.get(2)) ++left;
                while(left<right && nums[right]==list.get(3)) --right;
                }
            }
            while(j+1 < n &&nums[j+1]==nums[j]) 
++j;
        }
        while(i+1 < n && nums[i+1]==nums[i])
 ++i;
    }
    return ans; 
}

}
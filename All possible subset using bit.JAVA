class Solution{
    public List<List<Integer>>subsets(int[] nums){
        List<List<Integer>> L=new ArrayList<>();
        int l=nums.length;
        for(int i=0;i<(1<<l);i++)
        {
            List<Integer> lst =new ArrayList<>();
            for(int j=0; j<l; j++)
            {
                if((i&(1<<j))!=0)
                {
                    lst.add(nums[j]);
                }
            }
            L.add(lst);
        }
        return L;
    }
}
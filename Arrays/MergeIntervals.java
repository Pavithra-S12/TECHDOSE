class Solution {
public int minSubArrayLen(int target, int[] nums) {
int start=0,res=1000000007,sum=0;

for(int i=0;i<nums.length;i++) { 
sum+=nums[i]; if(sum>=target) { 
while(sum>=target && start<=i) { 
res=Math.min(res,(i+1-start)); 
if(sum>=target) sum-=nums[start++]; 
}
 } 
}
 return res==1000000007?0:res; 
} 

}
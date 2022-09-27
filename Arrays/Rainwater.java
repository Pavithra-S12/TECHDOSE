class Solution {
    public int trap(int[] height) {
 int lm=height[0],rm=height[height.length-1];
 int l=1,r=height.length-2;
 int sum=0;
 while(l<=r)
 { 
  if(lm<rm)
  { 
   if(height[l]>=lm)
   lm=height[l];
   else 
   sum=sum+lm-height[l];
   l++;
   }    
   else
   { 
     if(height[r]>=rm)
      rm=height[r];
     else 
      sum=sum+rm-height[r];
       r--;
   }    
 }
        return sum;
    }
}

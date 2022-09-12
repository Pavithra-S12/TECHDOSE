class Solution{
    public int[] countBits(int a){
        int[]arr=new int[a+1];
        int b=0;
        for(int i=0; i<=a;i++)
        {
            arr[b++]=Integer.bitCount(i);
        }
        return arr;
    }
}
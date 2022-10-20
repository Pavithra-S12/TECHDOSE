class Solution {
    public int minimumRecolors(String b, int k) {
        int res=k+1;
        for(int i=0;i<=b.length()-k;i++){
            String a=b.substring(i,i+k);
            int m=a.split("W",-1).length-1;
            res=Math.min(m,res);
        }return res;
    }
}

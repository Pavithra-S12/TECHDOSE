class Solution {
    public String longestDupSubstring(String s) {
        int left=1,right=s.length();
        long mod=Long.MAX_VALUE/26;
        String ans="";
        while(left<=right){
            Set<Long> set = new HashSet<>();
            int mid=left+(right-left)/2,flag=0;
            long hash=0,p=1;
            for(int i=0;i<mid;i++){
                hash=(26*hash+(s.charAt(i)-'a'))%mod;
                p=(p*26)%mod;
            }
            set.add(hash);
            for(int i=0;i+mid<s.length();i++){
                hash=(hash*26+(s.charAt(i+mid)-'a')-((s.charAt(i)-'a')*p))%mod; 
                if(hash<0) hash+=mod; 
                if(set.contains(hash)){
                    flag=1;
                    ans=s.substring(i+1,i+mid+1);
                    break;
                }
                set.add(hash);
            }
            if(flag==1){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return ans;
    }
}

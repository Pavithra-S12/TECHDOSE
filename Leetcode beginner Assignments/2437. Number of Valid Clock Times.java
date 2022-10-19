class Solution {
    public int countTime(String time) {
        int a = 1;
        int b = 1;
        int c = 1;
        int d = 1;
        if(time.charAt(0)=='?') {
            if(time.charAt(1)=='0' || time.charAt(1)=='1' || time.charAt(1)=='2' || time.charAt(1)=='3' || time.charAt(1)=='?') a = 3;
            else a = 2;
        }
        if(time.charAt(1)=='?') {
            if(time.charAt(0)=='0') b = 10;
            else if(time.charAt(0)=='1') b = 10;
            else if(time.charAt(0)=='2') b = 4;
            else if(time.charAt(0)=='?') b = 8;
 
        }
        if(time.charAt(3)=='?') {
            c = 6;
        }
        if(time.charAt(4)=='?') {
            d = 10;
        }
        
        
        return a*b*c*d;
    }
}

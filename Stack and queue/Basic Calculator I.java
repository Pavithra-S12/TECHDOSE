class Solution {
    
    int pos = 0;
    
    public int calculate(String s) {
        pos = 0;
        return solve(s);
    }
    
    public int solve(String s) {
        
        int len = s.length();
        int res = 0;
        int num = 0;
        int signNum = 1;//positive sign for start
        while(pos < len) {
            
            char cur_char = s.charAt(pos++);
            
            if(cur_char == ' ') {
                continue;
            }
            else if(isNum(cur_char)){
                num = num * 10 + cur_char-'0';
            } 
            else if(cur_char == '('){
                //pos++;
                num = solve(s);
            } 
            else if(cur_char == ')'){
                res += signNum * num;
                
                return res;
            } 
            else{
                res += signNum * num;
                signNum = cur_char == '-'?-1:1;
                num = 0;
                
            }
            
        }
        
        int ret = res + signNum * num;
        
        return ret;
    }
    
    public boolean isNum(char c){
        int a = c - '0';
        
        if(a >= 0 && a <= 9){
            return true;
        }
        return false;
    }
    
}

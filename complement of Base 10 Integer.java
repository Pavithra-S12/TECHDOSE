class Solution{
    public int bitwiseComplement(int x){
        int y=1;
        if(x==0)
        {
            return 1;
        }
        while(y<=x)
        {
            if((x&y)==0)
            {
                x=y|x;
            }
            else{
                x=y^x;
            }
            y<<=1;
        }
        return x;
    }
}
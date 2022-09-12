class Solution{
    public int rangeBitwiseAnd(int l,int r){
        int d=r-l;
        int sol=l&r;
        for(int i=0; i<=30; i++){
            if((d/(1<<i))!=0){
                sol &= ~(1<<i);
            }
        }
        return sol;
    }
}
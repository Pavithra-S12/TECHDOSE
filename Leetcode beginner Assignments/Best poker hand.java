class Solution {
    public String bestHand(int[] ranks, char[] suits) {
        
        char[] theSame = new char[suits.length];
        Arrays.fill(theSame, suits[0]);
        if(Arrays.equals(suits, theSame)){
            return "Flush";
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int n : ranks){
            map.merge(n, 1, (a,b) -> a + b);
        }
        
        if(Collections.max(map.values()) >= 3){
            return "Three of a Kind";
        }
        
        if(Collections.max(map.values()) >= 2){
            return "Pair";
        }
        
        return "High Card";
    }
}

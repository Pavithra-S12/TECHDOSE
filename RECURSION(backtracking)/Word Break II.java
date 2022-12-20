class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        
        HashSet<String> str = new LinkedHashSet<String>(wordDict); 
        boolean [] dp = new boolean[s.length()  + 1]; 
        HashMap<Integer, List<String>> dpMap = new HashMap<>(); 
        HashSet<Integer> lengths = new LinkedHashSet<Integer>();
        for(String s1 : wordDict){
            lengths.add(s1.length());
        }
        dpMap.put(0, new ArrayList<String>()); dpMap.get(0).add("");
        dp[0] = true;   str.add("");
        for(int i = 0; i < s.length(); ++i){
            for(Integer s1 : lengths){
                if(i+1 < s1) continue;
                int j = i+1 - (s1);
                String cur = s.substring(j, i+1);
                if(dp[j] && str.contains(cur)){
                    dp[i+1] = true; 
                }
            } 
        }
        if(!dp[s.length()]) return Collections.emptyList();
        for(int i = 0; i < s.length(); ++i){
            for(Integer s1 : lengths){
                if(i+1 < s1) continue;
                int j = i+1 - (s1);
                String cur = s.substring(j, i+1);
                if(dp[j] && str.contains(cur)){
                    if(!dpMap.containsKey(i+1)) {
                        dpMap.put(i+1, new ArrayList<String>());
                    }
                    for(String sb : dpMap.get(j)){  
                         dpMap.get(i+1).add(sb + (sb.isEmpty() ? "" : " ") + cur);
                    }
                    
                }
            } 
        }         
        if(!dpMap.containsKey(s.length())) return Collections.emptyList(); 
        return dpMap.get(s.length());
        
    }
}

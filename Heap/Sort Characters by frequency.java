class Solution {
    public String frequencySort(String s) {
        
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            
            if(map.containsKey(ch)==true){
                int of=map.get(ch);
                int nf=of+1;
                map.put(ch,nf);
            }
            else{
                map.put(ch,1);
            }
        }
        
    PriorityQueue<Character> pq=new PriorityQueue<Character>((a,b) -> map.get(b)-map.get(a));
        pq.addAll(map.keySet());
        StringBuilder sb=new StringBuilder();
        
        while(pq.size()>0){
           char c=pq.remove();
            
            for(int i=0;i<map.get(c);i++){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}

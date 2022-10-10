class Solution {
public int uniqueLetterString(String s) {

    Map<Character,List<Integer>> map = new HashMap<>();
    int index=0;
    int ans=0;
    for(char temp:s.toCharArray()){
            if(!map.containsKey(temp)){
                map.put(temp, new ArrayList<>());
                map.get(temp).add(-1);
            }
            map.get(temp).add(index++);
    }
    
    for(Map.Entry<Character,List<Integer>> entry:map.entrySet() ){
        List<Integer> list = entry.getValue();
        list.add(s.length());
        
    }
    
    for(Map.Entry<Character,List<Integer>> entry:map.entrySet() ){
        List<Integer> list = entry.getValue();
        int temp=0;
        for(int i=1; i<list.size()-1; i++){
            temp+=(list.get(i)-list.get(i-1))*(list.get(i+1)-list.get(i));
        }
        ans+=temp;
        
    }    
    
    return ans;
}
}
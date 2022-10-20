class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        List<List<Integer>> l = new LinkedList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<items1.length;i++){
            map.put(items1[i][0],items1[i][1]);
        }
        for(int i=0;i<items2.length;i++){
            if(map.containsKey(items2[i][0])){
                int val= map.get(items2[i][0]);
                map.put(items2[i][0], val+items2[i][1]);
            }
            else{
                map.put(items2[i][0],items2[i][1]);
            }
        }
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            l.add(Arrays.asList(entry.getKey(), entry.getValue()));
        }
         l.sort((l1, l2) -> l1.get(0).compareTo(l2.get(0)));
        return l;
    }
}

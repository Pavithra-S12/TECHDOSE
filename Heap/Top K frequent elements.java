class Solution {
   public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i:nums)
            map.put(i,map.getOrDefault(i,0)+1);
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y)->{
            int c1 = map.get(x);
            int c2 = map.get(y);
            return c2-c1;});
        pq.addAll(map.keySet());
        int[] result = new int[k];
        int i=0;
        while(!pq.isEmpty() && i<k)
            result[i++]=(int) pq.poll();
        return result;

    }
}

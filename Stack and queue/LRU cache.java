class LRUCache {
    LinkedHashMap<Integer, Integer> cache;
    int capacity;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new LinkedHashMap<Integer, Integer>();
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            cache.remove(key);
            cache.put(key, value);
        }
        else{
            cache.put(key, value);
            int size = cache.size();
            if(size>capacity){
                int oldest = cache.keySet().iterator().next();
                cache.remove(oldest);
            }
        }
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            int k = (int)cache.get(key);
            cache.remove(key);
            cache.put(key, k);
            return k;
        }
        return -1;
    }   
}

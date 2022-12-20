public class RandomizedSet {
    HashSet<Integer> set;
    public RandomizedSet() {
        set = new HashSet<>();
    }
    public boolean insert(int val) {
        return set.add(val);
    }
    public boolean remove(int val) {
        return set.remove(val);
    }
    public int getRandom() {
        int index = new Random().nextInt(set.size());
        for (int num : set) {
            if (index == 0) return num;
            index--;
        }
        return -1;
    }
}

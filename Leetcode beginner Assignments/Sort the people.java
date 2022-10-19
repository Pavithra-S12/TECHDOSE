class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int[] arr = new int[heights.length];
        ArrayList<Integer>al = new ArrayList<>();
        for(int c:heights){
            al.add(c);
        }
        int count = 0;
        for(int c:heights){
            arr[count] = c;
            count++;
        }
        count = 0;
        String[] ans = new String[names.length];
        Arrays.sort(arr);
        int temp = 0;
        for(int i=arr.length-1;i>=0;i--){
            int index = al.indexOf(arr[i]);
            ans[temp] = names[index];
            temp++;
        }
        return ans;   
    }
}

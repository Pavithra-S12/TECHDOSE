public class Solution {
    ArrayList<String> sol = new ArrayList<>();
    Map<Character, Set<Integer>> map = null;
    Set<String> dict = null;
    
    public List<String> findWords(char[][] board, String[] words) {
        dict = makeDict(words);
        map = makeIndex(words);
        System.out.println(map);
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                find(i, j, board, 0, new StringBuilder(""));
            }
        }
        return sol;
    }
    
    private void find(int row, int col, char[][] board, int posInStr, StringBuilder str){
        if (dict.contains(str.toString())){
            String found = str.toString();
            dict.remove(found);
            sol.add(found);
            return;
        }
        
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length){
            return;
        }
        
        char ch = board[row][col];
        if (!map.containsKey(ch)){
            return;
        }
        
        Set<Integer> positionsInWords = map.get(ch);
        if (positionsInWords.contains(posInStr)){
            str.append(ch);
            char temp = board[row][col];
            board[row][col] = '*';
            find(row+1, col, board, posInStr+1, str);
            find(row-1, col, board, posInStr+1, str);
            find(row, col-1, board, posInStr+1, str);
            find(row, col+1, board, posInStr+1, str);
            board[row][col] = temp;
            str.setLength(str.length() - 1);
        } 
    }
    
    Map<Character, Set<Integer>> makeIndex(String[] words){
        Map<Character, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < words.length; i++){
            String word = words[i];
            for (int j = 0; j < word.length(); j++){
                char ch = word.charAt(j);
                if (!map.containsKey(ch)){
                    map.put(ch, new HashSet<Integer>());
                }
                Set<Integer> positionsInWords = map.get(ch);
                positionsInWords.add(j);
            }
        }
        return map;
    }
    
    Set<String> makeDict(String[] words){
        HashSet<String> dict = new HashSet<String>();
        for (String s : words){
            dict.add(s);
        }
        return dict;
    }
}

public class Solution {
    public boolean exist(char[][] board, String word) {
        
        int m = board.length;
        
        if(m == 0)
        {
            return false;
        }
        
        int n = board[0].length;
        
        boolean[][] visited = new boolean[m][n];
        
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(board[i][j] == word.charAt(0))
                {
                    if(check(board, visited, i, j, 0, word, m, n))
                    {
                        return true;
                    }
                }
            }
        }
        
        return false;
        
    }
    
    public boolean check(char[][] board, boolean[][] visited, int i, int j, int index, String word, int m, int n)
    {
        visited[i][j] = true;
        
        if(board[i][j] != word.charAt(index))
        {
            visited[i][j] = false;
            return false;
        }
        
        if(index == word.length() - 1)
        {
            if(board[i][j] == word.charAt(index))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        
        boolean x = false;
        
        if(i + 1 < m && !visited[i + 1][j])
        {
            x = x || check(board, visited, i + 1, j, index + 1, word, m, n);
        }
        
        if(i - 1 >= 0 && !visited[i - 1][j])
        {
            x = x || check(board, visited, i - 1, j, index + 1, word, m, n);
        }
        
        if(j + 1 < n && !visited[i][j + 1])
        {
            x = x || check(board, visited, i, j + 1, index + 1, word, m, n);
        }
        
        if(j - 1 >= 0 && !visited[i][j - 1])
        {
            x = x || check(board, visited, i, j - 1, index + 1, word, m, n);
        }
        
        visited[i][j] = false;
        
        return x;
    }
    
}

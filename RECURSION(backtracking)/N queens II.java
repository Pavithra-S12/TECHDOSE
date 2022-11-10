class Solution {
public int totalNQueens(int n) {
  boolean[][] board = new boolean[n][n];
  return queens(board,0);
    
}
int queens(boolean[][] board,int row)
{
	if(row==board.length){
        return 1;
    }
    
    int count = 0;
    // Placing Queens and Checking for every row and column
    for(int col=0;col<board.length;col++){
        //place queen if Safe
        if(isSafe(board,row,col)){
            board[row][col] = true;
            count += queens(board,row+1); //Recursive call
            board[row][col] = false;    // Backtrack
        }
    }
    return count;
}

boolean isSafe(boolean[][] board, int row ,int col){
    
    // Vertical row
    for(int i=0;i<row;i++){
        if(board[i][col])
            return false;
    }
    
    // Left diagonal
    int maxLeft = Math.min(row,col);
    for(int i=1;i<=maxLeft;i++){
        if(board[row-i][col-i]){
            return false;
        }
    }
    
    // Right diagonal
    int maxRight = Math.min(row,board.length-col-1);
    for(int i=1;i<=maxRight;i++){
        if(board[row-i][col+i]){
            return false;
        }
    }
    return true;
}
}


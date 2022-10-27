void dfs(int ** grid, int row, int col, int x, int y, int minutes)
{
    if(x<0 || x>=row || y<0 || y>=col || grid[x][y] == 0)
        return;
    if(grid[x][y] == 1 || grid[x][y] >= minutes)
    {
        grid[x][y] = minutes;
        dfs(grid, row, col, x+1, y, minutes+1);
        dfs(grid, row, col, x-1, y, minutes+1);
        dfs(grid, row, col, x, y-1, minutes+1);
        dfs(grid, row, col, x, y+1, minutes+1);
    }
}

int orangesRotting(int** grid, int gridSize, int* gridColSize){
    for(int i=0; i<gridSize; i++)
        for(int j=0; j<*gridColSize; j++)
            if(grid[i][j] == 2)
                dfs(grid, gridSize, *gridColSize, i, j, 2);
    int min = 2;
    for(int i=0; i<gridSize; i++)
        for(int j=0; j<*gridColSize; j++)
            if(grid[i][j] == 1)
                return -1;
            else
                min = min < grid[i][j] ? grid[i][j] : min;
    return min-2;   
}

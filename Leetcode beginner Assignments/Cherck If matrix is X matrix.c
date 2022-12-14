bool checkXMatrix(int** grid, int gridSize, int* gridColSize){
    *gridColSize = gridSize;
    for (int i = 0; i < gridSize; i++) 
    {
        for (int j = 0; j < gridSize; j++)
        {
            if (i != j && (i + j) != gridSize - 1)
            {
                if (grid[i][j]) return false;
            }
            else if (!grid[i][j]) return false;
        }
    }
    return true;
}

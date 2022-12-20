public boolean isValidSudoku(char[][] board) {
    for (int i = 0; i < 9; i++) {
        int v0 = 0, v1 = 0, v2 = 0;
        for (int j = 0; j < 9; j++) {
            if (board[i][j] != '.') {
                int k0 = board[i][j] - '0';
                if ((v0 & (1 << k0)) > 0) {
                    return false;
                }
                v0 |= (1 << k0);
            }
            
            if (board[j][i] != '.') {
                int k1 = board[j][i] - '0';
                if ((v1 & (1 << k1)) > 0) {
                    return false;
                }
                v1 |= (1 << k1);
            }

            int ci = i / 3 * 3 + j / 3;                           
            int cj = (i % 3) * 3 + j % 3;
            if (board[ci][cj] != '.') { 
                int k2 = board[ci][cj] - '0';
                if ((v2 & (1 << k2)) > 0) {
                    return false;
                }
                v2 |= (1 << k2);
            }
        }
    }
    return true;
}

public class Solution {
  public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length==0) return res;
        int minLevel = Math.min(matrix.length,matrix[0].length);
        for(int level=1;level<=minLevel;level++){
            spiralOrderAtLevel(matrix,level,res);
        }
        return res;
    }
    private void spiralOrderAtLevel(int[][]matrix,int level,List<Integer> res){
        int beginRow = level-1;
        int endRow = matrix.length-level;
        int beginTable = level-1;
        int endTable = matrix[0].length-level;
        if (beginRow>endRow||beginTable>endTable) return;
        // left to right
        for(int tmpTable=beginTable;tmpTable<=endTable;tmpTable++){
            res.add(matrix[beginRow][tmpTable]);
        }
        //top to bottom
        for(int tmpRow=beginRow+1;tmpRow<=endRow;tmpRow++){
            res.add(matrix[tmpRow][endTable]);
        }
        if (beginRow == endRow||beginTable==endTable) return ;
        //right to left
        for(int tmpTable = endTable-1;tmpTable>=beginTable;tmpTable--){
            res.add(matrix[endRow][tmpTable]);
        }
        // bottom to top
        for(int tmpRow = endRow-1;tmpRow>beginRow;tmpRow--){
            res.add(matrix[tmpRow][beginRow]);
        }
    }


}

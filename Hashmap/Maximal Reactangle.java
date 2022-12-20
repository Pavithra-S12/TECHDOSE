class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int[] arr = new int[matrix[0].length];
        Arrays.fill(arr, 0);
        int max = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == '0') arr[j] = 0;
                if(matrix[i][j] == '1') arr[j] += 1;
            }
            max = Math.max(max, findMax(arr));
        }
        return max;
    }
    
    class Data {
        public int height;
        public int width;
        public Data(int height, int width) {
            this.height = height;
            this.width = width;
        }
    }
    
    int findMax(int[] arr) {
        Stack<Data> stack = new Stack<>();
        int max = 0;
        for(int i = 0; i < arr.length; i++) {
            if(stack.empty() || arr[i] > stack.peek().height)
                stack.push(new Data(arr[i], 1));
            else {
                int width = 0;
                while(!stack.empty() && arr[i] <= stack.peek().height) {
                    Data data = stack.pop();
                    width = data.width + width;
                    max = Math.max(max, data.height * width);
                }
                max = Math.max(max, arr[i] * (width + 1));
                stack.push(new Data(arr[i], width + 1));
            }
        }
        
        int width = 0;
        while(!stack.empty()) {
            Data data = stack.pop();
            width = data.width + width;
            max = Math.max(max, data.height * width);
        }
        return max;
    }
}

#define MAX(a,b) (((a)>(b))?(a):(b))

int largestRectangleArea(int* heights, int heightsSize){
    int area = 0;
    int* stack = (int*)malloc(heightsSize*sizeof(int));
    int index = -1; // len(stack)
    for (int i = 0; i < heightsSize; i++){
        int peak = (index>-1)? heights[stack[index]]: 0;
        // stack is empty, or stack.peak() <= heights[cur], push cur index
        if (index == -1 || peak <= heights[i]){
            stack[++index] = i;
        } else { //found the right bound
            int right = i;
            int height = heights[stack[index]];
            while (index >= 1 && height == heights[stack[index-1]]){
                index--;
            }
            index--;
            int left = (index<0)?-1:stack[index];
            area = MAX(area, (right - left - 1) * height);
            i--; 
        }
    }   
    // 2 3 4
    int right = stack[index]+1;
    while (index>-1){     
        int left = (index<=0)?(-1):stack[index - 1];
        int height = heights[stack[index]];
        area =  MAX(area, (right - left - 1) * height);
        index--;
    }
    stack = NULL;
    free(stack);
    return area;
}

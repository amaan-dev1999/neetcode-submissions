class Solution {
    public int maxArea(int[] heights) {
        int area = 0;
        int start = 0;
        int end = heights.length-1;

        while(start<end){
            int currentArea = Math.min(heights[start], heights[end]) * (end-start);
            int biggerIndex = heights[start]>= heights[end] ? start: end;
            if(currentArea>area){
                area=currentArea;
            }
            if(biggerIndex==start){
                end--;
            }else {
                start++;
            }
        }

        return area;
    }
}

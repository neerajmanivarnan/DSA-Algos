class Solution {
    public int maxArea(int[] height) {
        int result = 0;
        int left = 0;
        int right = height.length-1;

        while(left<right){
                int heightTo = Math.min(height[left],height[right]);
                int width =  (right-left);
                int area = heightTo*width;
                result = Math.max(result,area);
                if(height[left] < height[right]){
                        left+=1;
                        
                }else{
                        right-=1;
                }

        }

        return result;

        

        

    }
}

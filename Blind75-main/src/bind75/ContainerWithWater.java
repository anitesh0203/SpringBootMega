package bind75;

public class ContainerWithWater {


    public int maxArea(int[] height) {

        int area = Math.min(height[0], height[height.length-1]) * (height.length-1);
        int start = 0;
        int end = height.length-1;
        while (end > start) {
            if(height[start]<height[end]) {
                int tempArea = Math.min(height[start+1], height[end]) * (end-(start+1));
                if(tempArea>area) {
                    area = tempArea;
                }
                start ++;

            }else {
                int tempArea = Math.min(height[start], height[end-1]) * ((end-1)-start);
                if(tempArea>area) {
                    area = tempArea;
                }
                end --;

            }
        }
        return area;
    }

    public static void main(String[] args) {
        ContainerWithWater containerWithWater = new ContainerWithWater();
        int[] heights = {2,3,10,5,7,8,9} ;
        containerWithWater.maxArea(heights);
    }
}

import java.util.Stack;

public class trappingRainWater {
    public static int trap(int[] height) {
        int leftmax=height[0];
        Stack<Integer> rightmax = new Stack();
        rightmax.push(height[height.length-1]);
        for(int i=height.length-2;i>=2;i--){
            int temp=Math.max(rightmax.peek(),height[i]);
            rightmax.push(temp);
        }

        int totwater=0;
        for(int i=1;i<height.length-1;i++){
            int mini = Math.min(rightmax.peek(),leftmax);
            int temp=mini-height[i];
            totwater+=Math.max(0,temp);
            rightmax.pop();
            leftmax=Math.max(leftmax,height[i]);
        }

        return totwater;
    }
    public static void main(String[] args) {
        int height[]={1,2,5,2,6,7,8};
        System.out.println(trap(height));


    }
}


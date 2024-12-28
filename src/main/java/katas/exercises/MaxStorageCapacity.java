package katas.exercises;

import java.util.Arrays;
import java.util.Stack;

public class MaxStorageCapacity {

    /**
     *
     * Imagine a series of storage containers placed side by side, where the height of each container
     * is given by an integer in the array. Your task is to find the largest rectangular area that
     * can be formed using one or more of these containers.
     *
     * For example:
     * Input: containers = [2, 1, 5, 6, 2, 3]
     * Output: 10
     * Explanation: The largest rectangle is formed between containers at indices 2 and 3
     * with height 5 and width 2.
     *
     * @param containers an array of integers representing the heights of containers
     * @return the area of the largest rectangle formed between containers
     */
//    public static int maxStorageArea(int[] containers) {
//        if (containers.length==0)
//            return 0;
//        int maxArea=0,cnt=0,res=0,subRes=0,flag=0;
//        for(int i =0 ; i<containers.length;i++)
//        {
//            if(i==0){
//                maxArea=containers[i];
//                cnt++;}
//            else
//            {
//                if(maxArea>containers[i]){
//                    res=cnt*maxArea;
//                    if(flag==1)
//                        return Math.max(res,subRes);
//                    else {
//                        flag=1;
//                        cnt++;
//                        int[] arr= Arrays.copyOfRange(containers,i,containers.length);
//                        subRes=maxStorageArea(arr)+cnt*containers[i+1];
//                        System.out.println(subRes+","+cnt*containers[i+1]);
//                        return Math.max(subRes,res);
//                    }
//                }
//                else
//                {
//                    if(maxArea<containers[i] && flag==0){
//                        flag=1;
//                        int[] arr= Arrays.copyOfRange(containers,i,containers.length);
//                        subRes=maxStorageArea(arr);}
//                    cnt++;
//                }
//            }
//        }
//        res=cnt*maxArea;
//        return Math.max(res,subRes);
//    }
    public static int maxStorageArea(int[] containers) {
        // Stack to store indices of histogram bars
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0; // Variable to store the maximum area
        int n = containers.length;

        // Traverse the array
        for (int i = 0; i < n; i++) {
            // While the current bar is smaller than the bar at stack's top
            while (!stack.isEmpty() && containers[i] < containers[stack.peek()]) {
                // Pop the top of the stack
                int height = containers[stack.pop()];
                // Width is calculated based on stack's top
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                // Calculate area and update maxArea
                maxArea = Math.max(maxArea, height * width);
            }
            // Push the current index onto the stack
            stack.push(i);
        }

        // Process remaining bars in the stack
        while (!stack.isEmpty()) {
            int height = containers[stack.pop()];
            int width = stack.isEmpty() ? n : n - stack.peek() - 1;
            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }
    public static void main(String[] args) {
        int[] containers = {2, 1, 6, 6, 2, 2};

        int result = maxStorageArea(containers);
        System.out.println("Max storage area: " + result); // Expected output: 10
    }
}

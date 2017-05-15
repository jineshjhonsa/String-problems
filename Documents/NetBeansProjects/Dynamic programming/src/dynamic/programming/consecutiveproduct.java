/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamic.programming;

/**
 *
 * @author Jinesh
 */
public class consecutiveproduct {
    public static void maxproduct(){
          int[] nums = {2,3,-2,4};
             int[] max = new int[nums.length];
    int[] min = new int[nums.length];
 
    max[0] = min[0] = nums[0];
    int result = nums[0];
    
    for(int i =1; i<nums.length;i++){
        
        if(nums[i]>0){
            max[i] = Math.max(nums[i],max[i-1]*nums[i]);
            min[i] = Math.min(nums[i], min[i-1]*nums[i]);
            }else{
            max[i] = Math.max(nums[i],min[i-1]*nums[i]);
            min[i] = Math.min(nums[i], max[i-1]*nums[i]);
        }
       
       result = Math.max(max[i], result);
    }
  
        System.out.println("Answer is "+  result);
    }
}

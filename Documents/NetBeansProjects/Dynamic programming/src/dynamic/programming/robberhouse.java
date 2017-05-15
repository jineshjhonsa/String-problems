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
public class robberhouse {
    
    public static void linear(){
         int[] nums = {1,5,1,6,8,0,1,3};
        if(nums==null||nums.length==0)
        return ;
 
    if(nums.length==1)
        return ;
 
    int[] dp = new int[nums.length];
    dp[0]=nums[0];
    dp[1]=Math.max(nums[0], nums[1]);
 
    for(int i=2; i<nums.length; i++){
        dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
    }
 
    System.out.println(dp[nums.length-1]); 
    }
    
}

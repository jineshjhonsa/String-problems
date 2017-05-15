/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamic.programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Jinesh
 */
public class DynamicProgramming {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
        
        
      int  prices[] = {7,5,3,4,1};
      
      canPartition(prices);
       int maxProfit = 0;
    for(int i = 1; i < prices.length; i++){
        if(prices[i]>prices[i-1]) maxProfit += prices[i] - prices[i-1];
    }
    
 
        System.out.println(maxProfit);

    }
    
    public static boolean isValid(String s){
    if(s.charAt(0)=='0')
        return false;
    int value = Integer.parseInt(s);
    return value>=1&&value<=26;
}
    
      public static boolean canPartition(int[] nums) {
        // check edge case
        if (nums == null || nums.length == 0) {
            return true;
        }
        // preprocess
        int volumn = 0;
        for (int num : nums) {
            volumn += num;
        }
        if (volumn % 2 != 0) {
            return false;
        }
        volumn /= 2;
        // dp def
        boolean[] dp = new boolean[volumn + 1];
        // dp init
        dp[0] = true;
        // dp transition
        for (int i = 1; i <= nums.length; i++) {
            for (int j = volumn; j >= nums[i-1]; j--) {
                dp[j] = dp[j] || dp[j - nums[i-1]];
            }
        }
        return dp[volumn];
    }
}


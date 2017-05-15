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
public class uniquepath {
    public static void uniquepath(){
        
            int m = 3;
        int n =3;
                
if(m==0 || n==0) return ;
    if(m==1 || n==1) return ;
 
    int[][] dp = new int[m][n];
 
    //left column
    for(int i=0; i<m; i++){
        dp[i][0] = 1;
    }
 
    //top row
    for(int j=0; j<n; j++){
        dp[0][j] = 1;
    }
 
    //fill up the dp table
    for(int i=1; i<m; i++){
        for(int j=1; j<n; j++){
            dp[i][j] = dp[i-1][j] + dp[i][j-1];
        }
    }
 
    System.out.println(dp[m-1][n-1]);
    }
    
}

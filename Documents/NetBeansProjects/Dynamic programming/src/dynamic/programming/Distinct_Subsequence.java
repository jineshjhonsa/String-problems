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
public class Distinct_Subsequence {
    
    public static void directsubsequence(){
        String s ="rabbit";
              String t = "r"; 
              
        int m = s.length(), n = t.length();
        int[][] C = new int[m+1][n+1];
        for(int i=0;i<=m;i++) C[i][0] = 1;
        for(int i=1;i<=m;i++) {
            for(int j=1;j<=n;j++) {
                C[i][j] = C[i-1][j];
                if(s.charAt(i-1)==t.charAt(j-1)) C[i][j]+=C[i-1][j-1];
            }
        }
        System.out.println("Distinct subsequence is "+C[m][n]);
    
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamic.programming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Jinesh
 */
public class wordbreak {
    public static void simple(){
         String s = "leetdodec";
       Set<String> wordDict = new HashSet();
       wordDict.add("leet");
        wordDict.add("code");
       wordDict.add("c");
        int[] pos = new int[s.length()+1];
 
    Arrays.fill(pos, -1);
 
    pos[0]=0;
 
    for(int i=0; i<s.length(); i++){
        if(pos[i]!=-1){
            for(int j=i+1; j<=s.length(); j++){
                String sub = s.substring(i, j);
                if(wordDict.contains(sub)){
                    pos[j]=i;
                }
            } 
        }
    }
    
    boolean y = pos[s.length()]!=-1;
  System.out.println("Answer is "+ y);
    }
    
    public static void wordbreakdynamic(){
         String s = "leetcode";
       Set<String> dict = new HashSet();
       dict.add("leet");
        dict.add("code");
       dict.add("c");
        // TODO code application logic here
        boolean[] t = new boolean[s.length()+1];
        t[0] = true; //set first to be true, why?
        //Because we need initial state
 
        for(int i=0; i<s.length(); i++){
            //should continue from match position
            if(!t[i]) 
                continue;
 
            for(String a: dict){
                int len = a.length();
                int end = i + len;
                if(end > s.length())
                    continue;
 
                if(t[end]) continue;
 
                if(s.substring(i, end).equals(a)){
                    t[end] = true;
                }
            }
        }
 
        
           System.out.println("Answer is "+  t[s.length()]);
    }
}

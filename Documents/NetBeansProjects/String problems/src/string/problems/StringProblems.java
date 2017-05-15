/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package string.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author Jinesh
 */
public class StringProblems {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       // String s="ffwacdadeqb";
       // String  p = "*c*b";
      // longestsubstring();
      
      System.out.println(data("\".//*[@id='viewport']/div[3]/div/div[3]/div/div[1]/div/div/ul/li[1]/div[1]/ul/li[1]/a\""));
        String s ="abcdedpqrastuaabcabcbb";
    // minWindow("aadobbecodebanc","abc");
      //  System.out.println("ans is "+validparanthesis("((he)(llo)()"));
       // diffWaysToCompute("2*3-4*5");
    //   System.out.print(LongestSubstring(s));//edpqrast
        
    }
    
   /*   //.//*[@id='viewport']/div[3]/div/div[3]/div/div[1]/div/div/ul/li[1]/div[1]/ul/li[1]/a
                String x =doc.select("#viewport>div:eq(3)>div>div:eq(2)>div>div:eq(0)>div>div>ul>li:eq(0)>div:eq(0)>ul>li:eq(0)>a").attr("href");*/
    private static String data(String x){
        StringBuilder sb = new StringBuilder();
       String y  =  x.substring(x.indexOf("'")+1);
       String id = y.substring(0,y.indexOf("'"));
       String z = y.substring(y.indexOf("'")+3,y.length()-1);
       sb.append("#"+id);
      
            String[] d = z.split("/");
            for(int i=0; i<d.length;i++){
                String a = d[i];
               if(a.contains("[")){
                   String c = a.substring(0,a.indexOf("["));
                   String b = a.substring(a.indexOf("[")+1,a.indexOf("]"));
                   Integer o = Integer.valueOf(b)-1;
                   sb.append(">"+c+":eq("+o+")");
               }else{
                   sb.append(">"+a);
               }
            }
       
       
        
        return sb.toString();
    }
    
public static String minWindow(String s, String t) {
    if(s == null || s.length() < t.length() || s.length() == 0){
        return "";
    }
    HashMap<Character,Integer> map = new HashMap<Character,Integer>();
    for(char c : t.toCharArray()){
        if(map.containsKey(c)){
            map.put(c,map.get(c)+1);
        }else{
            map.put(c,1);
        }
    }
    int left = 0;
    int minLeft = 0;
    int minLen = s.length()+1;
    int count = 0;
    for(int right = 0; right < s.length(); right++){
        if(map.containsKey(s.charAt(right))){
            map.put(s.charAt(right),map.get(s.charAt(right))-1);
            if(map.get(s.charAt(right)) >= 0){
                count ++;
            }
            while(count == t.length()){
                if(right-left+1 < minLen){
                    minLeft = left;
                    minLen = right-left+1;
                }
                if(map.containsKey(s.charAt(left))){
                    map.put(s.charAt(left),map.get(s.charAt(left))+1);
                    if(map.get(s.charAt(left)) > 0){
                        count --;
                    }
                }
                left ++ ;
            }
        }
    }
    if(minLen>s.length())  
    {  
        return "";  
    }  
    System.out.println(s.substring(minLeft,minLeft+minLen));
    return s.substring(minLeft,minLeft+minLen);
}
    
    
    
   /* public static void longestsubstring(String s,String t){
        HashMap<Character,Integer> map = new HashMap();
         HashMap<Character,Integer> rmap = new HashMap();
         for(int i =0;i<t.length();i++){
            char c = t.charAt(i);
            if(map.containsKey(c) && rmap.get(c)>map.get(c)){
                map.put(c,map.get(c)+1);
            }else map.put(c,1);
            
        }
          for(int i =0;i<t.length();i++){
            char c = t.charAt(i);
            if(rmap.containsKey(c)){
                rmap.put(c,rmap.get(c)+1);
            }else rmap.put(c,1);
            
        }
          boolean flag =true;
          int min= Integer.MAX_VALUE;
          int j=0;
          int k = 0;
          int left =0;
          int right =0;
          for(int i =0;i<s.length();i++){
              char c = s.charAt(i);
              if(map.containsKey(c)){
                  rmap.put(c, rmap.get(c)+1);
              }else rmap.put(c, 1);
              
              if(flag){
                  if(rmap.containsKey(c)){
                      rmap.put(c, rmap.get(c)-1);
                      if(rmap.get(c)==0)rmap.remove(c);
                  }
                  if(rmap.size()==0){
                      left =j;
                      right =i;
                      min = Math.min(min, i-j+1);
                      j=i+1;
                      flag = false;
                  }
              }else{
                  
                 if(map.containsKey(c)){
                     rmap.put(c, rmap.get(c)+1);
                 }
                  if(map.get(c)<rmap.get(c)){
                      while()
                  }
                  
              }
         
          }
    }*/
       public static int longestSubstringKelement(String s, int k) {
        HashMap<Character,Integer> map = new HashMap();
        for(int i =0;i<s.length();i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else map.put(c,1);
            
        }
        int j =0;
        int max =0;
        int left =0;
        int right =0;
        int i = 0;
        while(i<s.length()){
            char d = s.charAt(i);
             int temp =i-j;
             if(map.get(d)>=k){
                 if(max<(i-j)){
                    max =i-j;
                    left =j;
                    right =i;
                }
             }
            if(map.get(d)<k){
                
                while(j<=i){
                    char e =s.charAt(j);
                    map.put(e, map.get(e)-1);
                    j++;
                }
               
            }else if(map.get(d)>=k && i==s.length()-1){
                max = s.length();
            }
            
            i++;
           
        }
        System.out.println("max is "+max+ "string is "+s.substring(left,right));
        return max;
       }
     public static List<Integer> diffWaysToCompute(String input) {
        if (input.isEmpty())
            return null;
        return diffWaysToCompute(input, 0, input.length()-1);
    }
   static boolean  isOprator(char ch) {
        return ch == '+' || ch == '-' || ch == '*';
    }
    private static int cal(int left, int right, char operator) {
        if (operator == '+') {
            return left + right;
        } else if (operator == '-') {
            return left - right;
        } else {
            return left * right;
        }
    }
    //2*3-4*5
    public static List<Integer> diffWaysToCompute(String input, int L, int R) {
        List<Integer> all = new ArrayList<Integer>();
        List<Integer> left;
        List<Integer> right;
        for (int i = L; i <= R; i++) {
            if (isOprator(input.charAt(i))) {
                left = diffWaysToCompute(input, L, i-1);
                right = diffWaysToCompute(input, i+1, R);
                for (int l : left) {
                    for (int r : right) {
                        all.add(cal(l, r, input.charAt(i)));
                    }
                }
            }
        }
        if (all.size() == 0) {
            all.add(Integer.parseInt(input.substring(L, R+1)));
        }
        return all;
    }
     public static int LongestSubstring(String s){
         int left =0, right =0;
               if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
             //   j = Math.max(j,map.get(s.charAt(i))+1);
             j= map.get(s.charAt(i))+1;
            }
            map.put(s.charAt(i),i);
          //  max = Math.max(max,i-j+1);
            if(max<(i-j+1)){
                max = i-j+1;
                left =j;
                right =i;
            }
            
        }
        System.out.println(s.substring(left,right));
        return max;
         
     }
    public static int lengthOfLongestSubstring(String s) {
    if(s==null || s.length()==0){
        return 0;
    }
    
    
 int sign =0;
    int start=0;
    int max = 0;
    int left =0;
    int right =0;
 
    HashSet<Character> set = new HashSet<Character>();
    for(int i=0; i<s.length(); i++){
        char c = s.charAt(i);
 
        if(!set.contains(c)){
            set.add(c);
            sign = max;
            max = Math.max(max, i-start+1);
            if(max>sign){
                left =start;
                right =i;
            }
        }else{
            for(int j=start; j<i; j++){
                set.remove(s.charAt(j));
 
                if(s.charAt(j)==c){
                    start=j+1;
                    break;    
                }
            }        
 
            set.add(c);
        }
    }
    System.out.println(s.substring(left,right));
    return max;
}
    public static boolean isValidParantheses(String s) {
	HashMap<Character, Character> map = new HashMap<Character, Character>();
	map.put('(', ')');
	map.put('[', ']');
	map.put('{', '}');
 
	Stack<Character> stack = new Stack<>();
 
	for (int i = 0; i < s.length(); i++) {
		char curr = s.charAt(i);
 
		if (map.keySet().contains(curr)) {
			stack.push(curr);
		} else if (map.values().contains(curr)) {
			if (!stack.empty() && map.get(stack.peek()) == curr) {
				stack.pop();
			} else {
				return false;
			}
		}
	}
 
	return stack.empty();
}
    
    
  public static String validparanthesis(String s){
      
      StringBuilder sb = new StringBuilder();
      int count =0;
      for(int i =0;i<s.length();i++){
          char c = s.charAt(i);
          if(c=='('){
              sb.append(c);
              count++;
          }
          else if(c == ')')
          {
              sb.append(c);
              count--;
          }
          else sb.append(c);
          if(count<0){
              count++;
              sb.deleteCharAt(sb.length()-1);
              
          }
      }
      int j = sb.length()-1;
      while(count>0 && j>=0){
          if(sb.charAt(j)=='('){
              sb.deleteCharAt(j);
              count--;
          }
          j--;
          
      }
      return sb.toString();
  }
    
    
  public static int lengthOfLongestSubstringTwoDistinct(String s) {
    int max=0;
    HashMap<Character,Integer> map = new HashMap<Character, Integer>();
    int start=0;
 
    for(int i=0; i<s.length(); i++){
        char c = s.charAt(i);
        if(map.containsKey(c)){
            map.put(c, map.get(c)+1);
        }else{
            map.put(c,1);
        }
 
        if(map.size()>2){
            max = Math.max(max, i-start);
 
            while(map.size()>2){
                char t = s.charAt(start);
                int count = map.get(t);
                if(count>1){
                    map.put(t, count-1);
                }else{
                    map.remove(t);
                }
                start++;
            }
        }
    }
 
    max = Math.max(max, s.length()-start);
 
    return max;
} 
  
   public static  boolean isMatch(String s, String p) {
	int i = 0;
	int j = 0;
	int starIndex = -1;
	int iIndex = -1;
 
	while (i < s.length()) {
		if (j < p.length() && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
			++i;
			++j;
		} else if (j < p.length() && p.charAt(j) == '*') {
			starIndex = j;		
			iIndex = i;
			j++;
		} else if (starIndex != -1) {
			j = starIndex + 1;
			i = iIndex+1;
			iIndex++;
		} else {
			return false;
		}
	}
 
	while (j < p.length() && p.charAt(j) == '*') {
		++j;
	}
 
	return j == p.length();
}
   
   public static int majorityElement(int[] nums) {
    int result = 0, count = 0;
 
    for(int i = 0; i<nums.length; i++ ) {
        if(count == 0){
            result = nums[ i ];
            count = 1;
        }else if(result == nums[i]){
           count++;
        }else{
           count--;
        }
    }
 
    return result;
}

}

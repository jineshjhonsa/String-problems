 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sorting;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Jinesh
 */
public class Sorting {
    
  private static  Integer b[] = {6,7,1,9,6,45,87,4,11};
   private static  Integer c[] = {2,1};
  private static  String a[] = {"shell","by","are"
     /* "sea","shells","shore","sells","surely"*/};

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         // int a[] = {7,1,6,8 ,10,45,87,4};
         System.out.println("a is "+ Arrays.toString(b));
    Integer y =  Quickselect(c,2);
   System.out.println("elem is "+ y);
       // stringthreewayquick(a);
    //  mergesort(b);
   //      System.out.println("elem is "+ elem);
   // threewayQuicksort(b,0,b.length-1);
      show(b);
        // TODO code application logic here    }
    
    } 
    /* Selection sort
    
    1. Compare first element with rest of the element and find the minimum.
    2. After finding the minimum, exchange with first element.
    3. Iterate the procedure with rest of the element.
    
    Comment
    Running time insensitive to input: Quadratic time even if it is sorted.
    Data movement is minimal: Linear number of exchanges.
    
    */
     public static void Selection(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i+1; j < N; j++) {
                if (less(a[j], a[min])) min = j;
            }
            exch(a,i, min);
            
        }
       
    }
      /* Insertion sort
    
    1. Compare first and second element and swap if second element is less than  first element
    2. if not then break.
     3. do this for all the element 
    Comment
Best Case: If array is in ascending order, insertion sort makes N-1 compare and 0 exchange
     Worst Case: If array is in Descending order, insertion sort makes 1/2 N^2 compare and .5N^2 exchange
    */
     public static void Insertion(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
        
            for (int j = i; j >0; j--) {
                if (less(a[j], a[j-1])) exch(a,j,j-1);
                else break;
            }
            
      
        }
       
    }
     
    /*
     Shell sort is reduces number of exchanges by sorting  larger differences firat and then going to smaller differences
     */ 
     
     
        public static void Shellsort(Comparable[] a) {
       int N = a.length;

        // 3x+1 increment sequence:  1, 4, 13, 40, 121, 364, 1093, ... 
        int h = 1;
        while (h < N/3) h = 3*h + 1; 
          System.out.println("value of h set is "+h);
        while (h >= 1) {
            // h-sort the array
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j-h]); j -= h) {
                    exch(a, j, j-h);
                }
            }
          
            h = h/ 3;
            System.out.println("value of h is "+h);
        }
       
    }
       /*
        Quicksort is a sorting algorithm 
        1. take the first element of the array and compare i with first element and j with first element
        2. First element should be greater than i th element and less than jth element if not than exchange
        ith element with jth element 
        3. 
        
        */
        public static void Quicksort(Comparable[] b,int low, int high){
            
         if (high <= low) return;
        int j = partition(b, low, high);
        Quicksort(b, low, j-1);
        Quicksort(b, j+1, high);
        }
        
        public static Integer Quickselect(Comparable[] b, int k){
            int lo =0;
            int hi =b.length -1;
            while(hi>lo){
              int  j = partition(b, lo, hi);
                if(j<k)hi = j-1;// look into left part
                if(j>k)lo = j+1;// look into right part
                else return (Integer) b[k];
            }
               return (Integer) b[k];
        }
      public static int partition(Comparable[] b,int low, int high){
       
          int j = high+1;// adding 1 because we are using --j in while loop
          int i =low;
          while(true){

              while(less(b[++i],b[low]))if(i==high)break;//first increment i and then compare with low element
              while(less(b[low],b[--j]))if(j==low)break; // first decrement j and then compare with low element
           
               if(i>=j)break;// always compare i and break when it is gretaer or equal to j
                 exch(b,i,j);
               System.out.println("Array is "+Arrays.toString(b)+" and i is "+i+"and j is "+j);
          }
         exch(b,low,j);// since j is less than i exchange
         
              System.out.println("final partition exchange Array is "+Arrays.toString(b)+" and i is "+i+"and j is "+j);
         return j;
      }
     /*
        
        Divide and Conquer method. In this method we divide the input into two parts
        
        comements: upper and lower bound is NlogN
        */
    public static void mergesort(Comparable[] a) {
     
    
        Comparable aux[] = new Comparable[a.length];
      
      
       sort(a, aux,0,a.length-1);
    
       
    }
     
            private static void sort(Comparable[] a, Comparable[] aux, int low, int high) {
                 System.out.print("sort is "+Arrays.toString(aux)+"with low as"+ low+ " and high as" +high+"\n");
          if (high <= low){
              System.out.print("sort is "+Arrays.toString(aux)+"with low as"+ low+ " and high as" +high+"returned back.\n");
          
              return;
          }
           int mid = low +(high - low)/2;
           
             sort(a,aux,low,mid);
             sort(a,aux,mid+1,high);
             merge(a,aux,low,mid,high);
             
//To change body of generated methods, choose Tools | Templates.
    }

    private static void merge(Comparable[] a, Comparable[] aux, int low, int mid, int high) {
     for(int k=low; k<=high;k++)
     {
         aux[k] = a[k];
        
     }
      System.out.print("aux is "+ Arrays.toString(aux));
      System.out.println("");
//To change body of generated methods, choose Tools | Templates.
               int i = low;
               int j= mid +1;
               for( int k =low;k<=high;k++){
                   if(i>mid) a[k]=aux[j++];
                  else if(j>high)   a[k]=aux[i++];
                     else  if(less(aux[j],aux[i])) a[k]= aux[j++];
                     else a[k]= aux[i++];
               }
        
    }
    
    private static void threewayQuicksort(Comparable[] a,int low,int high){
    /*  int  lo=low;
       int hi =high;
        
         if (hi <= lo) return;
        int lt = lo, gt = hi;
        Comparable v = a[lo];
        int i = lo;
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if      (cmp < 0) exch(a, lt++, i++);
            else if (cmp > 0) exch(a, i, gt--);
            else              i++;
        }*/
        
 if(low>=high) return;
        int lt=low;
        int gt = high;

       
        int i = low;
           
        while(i<=gt){
            
            int cmp = a[i].compareTo(a[lt]);
            if(cmp<0)exch(a,i++,lt++);
            else if(cmp>0)exch(a,i,gt--);
            
            else i++;
            show(a);         
            System.out.println();
        }
        threewayQuicksort(a,low,lt-1);
        threewayQuicksort(a,gt+1,high);
        
        
    }
     private static boolean less(Comparable  v, Comparable  w) {
     
         return v.compareTo(w)<0;
    }
        private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
           System.out.print(a[i]+",");
        }
    
}
        
         private static void exch(Comparable[] a,int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

public static void stringthreewayquick(String[] a){
    
   stringthreewaquick(a,0, a.length-1,0);
}

    private static void stringthreewaquick(String[] a, int low, int high, int d) {
       if(low>=high) return;
        int lt=low;
        int gt = high;
       int v = charAt(a[low],d);
       
        int i = low;
              
        while(i<=gt){
           
              int t = charAt(a[i],d);
            if(t<v)exch(a,i++,lt++);
            else if(t>v)exch(a,i,gt--);
            
            else i++;
            show(a);         
            System.out.println();
        }
        stringthreewaquick(a,low,lt-1,d);
      stringthreewaquick(a,lt,gt,d+1);
        stringthreewaquick(a,gt+1,high,d);
    }
   public static int charAt(String x,int d){
       if(d<x.length()) return x.charAt(d);
       else return -1;
   }

}

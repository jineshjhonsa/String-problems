/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.NoSuchElementException;

/**
 *
 * @author Jinesh
 */
public class arraylist<T> {
    private  Object[] arr1;
    private int count;
    private int size;
   
    public arraylist()  {
        
       arr1 = new Object[5];
       size = arr1.length;
       count =0; 
    }
    
    public T get(int i){
        
        return  (T) arr1[i];
        
    }
    public void put(T x){
        
        if(count == (size)){
           size = size *2;
            resizearray(size);
             
        }
                   
        arr1[count++]= x;
    }
    public T[] iterable(){
           return (T[]) arr1;
    }
    private void resizearray(int newsize){
     int x = arr1.length;
         Object arr[] = arr1;
             arr1 = new Object[newsize];
             for(int i =0;i<x;i++){
                 arr1[i] = arr[i];
             }
            
    }
    
    public void remove(int i){
         System.out.println("length is "+ arr1.length);
        if(size ==0) throw new NoSuchElementException("Stack underflow");
        if(i>size) throw new ArrayIndexOutOfBoundsException();
       for(int x =i;x<arr1.length-1;x++)
       {
           
           arr1[i]= arr1[i+1];
           
           
       }
       arr1[arr1.length-1] = null;
      
       if(size == arr1.length/4)
       {
           Object[] arr = new Object[arr1.length/2];
           arr = arr1;
         arr1 = new Object[arr1.length/2]; 
           arr1 =(Object[]) arr;
           System.out.println("length inside is "+ arr1.length);
           
       }
        size--;
    }
}


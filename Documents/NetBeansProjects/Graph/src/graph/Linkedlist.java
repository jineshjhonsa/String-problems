/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package graph;

/**
*
* @author Jinesh
*/
public class Linkedlist<T> {
  private Node root = null;
private int count; 
private int iter;
public  Linkedlist(){
    root = new Node();
    count =-1;
}


public void put(T data){

     put(root, data);

}

private void put(Node temp,T data){

    if(temp.next != null){
        put(temp.next,data);
        return;
    }else{
        Node temp1 = new Node();
        temp1.next = null;
        temp1.x = data;
      temp.next =  temp1;
         count++;   
    }
}
public T get(int i){
    iter = -1;
  T x = get(root,i);
  return (T)x;

}

public T[] iterable(){
   T[] x =(T[]) new Object[count+1];
   for(int i =0;i<=count;i++){
       x[i] = get(i);

   }

   return  x;
}

private T get(Node temp, int i) {

    if(iter< i){
        iter++;
          return get(temp.next,i);
    }

    else if(i<iter) return null;
    else return (T) temp.x;

}
}
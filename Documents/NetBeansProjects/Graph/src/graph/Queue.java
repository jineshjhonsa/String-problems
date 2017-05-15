/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Jinesh
 */
public class Queue<item> implements Iterable<Integer> {
    
    private Node first;
    private Node last;
    private item x;
    public Queue(){
        first = null;
        last = null;
    }
    
    public boolean isEmpty(){
        return first == null;
    }
   public void enqueue(item y){
        Node oldlast = last;
        last =  new Node();
        last.next = null;
        last.x=y;
      
        if(isEmpty())
            first = last;
      else  oldlast.next = last;
        
    }
   
   public item dequeue(){
       if(isEmpty()) throw new NoSuchElementException();
       item item1 = (item) first.x;
       first = first.next;
       return item1;
       
   }

   

    @Override
    public Iterator<Integer> iterator() {
        return (Iterator<Integer>) new ListIterator<item>(first);
    }
    
    
     private class ListIterator<T> implements Iterator<T> {
        private Node current;

        public ListIterator(Node<T> first) {
            current = first;
        }

      

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            T item = (T) current.x;
            current = current.next;
            return item;
        }
    }
}

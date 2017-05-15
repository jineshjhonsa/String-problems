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
public class Stack<item> implements Iterable<item> {
    private Node<item> first;// first is current pointing node
    private int N;//size
    
    public Stack(){
        first = null;
        N=0;
        
    }
    
    public boolean isEmpty(){
        return (first == null);//no value in stack
    }
    public void push(item x){
        Node<item> temp = first;//store current address in a temp node
        first = new Node();
        first.x= x;
        first.next = temp;//set the address of new node to previous nod so becones LIFO
         
        
    }
    
    public item pop(){
        if(first == null) return null;
        item c = first.x;
        first = first.next;// here next is  previous node 
        return c;
      
    }


    @Override
    public Iterator<item> iterator() {
          return new ListIterator<item>(first);
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

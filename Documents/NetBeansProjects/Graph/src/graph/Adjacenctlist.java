/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.ArrayList;
import java.util.Arrays;


/**
 *
 * @author Jinesh
 */
public class Adjacenctlist {
   
    public  int V;
    private Linkedlist<Integer>[] adj;
    public Adjacenctlist(int V){
        this.V = V;
        adj =  (Linkedlist<Integer>[])new Linkedlist[V];
        for(int v=0;v<V;v++){
            adj[v]= new Linkedlist<Integer>();
            
        }
           
    }
    
    public void addEdge(int v, int w){
        adj[v].put(w);
        adj[w].put(v);
        
    }
    public Integer[] adj(int v){
        Object[] w =  adj[v].iterable();    
             Integer[] h1  = Arrays.copyOf(w,w.length,Integer[].class);
         return h1;
    }
 }

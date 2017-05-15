/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.ArrayList;
import java.lang.Integer;
/**
 *
 * @author Jinesh
 */
public class BreadthfirstSearch {
   private boolean marked[];
   private Integer edgeto[];
   private Integer distanceto[];
    private Integer source;
    
   public BreadthfirstSearch(Adjacenctlist graph, int s){
       marked = new boolean[graph.V];
         edgeto = new Integer[graph.V];
         distanceto = new Integer[graph.V];
         source =s;
         bfs(graph,s);
       
   }

    private void bfs(Adjacenctlist graph, int s) {
      
        for(int i =0;i<graph.V;i++){// make the array null and integer to max so that it can start from first
            marked[i] = false;
            edgeto[i] =0;
            distanceto[i] = Integer.MAX_VALUE;
            
        }
        
        marked[s] = true;//mark the source
        edgeto[s] = s;
        distanceto[s] =0;// make distance to 0
        Queue<Integer> x = new Queue();
        x.enqueue(s);//put source in queue
        while(!x.isEmpty()){
           int deq = x.dequeue();//dequeue and check its adjacent list
            for(int w: graph.adj(deq)){
                if(!marked[w]){
                    marked[w] = true;// mark the adjacent node
                    edgeto[w] = deq;//makeits edg to deq
                    distanceto[w] = distanceto[deq]+ 1;// set distance as previous +1
                    x.enqueue(w);
                    
                }//repeat it for rest of the adjacent list and add it to the queue
            }
        
    }
        
    }
    public int distanceto(int dest){
        return distanceto[dest];
    }
        public boolean hasPathto(int dest) {
        return marked[dest];
    }
    
    /**
     *
     * @param v
     * @return
     */
    public Iterable<Integer> pathTo(int dest){
         if(!hasPathto(dest))return null;
         Stack<Integer> path = new Stack();
         for(int x =dest; x!=source;x = edgeto[x]){
             path.push(x);
             
         }
        path.push(source);
       
      /*  while(!path.isEmpty()){
           System.out.println("path is "+ path.pop()); 
        }*/
        return  (Iterable<Integer>) path;
    }
   
}

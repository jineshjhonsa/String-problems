/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.Arrays;
import list1.linkedlistiter;

/**
 *
 * @author Jinesh
 */
public class Graph {
   
            
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
  
        Integer didata[][] = {{0,1},
                        {0,6},
                        {0,5},
                        {2,0},
                        {2,3},
                        {5,4},
                        {3,5},
                        {6,4},
                        {7,6},
                        {8,7},
                        {6,9},
                        {9,12},
                        {9,10},
                        {9,11},
                         {11,12},
                       
        };
        Integer data[][] = {{0,1},
                        {2,2},
                        {0,5},
                        {0,6},
                        {3,4},
                        {3,5},
                        {4,5},
                        {4,6},
                        {7,8},
                        {9,10},
                        {9,11},
                        {9,12},
                        {11,12},
        
        };
       
    /*  Queue<Integer> qu = new Queue();
      qu.enqueue(5);
      qu.enqueue(10);
        qu.enqueue(20);
        for(int w: qu){
            System.out.println("value is "+w);
        }
        qu.dequeue();
        for(int w: qu){
            System.out.println("value now is "+w);
        }
        */
        Digraph graph = new Digraph(didata.length);
        for(int i =0; i< didata.length;i++){
            
            graph.addEdge(didata[i][0],didata[i][1]);
            
           
        }
      
        for(int j =0;j<didata.length;j++){
            System.out.print(j +" adjacent is ");
            for(int w: graph.adj(j)){
                System.out.print("- " +w);
            }
              System.out.println()
                      ;
        }
        // TODO code appl1ication logic here
        int source = 1;
        DepthFirstOrder dfs;
        dfs = new DepthFirstOrder(graph);
       
         
   
/*for (int dest = 0; dest < graph.V; dest++) {
            if (search.hasPathto(dest)) {
                System.out.println(source + " to "+ dest);
                for (int x : search.pathTo(dest)) {
                    if (x == source)  System.out.print(x);
                    else         System.out.print("-" + x);
                }
                System.out.println();
            }

            else {
                System.out.println(source + " is not connected to "+ v);
            }
        
        System.out.println("distance is "+ search.distanceto(v));
       1 4 12 10 11 9 6 5 0 3 2 7 8 13 14 
        
    }*/
        
        
      System.out.println("   v  pre post");
        System.out.println("--------------");
        for (int v = 0; v < graph.V; v++) {
            System.out.printf("%4d %4d %4d\n", v, dfs.pre(v), dfs.post(v));
        }

        System.out.print("Preorder:  ");
        for (int v : dfs.pre()) {
            System.out.print(v + " ");
        }
        System.out.println();

        System.out.print("Postorder: ");
        for (int v : dfs.post()) {
            System.out.print(v + " ");
        }
        System.out.println();

    }
}
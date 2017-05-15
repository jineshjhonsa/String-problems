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
public class DepthFirstSearch {
    
     private boolean[] marked;    // marked[v] = is there an s-v path?
    private int count;           // number of vertices connected to s
    private int edgeTo[];
    private int source;
    /**
     * Computes the vertices in graph <tt>G</tt> that are
     * connected to the source vertex <tt>s</tt>.
     * @param G the graph
     * @param s the source vertex
     */
    public DepthFirstSearch(Adjacenctlist G, int s) {
        marked = new boolean[G.V];
        edgeTo = new int[G.V];
        source =s;
        dfs(G, s);
    }

    // depth first search from v
    private void dfs(Adjacenctlist G, int v) {
        count++;
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
                edgeTo[w] =v;
            }
        }
    }

    /**
     * Is there a path between the source vertex <tt>s</tt> and vertex <tt>v</tt>?
     * @param v the vertex
     * @return <tt>true</tt> if there is a path, <tt>false</tt> otherwise
     */
    public boolean hasPathto(int v) {
        return marked[v];
    }
    
    /**
     *
     * @param v
     * @return
     */
    public Iterable<Integer> pathTo(int dest){
         if(!hasPathto(dest))return null;
         Stack<Integer> path = new Stack();
         for(int x =dest; x!=source;x = edgeTo[x]){
             path.push(x);
             
         }
        path.push(source);
       
      /*  while(!path.isEmpty()){
           System.out.println("path is "+ path.pop()); 
        }*/
        return  (Iterable<Integer>) path;
    }
    
   
}

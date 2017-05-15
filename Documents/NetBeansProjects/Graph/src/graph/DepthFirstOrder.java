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
public class DepthFirstOrder {
     private boolean[] marked;          // marked[v] = has v been marked in dfs?
    private int[] pre;                 // pre[v]    = preorder  number of v
    private int[] post;                // post[v]   = postorder number of v
    private Queue<Integer> preorder;
     private Queue<Integer> postorder1; // vertices in preorder
    private Queue<Integer> postorder;  // vertices in postorder
    private int preCounter;            // counter or preorder numbering
    private int postCounter;           // counter for postorder numbering
 public DepthFirstOrder(Digraph G) {
        pre    = new int[G.V];
        post   = new int[G.V];
        postorder = new Queue<Integer>();
        postorder1 = new Queue<Integer>();
        preorder  = new Queue<Integer>();
        marked    = new boolean[G.V];
        for (int v = 0; v < G.V; v++)
            if (!marked[v]) {
                dfs(G, v);
                postorder1.enqueue(v);
            }
     
        
    }

    private void dfs(Digraph G, int v) {
       
    marked[v] = true;
      pre[v] = preCounter++;
    preorder.enqueue(v);
     for(int w: G.adj(v)){
    if(!marked[w]){
        dfs(G,w);
        postorder1.enqueue(w);
     
    }
    }
      postorder.enqueue(v);
        post[v] = postCounter++;
    }
    
    
    
    /**
     * Returns the preorder number of vertex <tt>v</tt>.
     * @param v the vertex
     * @return the preorder number of vertex <tt>v</tt>
     */
    public int pre(int v) {
        return pre[v];
    }
  public Iterable<Integer> reversePost() {
        Stack<Integer> reverse = new Stack<Integer>();
        for (int v : postorder)
            reverse.push(v);
        return reverse;
    }
    /**
     * Returns the postorder number of vertex <tt>v</tt>.
     * @param v the vertex
     * @return the postorder number of vertex <tt>v</tt>
     */
    public int post(int v) {
        return post[v];
    }

    /**
     * 1 4 12 10 11 9 6 5 0 3 2 7 8 13 14 
     * Returns the vertices in postorder.
     * @return the vertices in postorder, as an iterable of vertices
     */
    public Iterable<Integer> post() {
        return postorder1;
    }

    /**
     * Returns the vertices in preorder.
     * @return the vertices in preorder, as an iterable of vertices
     */
    public Iterable<Integer> pre() {
        return preorder;
    }
}

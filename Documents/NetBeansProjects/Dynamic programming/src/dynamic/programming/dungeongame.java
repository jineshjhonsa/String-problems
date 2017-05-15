/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamic.programming;

/**
 *
 * @author Jinesh
 */
public class dungeongame {
    public static void dungeon(){
        
             int[][] dungeon = {
  { -2, -3, 3 },
  { -5, -10, 1 },
  { 10, 30, -5 }
};
    int m = dungeon.length;
	int n = dungeon[0].length;
 
	//init dp table
	int[][] h = new int[m][n];
 
	h[m - 1][n - 1] = Math.max(1 - dungeon[m - 1][n - 1], 1);
 
	//init last row
	for (int i = m - 2; i >= 0; i--) {
		h[i][n - 1] = Math.max(h[i + 1][n - 1] - dungeon[i][n - 1], 1);
	}
        show(h);
	//init last column
	for (int j = n - 2; j >= 0; j--) {
		h[m - 1][j] = Math.max(h[m - 1][j + 1] - dungeon[m - 1][j], 1);
	}
   show(h);
	//calculate dp table
	for (int i = m - 2; i >= 0; i--) {
		for (int j = n - 2; j >= 0; j--) {
			int down = Math.max(h[i + 1][j] - dungeon[i][j], 1);
			int right = Math.max(h[i][j + 1] - dungeon[i][j], 1);
			h[i][j] = Math.min(right, down);
                          show(h);
		}
	}
        
        System.out.println(h[0][0]);

    }
    
    public static void show(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
    for (int j = 0; j < matrix[0].length; j++) {
        System.out.print(matrix[i][j] + " ");
    }
    System.out.print("\n");
}
        
        System.out.println("done");
    }
    }


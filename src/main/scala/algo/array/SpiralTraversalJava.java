package algo.array;

import java.util.ArrayList;

public class SpiralTraversalJava {



    //Function to return a list of integers denoting spiral traversal of matrix.
    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c)
    {
        ArrayList<Integer> ar = new ArrayList<Integer>();
        int i =0;
        int startRow=0;
        int startCol=0;
        while(startRow<r & startCol<c){
            //print left to right
            for(i=startCol;i<c;i++){
                ar.add(matrix[startRow][i]);
            }
            startRow++;
            //print top to bottom
            for(i=startRow;i<r;i++){
                ar.add(matrix[i][c-1]);
            }
            c--;
            //print left to right
            if(startRow<r) {
                for (i = c-1; i >= startCol; i--) {
                    ar.add(matrix[r-1][i]);
                }
                r--;
            }
            if(startCol<c) {
                for (i = r-1; i >= startRow; i--) {
                    ar.add(matrix[i][startCol]);
                }
                startCol++;
            }

        }
        return ar;

    }

    public static void main(String[] args) {
        int[][] ar = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}};

        spirallyTraverse(ar,3,4);

    }

}

package com.quest.threads;

public class MatrixMain {
    public static void main(String[] args) {
        int[][] matrixA={{1,2,3,},{4,5,6,},{7,8,9,}};
        int[][] matrixB={{1,2,3,},{4,5,6,},{7,8,9,}};

        matrixB=transpose(matrixB);

        for(int[] i:matrixA){
            try{
                MatrixMultiplication thread1=new MatrixMultiplication(i,matrixB);
                thread1.start();
                thread1.sleep(400);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] transposed = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }

        return transposed;
    }
}

package com.quest.threads;

public class MatrixMultiplication extends Thread {

    int[] row;
    int[][] columns;

    public MatrixMultiplication(int[] row,int[][] column){
        this.row=row;
        this.columns=column;
    }

    @Override
    public void run() {
        int[] result=new int[this.row.length];
        int index=0;
        int[][] transposed=this.columns;
        for(int[] i:transposed){
            for(int j=0;j<=i.length-1;j++){
                int num=transposed[index][j];
                int num1=this.row[j];
                result[index]+=num1*num;
            }
            index+=1;
        }
        for(int i:result){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}

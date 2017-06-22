package com.chendoing.learning;

public class QuickUnionUF {

    private int[] id;
    
    public QuickUnionUF(int N){
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }
    
    private int root(int i){
        while (i != id[i])
            i = id[i];
        return i;
    }
    
    public boolean connected(int p, int q){
        return root(p) == root(q);
    }
    
    public void union(int p, int q){
        int i = root(p);
        int j = root(q);
        id[i] = j;
    }
    
    public int[] getResult(){
        return id;
    }
    public static void main(String[] args){
        QuickUnionUF quickUnionUF = new QuickUnionUF(10);
        quickUnionUF.union(9, 0);
        quickUnionUF.union(5, 3);
        quickUnionUF.union(4, 5);
        quickUnionUF.union(6, 7);
        quickUnionUF.union(6, 4);
        quickUnionUF.union(8, 9);
        quickUnionUF.union(9, 1);
        quickUnionUF.union(9, 2);
        quickUnionUF.union(2, 6);
        for(int i = 0; i < 10; i++)
            System.out.print(quickUnionUF.getResult()[i]);
    }
}

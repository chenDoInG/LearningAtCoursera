package com.chendoing.exercises;


public class Week1Q1 {

    private int[] members;
    private long[] timestamps;
    
    public Week1Q1(int N){
        members = new int[N];
        timestamps = new long[N];
        for (int i = 0; i < N; i++) {
            members[i] = i;
            timestamps[i] = 0L;
        }
    }
    
    public int root(int i){
        while (i != members[i])
            i = members[i];
        return i;
    }
    
    public void beFriend(int p, int q){
        int i = root(p);
        int j = root(q);
        if(i == j)
            return;
    }
    
    public int[] getResult(){
        return members;
    }
    public static void main(String[] args){
        Week1Q1 week1q1 = new Week1Q1(10);
        week1q1.beFriend(1, 3);
        week1q1.beFriend(2, 4);
        week1q1.beFriend(2, 5);
        week1q1.beFriend(3, 4);
        for (int i = 0; i < 10; i++) {
            System.out.print(week1q1.getResult()[i]);
        }
    }
}

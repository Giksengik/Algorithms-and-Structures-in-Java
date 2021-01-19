package com.company;

public class QuickUnionImprovements {
    private int[] id;
    private int[] sz;
    public QuickUnionImprovements(int N){
        id=new int[N];
        sz=new int[N];
        for(int i=0;i<N;i++){
            id[i]=i;
            sz[i]=1;
        }
    }
    private int findRoot(int i){
        while (i != id[i]) {
            id[i]=id[id[i]];
            i = id[i];
        }
        return i;
    }
    public boolean isConnected(int p,int q){
        return id[p]==id[q];
    }
    public void union(int p,int q){
        int firstRoot=findRoot(p);
        int secondRoot=findRoot(q);
        if(firstRoot==secondRoot) return;
        if(sz[firstRoot]<sz[secondRoot]){
            id[firstRoot] = secondRoot;
            sz[secondRoot]+=sz[firstRoot];}
        else {
            id[secondRoot]=firstRoot;
            sz[firstRoot]+=sz[secondRoot];
        }

    }
    public static void main(String[] args) {

    }
}

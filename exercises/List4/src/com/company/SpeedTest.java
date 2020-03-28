package com.company;

public class SpeedTest {
    public static void main(String [] args){
        AList L=new AList();
        int i=0;
        while(i<1000000){
            L.addLast(i);
            i++;
        }
        System.out.println(L.getLast());
    }

}

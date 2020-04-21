package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import java.util.ArrayList;
public class Percolation {

    private int numOpenSites;
    private int[][] openGrid;
    private int dimension;
    private WeightedQuickUnionUF union;
    private ArrayList<Integer> topOpen;
    private static final int OPEN=1;

    public Percolation(int N){
        if(N<0)
            throw new IllegalArgumentException("N is less than 0");

        topOpen=new ArrayList<>();
        openGrid=new int[N][N];
        union =new WeightedQuickUnionUF(N*N);
        dimension=N;
        numOpenSites=0;

    }

    private void connectNearBy(int[][] array, int row, int col) {
        int[] x = new int[]{-1, 1, 0, 0};
        int[] y = new int[]{0, 0, -1, 1};
        for (int i = 0; i < 4; i++) {
            int nebRow, nebCol;
            nebRow = row + x[i];
            nebCol = col + y[i];
            if (nebRow < 0 || nebRow >= dimension) continue;
            if (nebCol < 0 || nebCol >= dimension) continue;
            if (array[nebRow][nebCol] > 0) {
                union.union(row * dimension + col, nebRow * dimension + nebCol);
            }
        }
    }


    private void outOfBundsCheck(int row,int col){
        boolean flag=row<0;
        flag=flag||(row>=dimension);
        flag=flag||(col<0);
        flag=flag||(col>=dimension);
        if(flag)
            throw new IndexOutOfBoundsException("row or col is out of bounds");
    }

    public void open(int row,int col){
        outOfBundsCheck(row,col);

        if(openGrid[row][col]==OPEN)
            return;

        openGrid[row][col]=OPEN;
        if(row==0) topOpen.add(col);
        connectNearBy(openGrid,row,col);
        numOpenSites++;

    }

    public boolean isOpen(int row, int col){
        outOfBundsCheck(row,col);
        if(openGrid[row][col]==OPEN)
            return true;
        return false;
    }

    public boolean isFull(int row, int col){
        outOfBundsCheck(row,col);

        for(Integer i: topOpen){
            if(union.connected(row*dimension+col,i))
                return true;
        }

        return false;
    }

    public int numberOfOpenSites(){
        return numOpenSites;
    }

    public boolean percolates(){
        for(Integer i: topOpen){
            for(int j=0;j<dimension;j++){
                if(union.connected(dimension*(dimension-1)+j,i))
                    return true;
            }
        }
        return false;

    }

    public static void main(String[] args){

        WeightedQuickUnionUF union=new WeightedQuickUnionUF(20);
        System.out.println(union.find(19));

    }




}

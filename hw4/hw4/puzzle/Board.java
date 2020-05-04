package hw4.puzzle;

import java.util.ArrayList;

public class Board implements WorldState{

    private final int[][] initialState;
    private final int[][] goal;
    private final int size;


    /**
     * construct a board from N-by-N array of tiles
     */
    public Board(int[][] tiles){
        size=tiles.length;
        goal=new int[size][size];
        initialState=new int[size][size];
        for(int i=0;i<size;i++)
            for(int j=0;j<size;j++){
                goal[i][j]=i*size+j+1;
                initialState[i][j]=tiles[i][j];
            }
        goal[size-1][size-1]=0;


    }

    /**
     * return value of tile at row i and colum j (or 0 if blank)
     */
    public int tileAt(int i, int j){
        if(i>=size || j>=size)
            throw new IndexOutOfBoundsException();

        return initialState[i][j];
    }

    /**
     * returns the board size N
     */
    public int size(){
        return size;
    }

    private Board createNeighbor(int oldBX, int oldBY, int newBX, int newBY){
        int[][] newTilt=new int[size][size];
        for(int i=0;i<size;i++)
            for(int j=0;j<size;j++) {
                newTilt[i][j] = initialState[i][j];
            }

        newTilt[oldBX][oldBY]=initialState[newBX][newBY];
            newTilt[newBX][newBY]=0;

        return new Board(newTilt);
    }

    /**
     * return the neighbors of the current board
     */
    @Override
    public Iterable<WorldState> neighbors(){
        ArrayList<WorldState> list=new ArrayList<>();
        int x=0,y=0;
        for(int i=0;i<size;i++)
            for(int j=0;j<size;j++){
                if(initialState[i][j]==0) {
                    x=i;
                    y=j;
                    break;
                }
            }
        int[] dx=new int[]{-1,0,0,1};
        int[] dy=new int[]{0,1,-1,0};

        for(int k=0;k<4;k++){
            int i=x+dx[k];
            int j=y+dy[k];
            if(i>=0 && i<size && j>=0 && j<size){
                list.add(createNeighbor(x,y,i,j));
            }
        }

        return list;
    }

    /**
     * hamming estimate described below
     */
    public int hamming(){
        int estimated=0;
        for(int i=0;i<size;i++)
            for(int j=0;j<size;j++){
                if(i==size-1 && j==size-1) continue;
                if(initialState[i][j]!=goal[i][j])
                    estimated++;
            }

        return estimated;
    }

    /**
     * Manhattan estimate described below
     */
    public int manhattan(){
        int estimated=0;
        for(int i=0;i<size;i++)
            for(int j=0;j<size;j++){

                int temp=initialState[i][j]-1;
                if(temp<0) continue;
                estimated+=Math.abs(temp/size-i)+Math.abs(temp%size-j);
            }

        return estimated;
    }

    /**
     * Estimated distance to goal.Return the results of manhattan()
     * @return
     */
    @Override
    public int estimatedDistanceToGoal(){

        return manhattan();
    }


    /**
     *Return true if this board's tile values are the same position as y's
     */
    public boolean equals(Object y){
        if(this==y) return true;

        if(y==null) return false;

        if(y.getClass()!=this.getClass()) return false;

        Board o=(Board) y;
        if(o.size()!=this.size()) return false;

        for(int i=0;i<size();i++)
            for(int j=0;j<size();j++){
                if(o.tileAt(i,j)!=this.tileAt(i,j))
                    return false;
            }

        return true;

    }

    public int hashCode(){
        int code=0;
        int n=0;
        for(int i=0;i<size;i++)
            for(int j=0;j<size;j++){
                code=code+initialState[i][j]^n;
                n++;
            }

        return code;

    }


    /** Returns the string representation of the board. 
      * Uncomment this method. */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        int N = size();
        s.append(N + "\n");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                s.append(String.format("%2d ", tileAt(i,j)));
            }
            s.append("\n");
        }
        s.append("\n");
        return s.toString();
    }
    

}

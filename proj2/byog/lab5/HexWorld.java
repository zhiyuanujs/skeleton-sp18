package byog.lab5;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Random;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {

    private static Random ran=new Random(123214);

    private static void addHexagonByline(TETile[][] world, int lineNumber, int start, int end, TETile t){
        for(int i=start;i<end;i++){
            world[i][lineNumber]=t;
        }
    }

    /**
     *
     * @param world
     * @param size
     * @param x, the x position of left bottom tile
     * @param y, the y position of left bottom tile
     * @param t, the type of tile
     */
    public static void addHexagon(TETile[][] world, int size, int x, int y, TETile t){
        int start=x;
        int end=x+size;
        for(int j=y;j<y+size;j++){
            addHexagonByline(world,j,start,end,t);
            int mirrorLine=2*y+size*2-j-1;
            addHexagonByline(world,mirrorLine,start,end,t);
            start--;
            end++;
        }

    }

    private static boolean isValidPosition(int x, int y, int size, int w, int h){
        int leftMost, rightMost, bottomMost, topMost;
        leftMost=x-size+1;
        rightMost=x+2*size-2;
        bottomMost=y;
        topMost=y+2*size-1;
        return leftMost>=0 && rightMost<w && bottomMost>=0 && topMost<h;


    }

    private static int[] validPosition(int w, int h, int size){
        int[] posXY=new int[2];
        do{
            posXY[0]=ran.nextInt(w);
            posXY[1]=ran.nextInt(h);
            boolean flag=isValidPosition(posXY[0],posXY[1],size,w,h);

            if(flag) break;

        }while(true);

        return posXY;
    }

    private static int[] positionFinder(ArrayList<Integer> posX, ArrayList<Integer> posY, int w, int h, int size){
        if(posX.size()==0){
            int[] posXY=validPosition(w,h,size);
            posX.add(posXY[0]);
            posY.add(posXY[1]);
        }

        int returnIndex=ran.nextInt(posX.size());
        int[] returnArray=new int[]{posX.get(returnIndex), posY.get(returnIndex)};

        int tempN=posX.size();
        for(int i=0;i<tempN;i++){
            int [] x=new int[6];
            int [] y=new int[6];
            x[0]=posX.get(i)-2*size+1;
            y[0]=posY.get(i)+size;

            x[1]=posX.get(i);
            y[1]=posY.get(i)+2*size;

            x[2]=posX.get(i)+2*size-1;
            y[2]=posY.get(i)+size;

            x[3]=posX.get(i)+2*size-1;
            y[3]=posY.get(i)-size;

            x[4]=posX.get(i);
            y[4]=posY.get(i)-size;

            x[5]=posX.get(i)-2*size+1;
            y[5]=posY.get(i)-size;

            for(int j=0;j<6;j++) {
                if (isValidPosition(x[j], y[j], size, w, h)) {
                    posX.add(x[j]);
                    posY.add(y[j]);
                }
            }
        }

        posX.remove(returnIndex);
        posY.remove(returnIndex);
        return returnArray;
    }

    private static TETile randomTile() {
        int tileNum = ran.nextInt(3);
        switch (tileNum) {
            case 0: return Tileset.WALL;
            case 1: return Tileset.FLOWER;
            default: return Tileset.NOTHING;
        }
    }

    public static void tesselationHeex(TETile[][] world, int size, int number){
        ArrayList<Integer> posX=new ArrayList<>();
        ArrayList<Integer> posY=new ArrayList<>();
        int w=world.length;
        int h=world[0].length;
        for(int i=0;i<number;i++) {
            int[] posXY=positionFinder(posX, posY, w, h, size);
            addHexagon(world,size,posXY[0],posXY[1],randomTile());
        }
    }

    public static void main(String[] args) {
        int WIDTH=100;
        int HEIGHT=100;
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);

        TETile[][] world = new TETile[WIDTH][HEIGHT];
        for (int x = 0; x < WIDTH; x += 1) {
            for (int y = 0; y < HEIGHT; y += 1) {
                world[x][y] = Tileset.NOTHING;
            }
        }

        HexWorld.tesselationHeex(world,4,8);

        ter.renderFrame(world);


    }
}


package hw4.puzzle;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;
import java.util.Comparator;
import java.util.HashSet;

public class Solver {

    private MinPQ <SearchNode> pQueue;
    private int minMove;
    private Stack<WorldState> pathToGoal;

    private class SearchNode{
        WorldState w;
        int movesMade;
        SearchNode pre;
        int estimatedDistanceToGoal;
        int estimatedTotalMove;

        public SearchNode(WorldState ws, int mW, SearchNode s){
            w=ws;
            movesMade=mW;
            pre=s;
            estimatedDistanceToGoal=w.estimatedDistanceToGoal();
            estimatedTotalMove=movesMade+estimatedDistanceToGoal;
        }

        public WorldState worldState(){return w;}
    }

    private class SearchNodeComparator implements Comparator<SearchNode>{
        public int compare(SearchNode s1, SearchNode s2){
            return s1.estimatedTotalMove-s2.estimatedTotalMove;
        }

    }

    /**
     *Compute the everything for moves() and solution()
     */
    public Solver(WorldState initial){

        Comparator <SearchNode> comparator =new SearchNodeComparator();
        pQueue=new MinPQ<>(comparator);
        SearchNode initialSearchNode=new SearchNode(initial,0,null);
        pQueue.insert(initialSearchNode);
        pathToGoal=new Stack<>();

        SearchNode currentSN=pQueue.delMin();
        WorldState currentWS=currentSN.worldState();
        int i;
        HashSet<WorldState> searched=new HashSet<>();
        searched.add(currentWS);
        while(!currentWS.isGoal()){
            i=currentSN.movesMade+1;
            for(WorldState nextWS: currentWS.neighbors()){
                if(!searched.contains(nextWS))
                    pQueue.insert(new SearchNode(nextWS,i,currentSN));
            }
            currentSN=pQueue.delMin();
            currentWS=currentSN.worldState();
            searched.add(currentWS);
        }
        SearchNode node=currentSN;
        while(node!=null){
            pathToGoal.push(node.worldState());
            node=node.pre;
        }
        minMove=currentSN.movesMade;

    }

    /**
     * Returns the minimum bumber of moves to solve the puzzle
     */
    public int moves(){

        return minMove;
    }

    /**
     * Return the sequence of worldStates from the initial to the solution
     * @return
     */
    public Iterable<WorldState> solution(){
        return pathToGoal;
    }


}

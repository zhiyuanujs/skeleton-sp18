package hw2;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
public class PercolationStats {

    double [] perThreshold;
    private double mean;
    private double stddev;
    private int times;

    public PercolationStats(int N, int T, PercolationFactory pf){

        times=T;
        perThreshold=new double[T];
        int x,y;

        for(int i=0;i<T;i++){
            Percolation p=pf.make(N);
            do{
                x=StdRandom.uniform(N);
                y=StdRandom.uniform(N);
                p.open(x,y);
            }while(!p.percolates());

            perThreshold[i]=(p.numberOfOpenSites()*1.0)/N/N;
        }

    }

    public double mean(){
        mean=StdStats.mean(perThreshold);
        return mean;
    }

    public double stddev(){
        stddev=StdStats.stddev(perThreshold);
        return stddev;
    }

    public double confidenceLow(){

        return mean-1.96*stddev/Math.sqrt(times);

    }

    public double confidenceHigh(){

        return mean+1.96*stddev/Math.sqrt(times);

    }


    public static void main(String[] args){
        PercolationFactory pf=new PercolationFactory();
        PercolationStats ps=new PercolationStats(20,50,pf);

        System.out.println(ps.mean());
        System.out.println(ps.stddev());
        System.out.println(ps.confidenceLow());
        System.out.println(ps.confidenceHigh());

    }
}

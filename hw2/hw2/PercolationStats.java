package hw2;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
public class PercolationStats {

    private double [] perThreshold;
    private double mean;
    private double stddev;
    private int times;

    public PercolationStats(int N, int T, PercolationFactory pf){

        if(N<0 || T<0)
            throw new IllegalArgumentException("negative value in PercolationStats constructor");

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

}

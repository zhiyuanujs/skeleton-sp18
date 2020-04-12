/** A client that uses the synthesizer package to replicate a plucked guitar string sound */
public class GuitarHeroLite {
    private static final double CONCERT_A = 440.0;
    private static final double CONCERT_C = CONCERT_A * Math.pow(2, 3.0 / 12.0);

    public static void main(String[] args) {
        /* create two guitar strings, for concert A and C */
        synthesizer.GuitarString stringA = new synthesizer.GuitarString(CONCERT_A);
        synthesizer.GuitarString stringC = new synthesizer.GuitarString(CONCERT_C);

        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        synthesizer.GuitarString [] string37=new synthesizer.GuitarString[37];
        for(int i=0;i<37;i++){
            double ConcertN=CONCERT_A*Math.pow(2,(i-24)/12.0);
            string37[i]=new synthesizer.GuitarString(ConcertN);
        }

        while (true) {

            int index=0;
            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                index=keyboard.indexOf(key);
                if(index==-1) continue;
                string37[index].pluck();

            }
            double sample2=string37[index].sample();

        /* compute the superposition of samples */
            double sample = stringA.sample() + stringC.sample();

        /* play the sample on standard audio */
            StdAudio.play(sample2);

        /* advance the simulation of each guitar string by one step */
            string37[index].tic();
            string37[index].tic();
        }
    }
}


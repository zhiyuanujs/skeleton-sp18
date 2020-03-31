public class HorribleSteve {
    public static void main(String [] args) {
        int i = 0;
        boolean bo;
        for (int j = 0; i < 500; ++i, ++j) {
            bo=Flik.isSameNumber(i, j);
            if (!bo) {
                break; // break exits the for loop!
            }
        }
        System.out.println("i is " + i);
    }
}

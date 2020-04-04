public class OffByN implements CharacterComparator{

    private int gap;

    public OffByN(int N){
        gap=N;

    }

    @Override
    public boolean equalChars(char x, char y){
        int difference =Math.abs(x-y);
        if(difference==gap)
            return true;
        return false;
    }
}

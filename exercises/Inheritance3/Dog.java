import java.util.Comparator;
public class Dog implements Comparable<Dog>{

    private String name;
    private int size;

    public Dog(String n, int s){
        name=n;
        size=s;
    }

    public void bark(){
        System.out.println(name+" says: bark");
    }

    @Override
    public int compareTo(Dog o){

        return this.size-o.size;
    }


    private static class NameComparator implements Comparator<Dog>{
        @Override
        public int compare(Dog a, Dog b){
            return a.name.compareTo(b.name);
        }
    }

    public static Comparator<Dog> getNameComparator(){
        return new NameComparator();
    }
}

public class WordUtils {

    public static String findLongest(List61B<String> s){
        String longest="";
        String temp;
        for(int i=0;i<s.size();i++){
            temp=s.get(i);
            if(longest.length()<temp.length())
                longest=temp;
        }

        return longest;
    }


}

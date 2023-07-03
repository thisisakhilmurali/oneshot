import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SmallestString {

    public static String smallestString(int N, List<String> A) {

        List<String> smallestCharacters=new ArrayList<>();

        for(String element:A){
            char smallest=element.charAt(0);

            for(int i=1;i<element.length();i++){
                char current=element.charAt(i);
                if(smallest>current){
                    smallest=current;
                }
            }
            smallestCharacters.add(Character.toString(smallest));
        }

        Collections.sort(smallestCharacters);

        StringBuilder result = new StringBuilder();

        for(String character:smallestCharacters){
            result.append(character);
        }
        return result.toString();
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int N = Integer.parseInt(scan.nextLine().trim());

        List<String> A = new ArrayList<>(N);

        for(int j=0; j<N; j++) {
            A.add(scan.nextLine());
        }

        String result = smallestString(N, A);

        System.out.println(result);

    }

}
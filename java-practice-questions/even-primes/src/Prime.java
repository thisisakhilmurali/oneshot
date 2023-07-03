import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prime {

    public static int evenPrimes(int N, List<Integer> A) {

        int sum = 0;

        for (int num : A) {
            if (isGreatNumber(num)) {
                sum += num;
            }
        }
        return sum;
    }

    private static boolean isGreatNumber(int num) {

        if (num % 2 == 0) {
            int primefactor = isPrime(num);
            return primefactor > 2;
        }
        return false;
    }

    private static int isPrime(int num) {

        while (num % 2 == 0) {
            num /= 2;
        }

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return i;
            }
        }
        return num;
    }


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int N = Integer.parseInt(scan.nextLine().trim());
        List<Integer> A = new ArrayList<>(N);

        for (int j = 0; j < N; j++) {
            A.add(Integer.parseInt(scan.nextLine().trim()));
        }

        int result = evenPrimes(N, A);

        System.out.println(result);

    }

}
import java.util.*;

public class FibonacciLastDigit {
    private static int getFibonacciLastDigitNaive(int n) {
        if (n <= 1)
            return n;

        int previous = 0;
        int current  = 1;

        for (int i = 0; i < n - 1; ++i) {
            int tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % 10;
    }

    private static int getFibonacciLastDigitFast(int n) {
        if (n <= 1)
            return n;

        int[] fibonacci = new int[n + 1];

        fibonacci[0] = 0;
        fibonacci[1]  = 1;

        for (int i = 2; i <= n ; ++i) 
            fibonacci[i] = (fibonacci[i - 1] + fibonacci[i - 2]) % 10;
        

        return fibonacci[n];
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = getFibonacciLastDigitFast(n);
        System.out.println(c);
    }
}


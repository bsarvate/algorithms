import java.util.*;

public class FibonacciSumLastDigit {
    private static long getFibonacciSumNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long sum      = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current;
        }

        return sum % 10;
    }

    private static int getFibonacciSumLastDigit(long n) {
        if ( n<=1 ) 
            return (int)n;

        ArrayList<Integer> fibonacci = new ArrayList<>();

        fibonacci.add(0);
        fibonacci.add(1);

        int sum = 1;

        for (int i = 2; i <= n; i++) {
            fibonacci.add((fibonacci.get(i - 1) + fibonacci.get(i - 2))%10);
            //System.out.println("i=" + i + " fib=" + fibonacci.get(i));
            sum = (sum +fibonacci.get(i))%10;
        }

        return sum;

    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        int s = getFibonacciSumLastDigit(n);
        System.out.println(s);
    }
}


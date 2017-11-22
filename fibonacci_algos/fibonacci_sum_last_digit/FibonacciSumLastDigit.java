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

        ArrayList<Integer> fibonaccimod = new ArrayList<>();

        fibonaccimod.add(0);
        fibonaccimod.add(1);

        int sum = 0;

        long maxI = 0;

        for (int i = 2; i <= n; i++) {
            fibonaccimod.add((fibonaccimod.get(i - 1) + fibonaccimod.get(i - 2))%10);
            //System.out.println("i=" + i + " fib=" + fibonaccimod.get(i));
            //sum = sum +fibonacci.get(i);

            maxI = i;

            if(fibonaccimod.get(i-1) == 0 && fibonaccimod.get(i) == 1) {
                break;
            }
        }

        int periodiclen =  fibonaccimod.size();

        if(maxI < n && maxI != 0) 
            periodiclen -= 2;

        long n1 =  n / periodiclen;

        long remain =  n % periodiclen;

        //System.out.println("periodiclen=" + periodiclen + " n1=" + n1 + " remain=" + remain);

        for (int i = 0; i < periodiclen; i++)
            sum = (sum + fibonaccimod.get(i)) % 10;

        sum = (int) (n1 * sum) % 10;

        for (int i = 0; i <= remain; i++)
            sum = (sum + fibonaccimod.get(i))%10;

        //System.out.println("sum=" + sum);
        return sum;

    }
    
    public static void main(String[] args) {
        //Stress testing

        /*while(true) {
            //Generate n
            Random rand = new Random();
            long n = Math.abs(rand.nextLong()) % 100000000000000L;
            System.out.println("n=" + n);
            System.out.println(getFibonacciSumLastDigit(n));

        }*/

        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        int s = getFibonacciSumLastDigit(n);
        System.out.println(s);
    }
}


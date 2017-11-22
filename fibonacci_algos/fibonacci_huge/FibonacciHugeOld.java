import java.util.*;
import java.math.BigInteger;

public class FibonacciHuge {
    private static long getFibonacciHugeNaive(long n, long m) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % m;
    }

    private static long getFibonacciHugeFast(long n, long m) {
        if ( n <= 1) 
            return n;

        ArrayList<BigInteger> fibonacci = new ArrayList<>();
        ArrayList<Integer> periodic = new ArrayList<>();

        fibonacci.add(BigInteger.valueOf(0));
        fibonacci.add(BigInteger.valueOf(1));
        periodic.add(0);
        periodic.add(1);

        BigInteger m1 = BigInteger.valueOf(m);
        BigInteger n1 = BigInteger.valueOf(n);
        int maxI = 0;

        for (int i = 2; i <= n; i++) {
            BigInteger num1 = fibonacci.get(i-1);
            BigInteger num2 = fibonacci.get(i-2);
            BigInteger fib = num1.add(num2);
            fibonacci.add(fib);
            BigInteger modulo = fib.mod(m1);
            //System.out.println("i=" + i + " fib=" + fib + "modulo=" + modulo);
            periodic.add(modulo.intValue());
            //System.out.println(periodic.get(i));
            maxI = i;
            //System.out.println("i=" + i + " period=" + periodic.get(i));
            if(periodic.get(i-1) == 0 && periodic.get(i) == 1) {
                break;
            }
        }

        //for (int item : periodic)
            //System.out.print(item + " ");
        //System.out.println("maxI=" + maxI);
        long periodiclen = (long) periodic.size();
        if ( maxI < n && maxI != 0)
            periodiclen -= 2;
        
        //System.out.println("len=" + periodiclen);
        //int remain = (int) n%periodiclen;
        //System.out.println("remain=" + remain);
        long remain = (n % (long)periodiclen);
        //System.out.println("remain=" + remain);
        //System.out.println("result=" + fibonacci.get((int)(n % periodiclen)));
        BigInteger result = fibonacci.get((int)(n%periodiclen)).mod(m1);
        return result.longValue();
        //return 5;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHugeFast(n, m));
    }
}


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

        ArrayList<Long> fibonaccimod = new ArrayList<>();

        fibonaccimod.add(0L);
        fibonaccimod.add(1L);
    

        int maxI = 0;

        for (int i = 2; i <= n; i++) {
            long modulo = (fibonaccimod.get(i - 1) + fibonaccimod.get(i - 2))%m;
            fibonaccimod.add(modulo);
        
            //System.out.println("i=" + i + "modulo=" + modulo);
            //periodic.add(modulo);
            //System.out.println(periodic.get(i));
            maxI = i;
            //System.out.println("i=" + i + " period=" + periodic.get(i));
            if(fibonaccimod.get(i-1) == 0 && fibonaccimod.get(i) == 1) {
                break;
            }
        }

        //for (int item : periodic)
            //System.out.print(item + " ");
        //System.out.println("maxI=" + maxI);
        int periodiclen = fibonaccimod.size();
        if ( maxI < n && maxI != 0)
            periodiclen -= 2;
        
        //System.out.println("len=" + periodiclen);
        //int remain = (int) n%periodiclen;
        //System.out.println("remain=" + remain);
        //long remain = (n % (long)periodiclen);
        //System.out.println("remain=" + remain);
        //System.out.println("result=" + fibonaccimod.get((int)(n % periodiclen)));
        return fibonaccimod.get((int)(n%periodiclen));
        //return 5;
    }
    
    public static void main(String[] args) {
        //Testing

       /* while(true) {
            Random rand = new Random();
            //Generate n
            long n = Math.abs(rand.nextLong()) % 1000000000000000000 + 1;

            //Generate m
            long m = Math.abs(rand.nextLong()) % 100000 + 2;
            System.out.println(n + " " + m);

            System.out.println(getFibonacciHugeFast(n, m));
        }*/

        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHugeFast(n, m));
    }
}


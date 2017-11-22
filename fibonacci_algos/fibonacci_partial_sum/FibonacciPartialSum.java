import java.util.*;

public class FibonacciPartialSum {
    private static long getFibonacciPartialSumNaive(long from, long to) {
        long sum = 0;

        long current = 0;
        long next  = 1;

        for (long i = 0; i <= to; ++i) {
            if (i >= from) {
                sum += current;
            }

            long new_current = next;
            next = next + current;
            current = new_current;
        }

        return sum % 10;
    }

    private static int getFibonacciPartialSumFast(long from , long to) {
        if (from > to) {
            System.out.println("Wrong inputs!");
            return -1;
        }

        ArrayList<Integer> fibonaccimod = new ArrayList<>();

        int sum = 0;
        fibonaccimod.add(0);
        fibonaccimod.add(1);


        long maxI = 0;

        for (int i = 2; i <=to; i++) {
            fibonaccimod.add((fibonaccimod.get(i-1) + fibonaccimod.get(i-2))%10);

            maxI = i;

            if (fibonaccimod.get(i-1) == 0 && fibonaccimod.get(i) == 1)
                break;
        
        }

        int periodiclen = fibonaccimod.size();
        if (maxI < to && maxI != 0)
            periodiclen -= 2;

        long remain1 =  from % periodiclen;

        long div1 = from / periodiclen;

        long div2 = to / periodiclen;

        long diff = div2 - div1 - 1;

        long remain2 =  to % periodiclen;

        //System.out.println("len=" + periodiclen + " remain1=" + remain1 + " diff=" + diff + " remain2=" + remain2);

        for (int i = (int) remain1; i < periodiclen; i++) 
            sum = ( sum + fibonaccimod.get(i) )%10;

        int sum1 = 0;
        for (int i = 0; i < periodiclen; i++) 
            sum1 =  ( sum1 + fibonaccimod.get(i) )%10;

        sum1 = ((int)( sum1 * diff ))%10;

        sum =  ( sum1 + sum )%10;

        for (int i = 0; i <= remain2; i++)
            sum =  ( sum + fibonaccimod.get(i) )%10;

        return sum;
    }
    
    public static void main(String[] args) {

        //Testing

        /*while(true) {

            Random rand = new Random();

            //generate from
            long from = Math.abs(rand.nextLong())%1000000000000000000L;

            //generate to
            long to = Math.abs(rand.nextLong())%1000000000000000000L;

            System.out.println(from + " " + to);

            if(from >=0 && to >= 0)
                System.out.println(getFibonacciPartialSumFast(from, to));

        } */


        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(getFibonacciPartialSumFast(from, to));
    }
}


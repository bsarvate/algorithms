import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {
    static long getMaxPairwiseProduct(int[] numbers) {
        long result = 0;
        int n = numbers.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if ((long) numbers[i] * numbers[j] > result) {
                    result = (long) numbers[i] * numbers[j];
                }
            }
        }
        return result;
    }

    static long getMaxPairwiseProductFast(int[] numbers) {
        long result = 0;
        int n = numbers.length;

        int maxIndex1 = -1;
        for (int i = 0; i < n; ++i) {
           if ((maxIndex1 == -1) || (numbers[i] > numbers[maxIndex1]))
                maxIndex1 = i;          
        }

        int maxIndex2 = -1;
        for (int i = 0; i < n; ++i) {
           if ((i != maxIndex1) && ((maxIndex2 == -1) || (numbers[i] > numbers[maxIndex2])))
                maxIndex2 = i;          
        }

        //System.out.print("Index " + maxIndex1 + " " + maxIndex2);

        result = (long) numbers[maxIndex1] * numbers[maxIndex2];
        return result;
    }

    public static void main(String[] args) {

        // Stress Testing
        /*while(true) {

            //Generate n
            Random rand = new Random();
            int n = rand.nextInt(9) + 2;

            //Generate the integer input array
            int[] numbers = new int[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = rand.nextInt(100000);
            }

            //Check first result
            long result1 = getMaxPairwiseProduct(numbers);

            //Check second result
            long result2 = getMaxPairwiseProductFast(numbers);

            System.out.println("\n" + n);
            for (int i = 0; i < n; i++ ) 
                System.out.print(numbers[i] + " ");

            if(result1 != result2){
                System.out.println("\nWrong Result!");
                System.out.println(result1 + " " + result2);
                break;
            }

            else {
                System.out.println("\nOK");
                System.out.println(result1 + " " + result2);
            }
            
        }*/

       FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProductFast(numbers)); 
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}
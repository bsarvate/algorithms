import java.util.Scanner;
import java.util.Random;

public class Fibonacci {
  private static long calc_fib(int n) {
    if (n <= 1)
      return n;

    return calc_fib(n - 1) + calc_fib(n - 2);
  }

  private static long calc_fib_fast(int n) {
    //Create an array of n numbers
    if(n <= 1)
      return n;

    long[] fibonacci = new long[n + 1];

    fibonacci[0] = 0;
    fibonacci[1] = 1;

    for ( int i = 2; i <= n; i++ ){
      fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
    }

    return fibonacci[n];

  }

  public static void main(String args[]) {

    // Stress Testing
    while(true) {
      // Generate n
      /*Random rand = new Random();
      int n = rand.nextInt(20) + 2;

      System.out.println(n);

      //long result1 = calc_fib(n);
      long result2 = calc_fib_fast(n);
      System.out.println(result2);

      if (result1 != result2) {
        System.out.println("Wrong result!");
        System.out.println(result1 + " " + result2);
      } else {
        System.out.println("Ok");
        System.out.println(result1 + " " + result2);
      }*/
    } 
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    System.out.println(calc_fib_fast(n));
  }
}

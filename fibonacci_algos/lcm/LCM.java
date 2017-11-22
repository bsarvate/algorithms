import java.util.*;

public class LCM {
  private static long lcm_naive(int a, int b) {
    for (long l = 1; l <= (long) a * b; ++l)
      if (l % a == 0 && l % b == 0)
        return l;

    return (long) a * b;
  }

  private static int gcd(int a, int b) {
    if ( b == 0 || a == b)
      return a;

    return gcd(b, a%b);
  }

  private static long lcm_fast(int a, int b) {
    /*if (a == b)
      return a;*/
    
    //System.out.println(gcd(a, b));
    long multi = (long) a * b;
    //System.out.println(multi);
    return multi / gcd(a, b);
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(lcm_fast(a, b));
  }
}

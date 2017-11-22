# Uses python3
import sys
import random

def get_fibonacci_huge_naive(n, m):
    if n <= 1:
        return n

    previous = 0
    current  = 1

    for _ in range(n - 1):
        previous, current = current, previous + current

    return current % m


def get_fibonacci_huge_fast(n, m):
    if n<= 1:
        return n

    fibonacci_mod = [0, 1]

    max_i = 0
    for i in range(2, n+1):
        fibonacci_mod.append((fibonacci_mod[i-1] + fibonacci_mod[i-2])%m)

        max_i = i
        if(fibonacci_mod[i-1] == 0 and fibonacci_mod[i] == 1):
            break

    #print(fibonacci)

    periodiclen = len(fibonacci_mod)
    if max_i < n and max_i != 0:
        periodiclen = periodiclen - 2;

    return (fibonacci_mod[n%periodiclen]%m)


if __name__ == '__main__':

    #Stress test

    #while True:
        #Generate n
        #n = random.randrange(1, 1000000000000000000)

        #Generate m
        #m = random.randrange(2, 100000)

        #print(n, ' ', m)

        #print(get_fibonacci_huge_fast(n, m))


    #input = sys.stdin.read();
    n, m = map(int, input().split())
    print(get_fibonacci_huge_fast(n, m))

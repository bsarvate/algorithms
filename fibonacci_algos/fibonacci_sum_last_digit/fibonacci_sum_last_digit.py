# Uses python3
import sys

def fibonacci_sum_naive(n):
    if n <= 1:
        return n

    previous = 0
    current  = 1
    sum      = 1

    for _ in range(n - 1):
        previous, current = current, previous + current
        sum += current

    return sum % 10

def fibonacci_sum_last_digit_fast(n):
    if n <= 1:
        return n

    sum = 0

    max_i = 0

    fibonacci_mod = [0, 1]

    for i in range (2, n+1):
        fibonacci_mod.append((fibonacci_mod[i-1] +fibonacci_mod[i-2])%10)
        
        max_i = i

        if fibonacci_mod[i-1] == 0 and fibonacci_mod[i] == 1:
            break


    periodiclen = len(fibonacci_mod)

    if max_i < n and max_i != 0:
        periodiclen = periodiclen - 2

    n1 = n // periodiclen
    remain = n % periodiclen

    #print('n1=', n1, ' remain=', remain)

    for i in range(periodiclen):
        sum = ( sum + fibonacci_mod[i] ) % 10

    sum = (sum * n1) % 10

    for i in range(remain + 1):
        sum = ( sum + fibonacci_mod[i] ) % 10

    return int(sum)


if __name__ == '__main__':
    #input = sys.stdin.read()
    n = int(input())
    print(fibonacci_sum_last_digit_fast(n))

# Uses python3
import sys

def get_fibonacci_last_digit_naive(n):
    if n <= 1:
        return n

    previous = 0
    current  = 1

    for _ in range(n - 1):
        previous, current = current, previous + current

    return current % 10

def get_fibonacci_last_digit_fast(n):
    if n <= 1:
        return n

    fibonacci = []
    fibonacci.append(0)
    fibonacci.append(1)

    for i in range(2, n+1):
        fibonacci.insert(i, (fibonacci[i-1] + fibonacci[i-2])%10)

    return fibonacci[n]


if __name__ == '__main__':
    #input = sys.stdin.read()
    n = int(input())
    print(get_fibonacci_last_digit_fast(n))

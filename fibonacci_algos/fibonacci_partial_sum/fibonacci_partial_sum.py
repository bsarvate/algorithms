# Uses python3
import sys
import random

def fibonacci_partial_sum_naive(from_, to):
    sum = 0

    current = 0
    next  = 1

    for i in range(to + 1):
        if i >= from_:
            sum += current

        current, next = next, current + next

    return sum % 10


def fibonacci_partial_sum_fast(from_, to):
   
    if (from_ > to):
        print('Wrong inputs!')
        return -1

    fibonacci_mod = [0, 1]

    max_i = 0

    sum_n = 0

    for i in range(2, to + 1):
        fibonacci_mod.append(( fibonacci_mod[i-1] + fibonacci_mod[i-2] )%10)

        max_i = i

        if fibonacci_mod[i-1] == 0 and fibonacci_mod[i] == 1:
            break


    periodiclen = len(fibonacci_mod)

    if max_i < to and max_i != 0:
        periodiclen = periodiclen - 2

    remain1 = from_ % periodiclen

    remain2 = to % periodiclen

    diff = (to // periodiclen) - (from_ // periodiclen) - 1

    for i in range(remain1, periodiclen):
        sum_n = ( sum_n + fibonacci_mod[i] ) % 10

    sum1 = 0
    for i in range(periodiclen):
        sum1 =  ( sum1 + fibonacci_mod[i] )%10

    sum1 = ( sum1 * diff )%10

    sum_n = ( sum_n + sum1 )%10

    for i in range(remain2+1):
        sum_n = ( sum_n + fibonacci_mod[i] )%10

    return sum_n






if __name__ == '__main__':
    #Stress testing
    #while True:
        # Generate from_ and to

        #from_ = random.randrange(0, 1000000000000000000)
        #to = random.randrange(0, 1000000000000000000)

        #if(from_ <= to):
            #print(from_, to)
            #print(fibonacci_partial_sum_fast(from_, to))

    #input = sys.stdin.read();
    from_, to = map(int, input().split())
    print(fibonacci_partial_sum_fast(from_, to))
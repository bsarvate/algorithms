# Uses python3
import random
def calc_fib(n):
    if (n <= 1):
        return n

    return calc_fib(n - 1) + calc_fib(n - 2)


def calc_fib_fast(n):
	# create the list to store the fibonacci numbers
	if n <= 1:
		return n

	fibonacci = []

	fibonacci.append(0)
	fibonacci.append(1)

	for i in range(2, n+1):
		fibonacci.insert(i, fibonacci[i-1] + fibonacci[i-2])

	return fibonacci[n]


# Stress Test
#while(True):
	# Generate n
	#n = random.randint(0, 46)
	#print(n)

	#result1 = calc_fib(n)
	#result2 = calc_fib_fast(n)

	#if result1 != result2:
		#print('Wrong result!')
		#print(result1, ' ', result2)

	#else:
		#print('Ok')
		#print(result1, ' ', result2)

n = int(input())
print(calc_fib_fast(n))

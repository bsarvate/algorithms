import random
def max_pairwise_product(numbers, n):
	result = 0
	for i in range(n):
		for j in range(i+1, n):
			if numbers[i] * numbers[j] > result:
				result = numbers[i] * numbers[j]
	return result


def max_pairwise_product_fast(numbers, n):
	maxIndex1 = -1
	for i in range(n):
		if ((maxIndex1 == -1) or (numbers[i] > numbers[maxIndex1])):
			maxIndex1 = i

	maxIndex2 = -1
	for i in range(n):
		if ((i != maxIndex1) and ((maxIndex2 == -1) or (numbers[i] > numbers[maxIndex2]))):
			maxIndex2 = i

	return numbers[maxIndex1] * numbers[maxIndex2]


def max_pairwise_product_sorted(numbers):
	max1, max2 = sorted(numbers)[-2:]
	return max1 * max2


if __name__ == "__main__":

	# Stress Testing
	#while(True):
		# Generate n
		#n = random.randint(2, 12)
		#print(n)

		# Generate numbers
		#numbers = []
		#for i in range(n):
			#numbers.append(random.randint(0, 100000))

		#print(numbers)

		#result1 = max_pairwise_product_fast(numbers, n)
		#esult2 = max_pairwise_product_sorted(numbers)

		#if result1 != result2:
			#print('Wrong result!')
			#print(result1, ' ', result2)
			#break
		#else:
			#print('Ok')
			#print(result1, ' ', result2)



	n = int(input())
	numbers = [int(x) for x in input().split()]
	assert(len(numbers) == n)

	#print('max_pairwise_product:', max_pairwise_product(numbers, n))
	print(max_pairwise_product_fast(numbers, n))
	#print('max_pairwise_product_sorted:', max_pairwise_product_sorted(numbers))


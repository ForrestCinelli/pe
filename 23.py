# A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
#
# A number n  is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n. As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum of two abundant numbers is 24. By mathematical analysis, it can be shown that all integers greater than 28123 can be written as the sum of two abundant numbers. However, this upper limit cannot be reduced any further by analysis even though it is known that the greatest number that cannot be expressed as the sum of two abundant numbers is less than this limit.
#
# Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.

import sympy
from scipy import sparse
from itertools import product

def is_abundant(n):
    return sum(sympy.divisors(n, generator=True, proper=True)) > n

# Python 3
# python 23.py
if (__name__ == "__main__"):
    LIMIT = 28123 # upper limit on numbers that cannot be written as the sum of two abundant numbers. 
    
    # print(is_abundant(LIMIT)) # False
    abundants = list(filter(is_abundant, range(1, LIMIT))) # Without list(), our cartesian product would be empty.

    abundant_sums = sparse.lil_matrix((LIMIT, LIMIT))

    for a1 in abundants:
        for a2 in abundants:
            if a1 <= a2:
                abundant_sums[a1, a2] = a1 + a2

    nonzero_rows, nonzero_cols = abundant_sums.nonzero()
    abundant_sums_set = {abundant_sums[row, col] for row, col in zip(nonzero_rows, nonzero_cols)}

    print(sum(filter(lambda x: x not in abundant_sums_set, range(1, LIMIT))))
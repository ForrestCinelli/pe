"""
Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:
 
1634 = 1^4+6^4+3^4+4^4
8208 = 8^4+2^4+0^4+8^4
9474 = 9^4+4^4+7^4+4^4
 
As 1=1^4 is not a sum it is not included.

The sum of these numbers is 1634+8208+9474=19316.

Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
"""

def digits(n: int) -> list[int]:
    return (int(c) for c in str(n))

def is_fivepow_sum(n: int) -> bool:
    return n == sum([d**5 for d in digits(n)])

# to run: python 30.py
# usage: try sums it prints until one is correct; it has found the last number that can be 
# written as the sum of the fifth powers of its digits. 
# Then, exit with ctrl + C

if __name__ == '__main__':
    total = 0
    i = 2

    while True:
        if is_fivepow_sum(i):
            total += i
            print(f'Found fivepow sum: {i}', '\n', f'New total: {total}', '\n')
        i += 1
        if i % 1_000_000 == 0:
            print(f'i = {i}...')
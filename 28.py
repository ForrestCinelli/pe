'''
Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral is formed as follows:

21 22 23 24 25
20  7  8  9 10
19  6  1  2 11
18  5  4  3 12
17 16 15 14 13

It can be verified that the sum of the numbers on the diagonals is 101.

What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?
'''

# to run: python 28.py

position = 1
total = 1 # start at second layer to avoid counting 1 four times

for width in range(3, 1003, 2):
    for _ in range(4): # four sides on this square spiral
        position += width - 1
        total += position

print('\n', total)

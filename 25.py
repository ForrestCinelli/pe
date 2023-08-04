# The Fibonacci sequence is defined by the recurrence relation:
#
# Fn=Fn−1 + Fn−2, where F1=1 and F2=1. Hence the first 12 terms will be:
# F1=1
# F2=1
# F3=2
# F4=3
# F5=5
# F6=8
# F7=13
# F8=21
# F9=34
# F10=55
# F11=89
# F12=144
#
# The 12th term, F12, is the first term to contain three digits.
#
# What is the index of the first term in the Fibonacci sequence to contain 1000 digits?

# Python 3
# python 25.py
if __name__ == "__main__":
    thousand_digit = 10 ** 999

    i = 2
    prev = 1
    curr = 1

    while (curr < thousand_digit):
        i += 1
        tmp = curr
        curr = curr + prev # As of 2.5, Python transparently handles integer overflow by converting from computer int to big int. 
        prev = tmp

    print("Fn: " + str(curr))
    print("n: " + str(i))
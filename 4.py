# A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
# Find the largest palindrome made from the product of two 3-digit numbers.

def is_palindrome(number_str):
    if (number_str == ''):
        return True

    return number_str[0] == number_str[-1] and is_palindrome(number_str[1:-1])

if __name__ == '__main__':
    number = 999 * 999

    while number > 0:
        if is_palindrome(str(number)):
            for i in range(999, 100, -1):
                for j in range(i, 1000):
                    if (i * j == number):
                        print(str(i) + ' x ' + str(j) + ' = ' + str(number))
                        exit()
        number -= 1



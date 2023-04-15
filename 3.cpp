/*
 * The prime factors of 13195 are 5, 7, 13 and 29.
 *
 * What is the largest prime factor of the number 600851475143 ? 
 */

#include <iostream>

int main() {
        long number = 600851475143;
        int biggestFactor;

        while (number > 1) {
                // This if lets us to use a step size of 2 for the loop
                if (number % 2 == 0) {
                        biggestFactor = std::max(2, biggestFactor);
                        number = number / 2;
                        continue;
                }
    
                for (int i = 3; /* will break */ ; i += 2) {
                        if (number % i == 0) {
                                biggestFactor = std::max(i, biggestFactor);
                                number = number / i;
                                break;
                        }
                }
        }

        std::cout << biggestFactor << std::endl;
        return 0;
}

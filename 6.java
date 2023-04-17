/** The sum of the squares of the first ten natural numbers is,
 * 
 * 1^2 + 2^2 + ... + 10^2 = 385
 * 
 * The square of the sum of the first ten natural numbers is,
 *
 * (1 + 2 + ... + 10)^2 = 55^2 = 3025
 * 
 * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.
 * 
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 */

class Six 
{
    public static final int TARGET = 100;

    public static void main(String[] args)
    {
        int sumOfSquares = 0;

        for (int i = 1; i <= TARGET; i++)
        {
            sumOfSquares += i * i;
        }

        System.out.println("Sum of squares:" + sumOfSquares);

        int sumOfNumbers = TARGET * (TARGET + 1) / 2; // TY Gauss
        int squareOfSum = sumOfNumbers * sumOfNumbers;

        System.out.println("Square of sum: " + squareOfSum);

        System.out.println("Difference: " + (squareOfSum - sumOfSquares));
    }
}
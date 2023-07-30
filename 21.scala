/**
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n). 
 * If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.
 *
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
 *
 * Evaluate the sum of all the amicable numbers under 10000.
 */

// scala 3.3
// scalac 21.scala
// scala Main
object Main {
    def main(args: Array[String]): Unit = {
        println((1 to 10000).filter(isAmicable).sum)
    }

    val isAmicable: Int => Boolean = n => {
        val d = divisorSum(n)

        n != d && divisorSum(d) == n
    }

    val divisorSum: Int => Int = n => {
        (1L to Math.round(Math.ceil(n / 2))).map(_.toInt).filter(n % _ == 0).sum
    }
}
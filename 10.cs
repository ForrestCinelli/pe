/* The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * 
 * Find the sum of all the primes below two million.
 */

using System;
using System.Linq; 

/* Compile: mcs 10.cs
 * Run:     mono 10.exe
 */
namespace Ten
{
    class TenSolution {         
        static void Main(string[] args)
        {
            bool[] primeBools = EulerSieve(2_000_000);

            long sum = 2; // primeBools starts at 3
            for (int i = 0; i < primeBools.Length; i++) {
                if (primeBools[i]) {
                    sum += FromIdx(i);
                }
            }

            Console.WriteLine(sum);
        }

        private static bool[] EulerSieve(int limit)
        {
            int limitIdx = ToIdx(limit);
            bool[] odds = Enumerable.Repeat(true, limitIdx + 1).ToArray();

            int lastIdxCheck = ToIdx(Convert.ToInt32(Math.Sqrt(limit)));
            for (int i = 0; i <= lastIdxCheck; i += 1)
            {
                int iValue = FromIdx(i);
                for (int j = 0; iValue * FromIdx(i + j) < limit; j += 1)
                {
                    odds[ToIdx(iValue * (FromIdx(i + j)))] = false;
                } 
            }

            return odds;

        }

        /** 3 -> 0, 5 -> 1, and so on. */
        private static int ToIdx(int n)
        {
            return ((n - 1) / 2) - 1;
        }

        /** 0 -> 3, 1 -> 5, and so on. */
        private static int FromIdx(int i)
        {
            return ((i + 1) * 2) + 1;
        }
    }
}
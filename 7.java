/** By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 *
 * What is the 10 001st prime number?
 */

/** java 17
 *  Compile: javac 7.java
 *  Run:     java Seven
 */
class Seven
{
    public static void main(String[] args)
    {
        boolean[] bools = eulerSieve(1_000_001);

        int count = 0;
        for (int i = 0; i < bools.length; i += 1)
        {
            if (bools[i])
            {
                count += 1;
                if (count == 10_000) // -1 due to human counting not computer counting
                {
                    System.out.println(fromIdx(i));
                    break;
                }
            }
        }
    }

    private static boolean[] eulerSieve(int limit)
    {
        final int limitIdx = toIdx(limit);
        boolean[] odds = new boolean[limitIdx + 1];

        for (int i = 0; i <= limitIdx; i += 1)
        {
            odds[i] = true;
        }

        final int lastIdxCheck = toIdx((int)Math.round(Math.sqrt(limit)));
        for (int i = 0; i <= lastIdxCheck; i += 1)
        {
            int iValue = fromIdx(i);
            for (int j = 0; iValue * fromIdx(i +j) < limit; j += 1)
            {
                odds[toIdx(iValue * (fromIdx(i + j)))] = false;
            } 
        }

        return odds;

    }

    /** 3 -> 0, 5 -> 1, and so on. */
    private static int toIdx(int n)
    {
        return ((n - 1) / 2) - 1;
    }

    /** 0 -> 3, 1 -> 5, and so on. */
    private static int fromIdx(int i)
    {
        return ((i + 1) * 2) + 1;
    }
}
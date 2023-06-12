/** You are given the following information, but you may prefer to do some research for yourself.
 *
 * 1 Jan 1900 was a Monday.
 * Thirty days has September,
 * April, June and November.
 * All the rest have thirty-one,
 * Saving February alone,
 * Which has twenty-eight, rain or shine.
 * And on leap years, twenty-nine.
 * 
 * A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
 * How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
 */

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

/** java 17
 *  Compile: javac 19.java
 *  Run:     java Nineteen
 */
class Nineteen {    
    public static void main(String[] args)    
    {
        final LocalDate end = LocalDate.of(2000, Month.DECEMBER, 31);
        LocalDate date = LocalDate.of(1901, Month.JANUARY, 1);
        int numSundays = 0;

        while (date.compareTo(end) <= 0)
        {
            if (date.getDayOfWeek() == DayOfWeek.SUNDAY)
                numSundays += 1;

            date = date.plusMonths(1);
        }

        System.out.println(numSundays);
    }
}
package com.github.forrestcinelli.pe.seventeen;

/*
 * If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 * 
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?
 *
 *
 * NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. The use of "and" when writing out numbers is in compliance with British usage.
 * */

import com.ibm.icu.util.*;
import com.ibm.icu.text.*;

import java.util.Locale;

/**
 * Build: mvn package
 * Run  : java -cp target/17-1-jar-with-dependencies.jar com.github.forrestcinelli.pe.seventeen.Main
 * */
public class Main {

        /* Copied from https://github.com/unicode-org/icu/blob/main/icu4j/demos/src/com/ibm/icu/dev/demo/rbnf/RbnfSampleRuleSets.java, 
         * edited to place "and"s properly. */
        private static final String UK_ENGLISH =
        // This rule set shows the normal simple formatting rules for English
        "%simplified:\n"
               // negative number rule.  This rule is used to format negative
               // numbers.  The result of formatting the number's absolute
               // value is placed where the >> is.
        + "    -x: minus >>;\n"
               // faction rule.  This rule is used for formatting numbers
               // with fractional parts.  The result of formatting the
               // number's integral part is substituted for the <<, and
               // the result of formatting the number's fractional part
               // (one digit at a time, e.g., 0.123 is "zero point one two
               // three") replaces the >>.
        + "    x.x: << point >>;\n"
               // the rules for the values from 0 to 19 are simply the
               // words for those numbers
        + "    zero; one; two; three; four; five; six; seven; eight; nine;\n"
        + "    ten; eleven; twelve; thirteen; fourteen; fifteen; sixteen;\n"
        + "        seventeen; eighteen; nineteen;\n"
               // beginning at 20, we use the >> to mark the position where
               // the result of formatting the number's ones digit.  Thus,
               // we only need a new rule at every multiple of 10.  Text in
               // brackets is omitted if the value being formatted is an
               // even multiple of 10.
        + "    20: twenty[->>];\n"
        + "    30: thirty[->>];\n"
        + "    40: forty[->>];\n"
        + "    50: fifty[->>];\n"
        + "    60: sixty[->>];\n"
        + "    70: seventy[->>];\n"
        + "    80: eighty[->>];\n"
        + "    90: ninety[->>];\n"
               // beginning at 100, we can use << to mark the position where
               // the result of formatting the multiple of 100 is to be
               // inserted.  Notice also that the meaning of >> has shifted:
               // here, it refers to both the ones place and the tens place.
               // The meanings of the << and >> tokens depend on the base value
               // of the rule.  A rule's divisor is (usually) the highest
               // power of 10 that is less than or equal to the rule's base
               // value.  The value being formatted is divided by the rule's
               // divisor, and the integral quotient is used to get the text
               // for <<, while the remainder is used to produce the text
               // for >>.  Again, text in brackets is omitted if the value
               // being formatted is an even multiple of the rule's divisor
               // (in this case, an even multiple of 100)
        + "    100: << hundred [and >>];\n"
               // The rules for the higher numbers work the same way as the
               // rule for 100: Again, the << and >> tokens depend on the
               // rule's divisor, which for all these rules is also the rule's
               // base value.  To group by thousand, we simply don't have any
               // rules between 1,000 and 1,000,000.
        + "    1000: << thousand[ >>];\n";

    public static void main(String[] args) 
    {
        NumberFormat formatter = new RuleBasedNumberFormat(UK_ENGLISH, ULocale.UK);

        int length = 0;
        for (int i = 1; i <= 1000; i++)
        {
            length += formatter.format(i).replaceAll("\\s", "").replaceAll("-", "").length();
        }

        System.out.println(length);
    }
}
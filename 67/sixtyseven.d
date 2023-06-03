/*
 * By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.
 *
 * 3
 * 7 4
 * 2 4 6
 * 8 5 9 3
 * 
 * That is, 3 + 7 + 4 + 9 = 23.
 * 
 * Find the maximum total from top to bottom in triangle.txt (right click and 'Save Link/Target As...'), a 15K text file containing a triangle with one-hundred rows.
 * 
 * NOTE: This is a much more difficult version of Problem 18. It is not possible to try every route to solve this problem, as there are 299 altogether! If you could check one trillion (1012) routes every second it would take over twenty billion years to check them all. There is an efficient algorithm to solve it. ;o)
 */

import std.algorithm;
import std.array;
import std.conv;
import std.file;
import std.range;
import std.stdio;
import std.string;

/** 
 * https://dlang.org/rdmd.html
 * rdmd sixtyseven 
 */
void main()
{
    File file = File("0067_triangle.txt", "r");

    if (!file.isOpen)
    {
        writeln("Problem opening file");
        return;
    }

    auto lines = file.byLine();

    int[] bestPaths = [to!int(lines.take(1).front)];
    foreach (char[] line ; lines.drop(1))
    {
        int[] row = parseLine(to!string(line));

        int[] newBestPaths;
        newBestPaths.length = row.length;

        newBestPaths[0] = bestPaths[0] + row[0];

        for (int i = 1; i < row.length - 1; i++)
        {
            newBestPaths[i] = row[i] + max(bestPaths[i], bestPaths[i - 1]);
        }
        newBestPaths[$-1] = bestPaths[$-1] + row[$-1];
        bestPaths = newBestPaths;
    }

    bestPaths.reduce!(min, max)[1].writeln;
}

int[] parseLine(string line)
{
    string[] nums = line.split(" ");

    int[] row = minimallyInitializedArray!(int[])(nums.length);

    foreach (int i, string num; nums)
    {
        row[i] = to!int(num);
    }

    return row;
}

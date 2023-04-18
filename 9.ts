/* A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 *
 * a^2 + b^2 = c^2
 *
 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
 *
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 *
 * Find the product abc.
 */

/* Compile: > tsc --lib es6,dom 9.ts
 * Run:     > node 9.js 
 */

function getB(a: number): number {
    return 1000 * (a - 500) / (a - 1000);
}

function getC(a: number): number {
    return ((a * a) - (1000 * a) + 500000) / (1000 - a);
}

for (let a = 0; a < 1000; a++) {
    const b = getB(a);
    const c = getC(a);

    if (Number.isInteger(b) && Number.isInteger(c) && a < b && b < c) {
        console.log(a);
        console.log(b);
        console.log(c);
        console.log(a + b + c);

        console.log(a * b * c);
        break;
    }
}
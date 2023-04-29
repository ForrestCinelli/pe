// The following iterative sequence is defined for the set of positive integers:

// n → n/2 (n is even)
// n → 3n + 1 (n is odd)

// Using the rule above and starting with 13, we generate the following sequence:

// 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
// It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

// Which starting number, under one million, produces the longest chain?

// NOTE: Once the chain starts the terms are allowed to go above one million.

use std::collections::HashMap;

// Compile: rustc 14.rs
// Run:     ./14
fn main() {
    let mut distances: HashMap<u64, u64> = HashMap::new();
    distances.insert(1, 0);

    let mut max_distance: u64 = 0;
    let mut max_n: u64 = 1;
    for n in 2..1_000_000 {
        let n_distance: u64 = memo_collatz_length(n, &mut distances);
        if n_distance > max_distance {
            max_distance = n_distance;
            max_n = n;
        }
    }
    println!("Computed {} Collatz sequences", distances.len());
    println!("Longest: {} with {} steps", max_n, max_distance);
}

fn memo_collatz_length(n: u64, distances: &mut HashMap<u64, u64>) -> u64 {
    return match distances.get(&n) {
        Some(dist) => *dist,
        None => {
            let distance: u64 = memo_collatz_length(next_collatz(n), distances) + 1;
            distances.insert(n, distance);
            distance
        }
    }
}

fn next_collatz(n: u64) -> u64 {
    return if n % 2 == 0 {
        n / 2
    }
    else {
        (3 * n) + 1
    }
}
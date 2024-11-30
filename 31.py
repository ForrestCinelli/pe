"""
In the United Kingdom the currency is made up of pound (£) and pence (p). There are eight coins in general circulation:

1p, 2p, 5p, 10p, 20p, 50p, £1 (100p), and £2 (200p).
It is possible to make £2 in the following way:

1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
How many different ways can £2 be made using any number of coins?
"""

from typing import Generator

# python 31.py
COINS: list[int] = [1, 2, 5, 10, 20, 50, 100, 200]

class CoinPool:
    coins: list[int]
    total: int

    def __init__(self, coins: list[int], total: int):
        self.coins = coins
        self.total = total

    def plus(self, coin: int):
        return CoinPool(self.coins + [coin], self.total + coin)

def get_candidates(n: int, target: int = 200) -> Generator[CoinPool, None, None]:
    if n == 0:
        yield CoinPool([], 0)
    elif n == 1:
        for coin in COINS:
            yield CoinPool([coin], coin)
    else:
        for base in get_candidates(n - 1):
            yield base
            if len(base.coins) == n - 1:
                # because they're ordered, no duplicates to contend with.
                yield from ( base.plus(coin) for coin in COINS if coin <= base.coins[-1] and base.total < target )

if __name__ == '__main__':
    n = 200
    target = 200

    candidates: Generator[CoinPool, None, None] = get_candidates(n, target = target)

    filtered_candidates: Generator[CoinPool, None, None] = ( candidate for candidate in candidates if candidate.total == target )

    print(sum(1 for _ in filtered_candidates))

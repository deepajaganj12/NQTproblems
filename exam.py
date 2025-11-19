
import sys
from collections import defaultdict

def sieve_primes(n: int):
    """Return list of primes up to n (inclusive) using Eratosthenes."""
    if n < 2:
        return []
    bs = bytearray(b'\x01') * (n + 1)
    bs[0:2] = b'\x00\x00'
    import math
    limit = int(math.isqrt(n))
    for p in range(2, limit + 1):
        if bs[p]:
            step = p
            start = p * p
            bs[start:n+1:step] = b'\x00' * (((n - start)//step) + 1)
    return [i for i, val in enumerate(bs) if val]

def main():
    data = sys.stdin.read().strip().split()
    if not data:
        return
    it = iter(data)
    try:
        n = int(next(it))
    except StopIteration:
        return
    arr = [int(next(it)) for _ in range(n)]

    total_sum = sum(arr)
    MAX_SAFE_SIEVE = 5_000_000  

    if total_sum > MAX_SAFE_SIEVE:
        def is_prime(n: int) -> bool:
            if n < 2:
                return False
            small_primes = (2,3,5,7,11,13,17,19,23,29)
            for p in small_primes:
                if n % p == 0:
                    return n == p
        
            d = n - 1
            s = 0
            while d % 2 == 0:
                s += 1
                d //= 2
            import random
            witnesses = [2, 3, 5, 7, 11, 13]
            def check(a, s, d, n):
                x = pow(a, d, n)
                if x == 1 or x == n - 1:
                    return True
                for _ in range(s - 1):
                    x = (x * x) % n
                    if x == n - 1:
                        return True
                return False
            for a in witnesses:
                if a >= n:
                    continue
                if not check(a, s, d, n):
                    return False
            return True

        ans = 0
        P = [0] * (n + 1)
        for i in range(1, n + 1):
            P[i] = P[i-1] + arr[i-1]
        for i in range(1, n + 1):
            for j in range(i, n + 1):
                s = P[j] - P[i-1]
                if is_prime(s):
                    ans += 1
        print(ans)
        return

    primes = sieve_primes(total_sum)

    P = [0]
    cur = 0
    for v in arr:
        cur += v
        P.append(cur)

    count = defaultdict(int)
    count[0] = 1
    ans = 0
    for j in range(1, n + 1):
        pj = P[j]
        for p in primes:
            target = pj - p

            ans += count.get(target, 0)
        count[pj] += 1

    print(ans)

if __name__ == "__main__":
    main()
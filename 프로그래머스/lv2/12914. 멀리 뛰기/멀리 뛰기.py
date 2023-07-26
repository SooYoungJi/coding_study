def solution(n):
    if n == 1:
        return n % 1234567
    elif n == 2:
        return n % 1234567
    else:
        a = 1
        b = 2
        for i in range(n-2):
            a, b = b, a+b
        return b % 1234567
def solution(n):
    ans = 1
    now = n
    while now != 1:
        if now%2 == 0:
            now /= 2
        else:
            now -= 1
            now /= 2
            ans += 1
    return ans
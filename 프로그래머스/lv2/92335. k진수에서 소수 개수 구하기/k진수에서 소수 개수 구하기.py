def k_jin(n, k):
    rev = ''
    while n > 0:
        n, mod = divmod(n, k)
        rev += str(mod)
    return rev[::-1]

def is_prime(n):
    if n == 1:
        return False
    elif n == 2:
        return True
    for i in range(2, int(n**0.5) + 1):
        if n % i == 0:
            return False
    return True

def solution(n, k):
    answer = 0
    to_k = k_jin(n, k)
    nums = to_k.split('0')
    for i in nums:
        if i != '' and is_prime(int(i)):
            answer += 1
    return answer

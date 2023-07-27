def solution(k, tangerine):
    min_n, max_n = min(tangerine), max(tangerine)
    num_tan = [0]*(max_n+1)
    for i in tangerine:
        num_tan[i] += 1
    num_tan.sort(reverse = True)
    total, i = 0, 0
    while total<k:
        total += num_tan[i]
        i+=1
    return i
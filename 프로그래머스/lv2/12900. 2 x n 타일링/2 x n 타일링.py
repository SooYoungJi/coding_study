import sys
sys.setrecursionlimit(30000)

def box(n, dic):
    if n in dic:
        return dic[n]
    dic[n] = (box(n-2, dic)+box(n-1, dic))%1000000007
    return dic[n]

def solution(n):
    answer = 0
    dic = {-2: 0, -1: 0, 0: 0, 1: 1, 2: 2}
    answer = box(n, dic)
    
    return answer
import itertools

def is_sos(n, sos):
    if n in sos:
        return True
    else:
        for i in range(2, int(n**1/2)+1):
            if n % i == 0:
                return False
        sos.append(n)
        return True

def solution(numbers):
    answer = 0
    sos = [2]
    
    numbs = []
    for i in range(1, len(numbers)+1):
        t1 = itertools.permutations(numbers, i)
        t2 = [int(''.join(i)) for i in t1]
        numbs.extend(t2)
        
    numbs = set(numbs)
    
    for n in numbs:
        if n > 1 and is_sos(int(n), sos):
            answer += 1
    
    return answer
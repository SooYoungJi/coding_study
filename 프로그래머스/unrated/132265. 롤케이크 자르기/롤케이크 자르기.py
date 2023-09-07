def solution(topping):
    answer = 0
    front = set()
    back = {}
    
    for i in topping:
        if str(i) in back:
            back[str(i)] += 1
        else:
            back[str(i)] = 1
    
    for i in topping:
        front.add(i)
        back[str(i)] -= 1
        if back[str(i)] == 0:
            del back[str(i)]
        if len(front) == len(back):
            answer += 1
    
    return answer


'''
def solution(topping):
    answer = 0
    tmp = set(topping)
    t1 = []
    t2 = topping.copy()
    for i in range(len(topping)):
        tt1, tt2 = 0, 0
        t1.append(t2.pop(0))
        for j in tmp:
            if j in t1:
                tt1 += 1
            if j in t2:
                tt2 += 1
        if tt1 == tt2:
            answer += 1
    return answer

'''
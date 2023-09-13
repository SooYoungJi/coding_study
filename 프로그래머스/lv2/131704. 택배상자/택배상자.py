from collections import deque
def solution(order):
    answer, x = 0, 0
    sec = deque([])
    order = deque(order)
    while len(order):
        if len(sec) > 0 and sec[-1] == order[0]:
            answer += 1
            sec.pop()
            order.popleft()
        elif x < order[0]:
            for i in range(x+1, order[0]):
                sec.append(i)
            x = order.popleft()
            answer += 1
        else:
            return answer

    return answer


'''
def solution(order):
    answer = 0
    conv = [i+1 for i in range(len(order))]
    sec = []
    for i in order:
        keep = True
        while keep:
            if len(conv) > 0 and conv[0] == i:
                conv.pop(0)
                answer += 1
                keep = False
            elif len(conv) > 0 and conv[0] < i:
                sec.append(conv.pop(0))
            elif len(sec) > 0 and sec[-1] == i:
                sec.pop()
                answer += 1
                keep = False
            else:
                keep = False
                return answer
    return answer
'''
from collections import deque
def solution(priorities, location):
    answer = 0
    my_doc = [0 for _ in range(len(priorities))]
    my_doc[location] = 1
    queue = deque(priorities)
    while True:

        if not my_doc or max(my_doc) == 0:
            break
        if max(queue) == queue[0]:
            queue.popleft()
            del my_doc[0]
            answer += 1
        else:
            queue.append(queue[0])
            my_doc.append(my_doc[0])
            queue.popleft()
            del my_doc[0]


    return answer
    
'''  
    
    turn = []
    for i in range(len(priorities)):
        for j in range(i, len(priorities)):
            if priorities[i] < priorities[j]:
                turn.append(i)
                continue
        turn = [i] + turn
    return turn.index(location)
    
'''   
    
''' queue = deque(priorities)
    locations = []
    for i in range(len(priorities)):
        for j in range(i, len(priorities)):
            if deque[i] < deque[j]:
                temp.pop
'''

'''from queue import PriorityQueue

def solution(priorities, location):
    answer = 0
    que = PriorityQueue()
    for i in range(len(priorities)):
        que.put((priorities[i], i))
    for i in range(location+1):
        answer = que.get()
    return que.get()


   '''
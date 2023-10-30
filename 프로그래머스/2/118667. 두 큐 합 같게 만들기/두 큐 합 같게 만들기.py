from collections import deque


def solution(queue1, queue2):
    queue1 = deque(queue1)
    queue2 = deque(queue2)

    q1s =sum(queue1)
    q2s =sum(queue2)
    if q1s+q2s % 2 == 1:
        return -1
    limit = len(queue1) + len(queue2)
    count = 0
    while q1s != q2s:
        if count >= limit:
            return -1
        while queue2 and q1s < q2s:
            tmp = queue2.popleft()
            queue1.append(tmp)
            count += 1
            q2s -= tmp
            q1s += tmp

        while queue1 and q1s > q2s:
            tmp = queue1.popleft()
            queue2.append(tmp)
            count += 1
            q1s -= tmp
            q2s += tmp
    return count



'''def pop_queue(all_q, need, answer):
    for i in range(len(all_q)):
        for j in range(i, len(all_q)):
            if sum(all_q[i : j+1]) == need:
                if i < len(all_q)/2:
                    answer += i
                    if j < len(all_q)/2:
                        answer += len(all_q)/2 - (j+1)
                    elif j >= len(all_q)/2:
                        answer += (j+1) - len(all_q)/2
                else:
                    answer += i
                    answer += len(all_q) - (j+1)
                print(answer)
                return answer
    print(answer)        
    return answer

def solution(queue1, queue2):
    answer, answer1, answer2 = 0, 0, 0
    all_q1 = queue1 + queue2
    all_q2 = queue2 + queue2
    need = sum(all_q1)/2
    answer1 = pop_queue(all_q1, need, answer)
    answer2 = pop_queue(all_q2, need, answer)
    if answer1 > 0 and answer2 > 0:
        answer = min(answer1, answer2)
    elif answer1 == 0 and answer2 == 0:
        answer = -1
    else:
        answer = max(answer1, answer2)
    return answer'''
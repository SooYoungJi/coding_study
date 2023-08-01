'''def solution(citations):
    answer = 0
    citations.sort()
    for i in range(len(citations)-1, 0, -1):
        h = len(citations)-i
        if citations[i] >= h:
            answer = h
    return answer'''

def solution(citations):
    answer = 0
    citations.sort(reverse=True)
    for i in citations:
        if i>answer:
            answer+=1
    return answer
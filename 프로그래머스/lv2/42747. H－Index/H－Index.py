def solution(citations):
    answer = 0
    citations.sort()
    for i in range(len(citations)):
        h = len(citations)-i
        if citations[i] >= h:
            return h
    return 0

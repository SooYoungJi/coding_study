def solution(s):
    answer = 0
    for i in range(len(s)):
        temp = s[i:] + s[:i]
        queue = []
        for j in temp:
            if j == '(' or j == '{' or j == '[' or len(queue) == 0:
                queue.append(j)
            elif (j == ')' and queue[-1] == '(') or (j == '}' and queue[-1] == '{') or (j == ']' and queue[-1] == '['):
                queue.pop()
        if len(queue) == 0:
            answer += 1
    return answer
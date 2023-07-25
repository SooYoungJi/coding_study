def solution(arr):
    answer = 1
    for i in range(len(arr)):
        for j in range(max(answer, arr[i]), answer*arr[i]+1):
            if j%answer == 0 and j%arr[i] == 0:
                answer = j
                break
    return answer
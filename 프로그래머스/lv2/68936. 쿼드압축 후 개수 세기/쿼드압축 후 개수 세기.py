def solution(arr):
    answer = [0, 0]
    N = len(arr)
    is_all_1 = all(all(num == 1 for num in i) for i in arr)
    is_all_0 = all(all(num == 0 for num in i) for i in arr)
    
    if N == 2 or is_all_1 or is_all_0:
        if is_all_1 or is_all_0:
            if arr[0][0] == 0:
                answer = [1, 0]
            else:
                answer = [0, 1]
        elif N == 2:
            count_0 = sum(row.count(0) for row in arr)
            count_1 = sum(row.count(1) for row in arr)
            answer = [count_0, count_1]

        return answer
    
    while not is_all_1 and not is_all_0:
        count_0 = sum(row.count(0) for row in arr)
        count_1 = sum(row.count(1) for row in arr)
        
        rect_1 = [arr[i][:N//2] for i in range(N//2)]
        rect_2 = [arr[i][N//2:] for i in range(N//2)]
        rect_3 = [arr[i][:N//2] for i in range(N//2, N)]
        rect_4 = [arr[i][N//2:] for i in range(N//2, N)]
        
        answer1 = solution(rect_1)
        answer2 = solution(rect_2)
        answer3 = solution(rect_3)
        answer4 = solution(rect_4)
        
        answer[0] = answer1[0] + answer2[0] + answer3[0] + answer4[0]
        answer[1] = answer1[1] + answer2[1] + answer3[1] + answer4[1]
        
        return answer
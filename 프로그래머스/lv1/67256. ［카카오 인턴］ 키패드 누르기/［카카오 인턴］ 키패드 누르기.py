def solution(numbers, hand):
    answer = ''
    key = {1:[0, 0], 2:[0, 1], 3:[0, 2], 4:[1, 0], 5:[1, 1], 6:[1, 2], 7:[2, 0], 8:[2, 1], 9:[2, 2], "*":[3, 0], 0:[3, 1], "#":[3, 2]}
    left = [3, 0]
    right = [3, 2]
    
    for i in numbers:
        if key[i][1] == 0:
            answer += "L"
            left = key[i]
        elif key[i][1] == 2:
            answer += "R"
            right = key[i]
        else:
            r = abs(right[0]-key[i][0]) + abs(right[1]-key[i][1])
            l = abs(left[0]-key[i][0]) + abs(left[1]-key[i][1])
            if r > l:
                answer += "L"
                left = key[i]
            elif r < l:
                answer += "R"
                right = key[i]
            else:
                if hand =='right':
                    answer += "R"
                    right = key[i]
                else:
                    answer += "L"
                    left = key[i]
    return answer
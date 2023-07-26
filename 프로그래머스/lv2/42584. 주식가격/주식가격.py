def solution(prices):
    answer = []
    for i in range(len(prices)):
        temp = 0
        if i  == len(prices)-1:
            answer.append(temp)
            return answer
        else:
            for j in range(i+1, len(prices)):
                temp += 1
                if j == len(prices)-1:
                    answer.append(temp)
                elif prices[i] > prices[j]:
                    answer.append(temp)
                    break
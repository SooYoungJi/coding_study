def solution(numbers):
    answer = [-1] * len(numbers)
    stack = []

    for idx, number in enumerate(numbers):
        while stack and numbers[stack[-1]] < number:
            answer[stack.pop()] = number

        stack.append(idx)

    return answer


'''def solution(numbers):
    answer = [0 for _ in numbers]
    i = -1
    while numbers:
        i += 1
        now = numbers.pop(0)
        for j in range(len(numbers)):
            if now < numbers[j]:
                answer[i] = numbers[j]
                break
            elif j == len(numbers)-1:
                answer[i] = -1
                break
    answer[-1] = -1
    return answer
   '''
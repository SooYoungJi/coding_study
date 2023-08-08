def solution(clothes):
    answer = 1
    cloth_dict = {}
    for i in clothes:
        if i[1] not in cloth_dict:
            cloth_dict[i[1]] = 1
        elif i[1] in cloth_dict:
            cloth_dict[i[1]] += 1
    for i in cloth_dict:
        answer *= (cloth_dict[i]+1)
    return answer-1
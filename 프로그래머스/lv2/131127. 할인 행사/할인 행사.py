def solution(want, number, discount):
    answer = 0
    default_dict = {}
    for k in range(len(want)):
        default_dict[want[k]] = number[k]
    for j in range(len(discount)-9):
        want_dict = default_dict.copy()
        for i in range(j, j+10):
            if discount[i] not in want_dict:
                continue
            elif want_dict[discount[i]] > 0:
                want_dict[discount[i]] -= 1
            if want_dict[discount[i]] == 0:
                del want_dict[discount[i]]
            if len(want_dict) == 0:
                answer += 1
    return answer
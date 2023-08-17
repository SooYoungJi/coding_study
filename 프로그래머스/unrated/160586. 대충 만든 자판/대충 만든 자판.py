def solution(keymap, targets):
    answer = []
    keys = {}
    for i in range(len(keymap)):
        for j in range(len(keymap[i])):
            if keymap[i][j] not in keys:
                keys[keymap[i][j]] = j+1
            elif keymap[i][j] in keys:
                keys[keymap[i][j]] = min(keys[keymap[i][j]], j+1)
    for i in targets:
        temp = 0
        for j in i:
            if j in keys:
                temp += keys[j]
            elif j not in keys:
                temp = -1
                answer.append(temp)
                break
        if temp >= 0:
            answer.append(temp)
    return answer
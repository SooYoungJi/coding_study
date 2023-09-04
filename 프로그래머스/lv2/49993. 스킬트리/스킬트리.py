def solution(skill, skill_trees):
    answer = 0
    skill_list = [i for i in skill]
    for i in skill_trees:
        skilled = True
        temp = skill_list.copy()
        for j in range(len(i)):
            if i[j] in temp:
                if i[j] == temp[0]:
                    temp.pop(0)
                else:
                    skilled = False
        if skilled:
            answer += 1

    return answer
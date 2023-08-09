def solution(s):
    answer = set()
    result = []
    srcs = s[2:-2].split('},{')
    srcs.sort(key=lambda x : len(x))
    for src in srcs:
        temp = set(list(map(int, src.split(','))))
        result = result + list(set.difference(temp, answer))
        answer=temp

    return result




"""def solution(s):
    answer = []
    opened = False
    l = []
    onenum = ""
    for i in s:
        if i == "{" and opened == False:
            opened = True
            temp = ''
        elif i.isdigit() and opened == True:
            temp += i
        elif i == "," and opened == True:
            temp += ' '
        elif i == "}" and opened == True:
            opened = False
            temp_l = list(map(int, temp.split()))
            l.append(temp_l)
            
    for i in l:
        for j in i:
            if j in answer:
                continue
            else:
                answer.append(j)
    return answer"""
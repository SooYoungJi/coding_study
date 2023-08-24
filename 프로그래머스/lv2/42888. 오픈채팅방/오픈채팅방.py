def solution(record):
    answer = []
    ids = {}
    in_out = {}
    lines = []
    for i in record:
        temp = i.split(' ')
        if temp[0] == 'Enter':
            ids[temp[1]] = temp[2]
            lines.append(temp[1]+'님이 들어왔습니다.')
        elif temp[0] == 'Leave':
            lines.append(temp[1]+'님이 나갔습니다.')
        elif temp[0] == 'Change':
            ids[temp[1]] = temp[2]
    
    for i in lines:
        temp = i.split(' ')
        if temp[1] == '들어왔습니다.':
            name = ids[i[:-10]]
            answer.append(name+'님이 들어왔습니다.')
        elif temp[1] == '나갔습니다.':
            name = ids[i[:-9]]
            answer.append(name+'님이 나갔습니다.')
    return answer
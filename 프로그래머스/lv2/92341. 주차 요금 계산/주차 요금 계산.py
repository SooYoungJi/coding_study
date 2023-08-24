import math

def solution(fees, records):
    answer = []
    ins = {}
    times = {}
    left = {}
    answers = {}
    for i in records:
        temp = i.split(' ')
        if temp[2] == "IN":
            ins[temp[1]] = temp[0]
            left[temp[1]] = True
            
        elif temp[2] == "OUT":
            if temp[1] not in times:
                times[temp[1]] = (int(temp[0][:2]) - int(ins[temp[1]][:2])) * 60 + (int(temp[0][3:]) - int(ins[temp[1]][3:]))
            else:
                times[temp[1]] += (int(temp[0][:2]) - int(ins[temp[1]][:2])) * 60 + (int(temp[0][3:]) - int(ins[temp[1]][3:]))
            left[temp[1]] = False
    for i in left:
        if left[i]:
            if i not in times:
                times[i] = (23 - int(ins[i][:2])) * 60 + (59 - int(ins[i][3:]))
            else:
                times[i] += (23 - int(ins[i][:2])) * 60 + (59 - int(ins[i][3:]))
            
            left[i] = False

    for i in times:
        if times[i] > fees[0]:
            fee = fees[1] + math.ceil((times[i] - fees[0]) / fees[2]) * fees[3]
            answer.append([i, fee])
        else:
            answer.append([i, fees[1]])
    answer.sort()
    results = []
    for i in answer:
        results.append(i[1])
    return results
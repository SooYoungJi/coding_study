def solution(elements):
    part = set()
    whole = elements+elements
    for i in range(1, len(elements)+1):
        for j in range(len(elements)):
            temp = sum(whole[j:j+i])
            part.add(temp)   
    return len(part)
def solution(str1, str2):
    answer = 0
    a = []
    b = []
    inter = []
    for i in range(len(str1)-1):
        temp = str1[i:i+2]
        if temp.isalpha():
            a.append(temp.upper())
    for i in range(len(str2)-1):
        temp = str2[i:i+2]
        if temp.isalpha():
            b.append(temp.upper())
    b2 = b.copy()
    for i in a:
        if i in b2:
            inter.append(i)
            b2.pop(b2.index(i))
            
    union = a + b
    for i in inter:
        union.pop(union.index(i))
    if len(union) == 0:
        return 65536
    return int(len(inter)/len(union)*65536)

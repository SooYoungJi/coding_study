def to_jin(t, n):
    dic = {0:'0', 1:'1', 2:'2', 3:'3', 4:'4', 5:'5', 6:'6', 7:'7', 8:'8', 9:'9', 10:'A', 11:'B', 12:'C', 13:'D', 14:'E', 15:'F'}
    jin = ''
    if t == 0:
        return '0'
    while t > 0:
        t, mod = divmod(t, n)
        jin += dic[mod]
    return jin[::-1]

def solution(n, t, m, p):
    answer = ''
    pool = []
    i = 0
    while len(pool) < m*(t+1)+1:
        temp = to_jin(i, n)
        for j in temp:
            pool.append(j)
        i += 1
    return ''.join(pool[p-1::m][:t])

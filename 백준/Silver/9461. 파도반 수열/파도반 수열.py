T = int(input())

P = list()

P.append(0)
P.append(1)
P.append(1)
P.append(1)
P.append(2)
P.append(2)

for i in range(6, 101):
    P.append(P[i-1]+P[i-5])

for i in range(T):
    N = int(input())
    print(P[N])
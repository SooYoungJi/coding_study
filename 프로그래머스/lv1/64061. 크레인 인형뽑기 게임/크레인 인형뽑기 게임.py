def solution(board, moves):
    answer = 0
    col = []
    for i in range(len(board)):
        temp = []
        for j in range(len(board)):
            if board[j][i] != 0:
                temp.append(board[j][i])
        col.append(temp)
    
    bag = []
    
    for i in moves:
        if len(col[i-1]) > 0:
            t = col[i-1].pop(0)
            if len(bag)>0 and bag[-1] == t:
                #print(1, answer, t, bag)
                bag.pop()
                answer += 2
                #print(2, answer, t, bag)
            else:
                bag.append(t)
                #print(3, answer, t, bag)
        
    return answer
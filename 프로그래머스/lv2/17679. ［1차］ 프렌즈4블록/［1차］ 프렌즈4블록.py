def check_ans(m, n, game, check):
    for i in range(m-1):
        for j in range(n-1):
            if game[i][j] != 0 and game[i][j] == game[i+1][j] and game[i][j+1] == game[i+1][j+1] and game[i][j+1] == game[i+1][j]:
                check[i][j], check[i+1][j], check[i][j+1], check[i+1][j+1] = 1, 1, 1, 1
    return check

def solution(m, n, board):
    answer = 0
    
    game = []
    for i in range(m):
        game.append([j for j in board[i]])
    
    changed = True
    
    
    while changed:
        changed = False
        default = [[0]*n for i in range(m)]
        check = [[0]*n for i in range(m)]
        if default != check_ans(m, n, game, check):
            changed = True
            for i in range(m):
                for j in range(n):
                    if check[i][j] == 1:
                        check[i][j] = 0
                        answer += 1
                        if i == 0:
                            game[i][j] = 0
                        else:
                            for k in range(i, -1, -1):
                                if k == 0:
                                    game[k][j] = 0
                                else:
                                    game[k][j] = game[k-1][j]
                                    game[k-1][j] = 0          
    return answer
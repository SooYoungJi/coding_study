from collections import deque

def BFS(sr, sc, board):

    dr = [-1, 1, 0, 0]
    dc = [0, 0, -1, 1]
    
    queue = deque([(sr, sc)])

    while queue:
        cr, cc = queue.popleft()
        for i in range(4):
            nr = cr + dr[i]
            nc = cc + dc[i]
            if 0 <= nr < N and 0 <= nc < M and board[nr][nc] == 1:
                queue.append((nr, nc))
                board[nr][nc] = 0
    return board


T = int(input())

for tc in range(T):
    N, M, K = map(int, input().split())
    board = [0 for _ in range(N)]
    for i in range(N):
        board[i] = [0 for _ in range(M)]
    
    for k in range(K):
        r, c = map(int, input().split())
        board[r][c] = 1
    
    count = 0
    for r in range(N):
        for c in range(M):
            if(board[r][c] > 0):
                board = BFS(r, c, board)
                count += 1

    print(count)
MAX = 1_000_000
INF = float('inf')

def solution(x, y, n):
    answer = 0
    
    dp = [INF] * (MAX+1)
    dp[x] = 0
    
    for i in range(x, y):
        if dp[y] != INF:
            return dp[y]
        
        for new_n in (i+n, i*2, i*3):
            if MAX < new_n:
                continue
            dp[new_n] = min(dp[new_n], dp[i]+1)
        
    return dp[y] if dp[y] != INF else -1
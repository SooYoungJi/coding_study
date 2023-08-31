def solution(dirs):
    answer = 1
    dx = {"U": 0, "D": 0, "R": 1, "L": -1}
    dy = {"U": 1, "D": -1, "R": 0, "L": 0}
    track = []
    start = [0, 0]
    track.append(start)
    x, y = start[0], start[1]
    for i in dirs:
        if -5 <= x+dx[i] <= 5 and -5 <= y+dy[i] <= 5:
            x += dx[i]
            y += dy[i]
            track.append([x, y])
            
    for i in range(1, len(track)-1):
        match = False
        for j in range(0, i):
            if track[i:i+2] == track[j:j+2] or track[i+1:i-1:-1] == track[j:j+2]:
                match = True
        if match == False:
            answer += 1
    return answer
'''from collections import deque
def solution(bridge_length, weight, truck_weights):
    time = 0
    bridge = {}
    for i in range(1, weight+1):
        bridge[i] = 0
    
    now = 0
    while True:
        time += 1
        if now + truck_weights[0] <= weight:
            
        
    return time'''





from collections import deque
def solution(bridge_length, weight, truck_weights):
    time = 0
    fix = truck_weights.copy()
    truck_weights = deque(truck_weights)
    bridge = deque([0 for i in range(bridge_length)])
    now, after = 0, 0
    
    while after < len(fix):
        time += 1
        p = bridge.pop()
        if p > 0:
            after += 1
            now -= p
        bridge.appendleft(0)
        if len(truck_weights) and now + truck_weights[0] <= weight:
            t = truck_weights.popleft()
            now += t
            bridge[0] = t
        
    return time

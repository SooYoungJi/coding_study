from collections import deque
def solution(bridge_length, weight, truck_weights):
    now, after, time = 0, 0, 0
    fix = truck_weights.copy()
    truck_weights = deque(truck_weights)
    bridge = deque([0 for i in range(bridge_length)])
    
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

def solution(cacheSize, cities):
    answer = 0
    cache = [0]*cacheSize
    if cacheSize == 0:
        return 5*len(cities)
    for i in cities:
        i = i.lower()
        if i in cache:
            cache.pop(cache.index(i))
            cache.append(i)
            answer += 1
        elif len(cache) == cacheSize:
            cache.pop(0)
            cache.append(i)
            answer += 5
        else:
            cache.append(i)
            answer += 5
    return answer
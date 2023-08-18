def solution(s, skip, index):
    answer = ''
    skip_num = []
    for i in skip:
        skip_num.append(ord(i))
    for i in s:
        now = ord("a") + (ord(i) - ord("a")) % 26
        left_index = index
        while left_index > 0:
            now = ord("a") + (now + 1 - ord("a")) % 26
            if now not in skip_num:
                left_index -= 1
        answer += chr(now)
    return answer
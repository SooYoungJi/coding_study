def solution(word):
    answer = 0
    words = ['A', 'E', 'I', 'O', 'U']
    index = [781, 156, 31, 6, 1]
    for i in range(len(word)):
        answer += (words.index(word[i])) * index[i]
    answer += len(word)
    return answer
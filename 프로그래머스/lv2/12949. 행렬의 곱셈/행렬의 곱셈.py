def solution(arr1, arr2):
    #answer = [[0]*len(arr2[0])]*len(arr1)
    answer = []
    for i in range(len(arr1)):
        temp = []
        for j in range(len(arr2[0])):
            temp.append(sum(arr1[i][x]*arr2[x][j] for x in range(len(arr2))))
        answer.append(temp)
    return answer
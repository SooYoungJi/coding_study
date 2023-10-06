def solution(number, k):
    answer = ''
    max_len = len(number) - k
    stack = []
    pop = 0
    for i in number:
        while 0 < len(stack) <= max_len and int(stack[-1]) < int(i) and pop < k:
            stack.pop()
            pop += 1
        if len(stack) < max_len:
            stack.append(i)
        #print(i, stack)
    return ''.join(stack)


'''
def solution(number, k):
    answer = ''
    nums = [int(number[i]) for i in range(len(number))]
    i = 0
    while k > 0:
        if i+1 < len(nums) and nums[i] < nums[i+1]:
            nums.pop(i)
            k -= 1
        else:
            i += 1
            if i == len(nums):
                i = 0
    return ''.join([str(i) for i in nums])
    '''
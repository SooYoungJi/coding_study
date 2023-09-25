def solution(numbers):
    answer = ''
    nums = [str(i) for i in numbers]
    nums.sort(reverse=True, key = lambda x:x*3)
    return '0' if ''.join(nums)[0] == '0' else ''.join(nums)

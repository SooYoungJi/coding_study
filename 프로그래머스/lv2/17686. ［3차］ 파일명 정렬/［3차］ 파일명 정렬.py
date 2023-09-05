import re


def solution(file_names):
    filt = re.compile(r'([a-zA-Z\-\n\s.]+)([0-9]{0,5})(.*)')
    files = []
    for file_name in file_names:
        files.extend(filt.findall(file_name))
    files.sort(key=lambda x: (x[0].lower(), int(x[1])))
    answer = [''.join(i) for i in files]
    return answer








'''def solution(files):
    answer = []
    file_split = []
    n = 0
    for i in files:
        temp = []
        mark = 0
        for j in range(len(i)):
            if i[j].isdigit() and len(temp) == 0:
                temp.append(i[:j].lower())
                mark = j
            elif len(temp) > 0 and j == len(i)-1 and i[j].isdigit():
                temp.append(int(i[mark:]))
                temp.append(' ')
                temp.append(n)
                n += 1
                file_split.append(temp)
                break
            elif len(temp) > 0 and j-mark >= 5 and i[j].isdigit():
                temp.append(int(i[mark:j]))
                temp.append(i[j:])
                temp.append(n)
                n += 1
                file_split.append(temp)
                break
                
            elif len(temp) > 0 and not i[j].isdigit():
                temp.append(int(i[mark:j]))
                temp.append(i[j:])
                temp.append(n)
                n += 1
                file_split.append(temp)
                break
    file_split.sort(key = lambda x:(x[0], x[1]))

    for i in file_split:
        answer.append(files[i[-1]])
    return answer
'''
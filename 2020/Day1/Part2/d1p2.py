arr = []
sol = 0

inFile = open('input', 'r')
lines = inFile.readlines()

for line in lines:
    line = (int)(line.strip())
    arr.append(line)

for first in arr:
    for second in arr:
        for third in arr:
            if first + second + third == 2020:
                sol = first*second*third
                break
        if sol != 0:
            break
    if sol != 0:
        print(sol)
        break
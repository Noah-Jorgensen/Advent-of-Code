arr = []
sol = 0

inFile = open('input', 'r')
lines = inFile.readlines()

for line in lines:
    line = (int)(line.strip())
    arr.append(line)

for first in arr:
    for second in arr:
        if first + second == 2020:
            sol = first*second
            break
    if sol != 0:
        print(sol)
        break
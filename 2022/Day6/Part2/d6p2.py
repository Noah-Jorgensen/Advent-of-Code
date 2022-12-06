inFile = open('input', 'r')
line = inFile.read().strip()
inFile.close()

def find_duplicate(line_segment):
    max_count = 0
    for char in set(line_segment):
        cur_count = line_segment.count(char)
        if cur_count > max_count:
            max_count = cur_count
    if max_count >= 2:
        return False
    if max_count == 1:
        return True

segment_length = 14
check = False
for index, char in enumerate(line):
    segment = str(line[index:index+segment_length])
    check = find_duplicate(segment)
    if check:
        print("Signal at segment '" + segment + "' with index " + str(index+segment_length))
        break
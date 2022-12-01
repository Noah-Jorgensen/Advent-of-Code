larger_tally = 0
prev_tally = 0
curr_tally = 0
arr = []
File.readlines('input').each do |line|
    arr.append(line)
end

arr.each_with_index do |line, index|
    if index == 0
        prev_tally = Integer(line) + Integer(arr[index+1]) + Integer(arr[index+2])
    end

    if !arr[index+2].nil?
        curr_tally = Integer(line) + Integer(arr[index+1]) + Integer(arr[index+2])
        if curr_tally > prev_tally
            larger_tally+=1
        end
        prev_tally = curr_tally 
    end
end
puts(larger_tally)
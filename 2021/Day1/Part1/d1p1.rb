larger_tally = 0
prev = 0
curr = 0
File.readlines('input').each_with_index do |line, index|
    if index == 0
        prev = Integer(line)
    end
    
    curr = Integer(line)
    if curr > prev
        larger_tally+=1
    end
    prev = curr 
end
puts(larger_tally)
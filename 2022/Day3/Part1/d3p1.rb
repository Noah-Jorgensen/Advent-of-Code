arr = []
File.readlines('input').each do |line|
    arr.append(line)
end

lower = "abcdefghijklmnopqrstuvwxyz" #1-26
upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" #27-52
total = 0
arr.each do |line|
    len = (line.length)-1
    compartment_one = line[0..(len/2)-1]
    compartment_two = line[(len/2)..-1]
    
    found = []
    compartment_one.each_char do |char_one|
        compartment_two.each_char do |char_two|
            if char_one == char_two
                if !found.include?(char_one)
                    found.append(char_one)
                end
            end
        end
    end

    found.each do |char|
        if lower.include? char
            total += (lower.index(char))+1
        elsif upper.include? char
            total += (upper.index(char))+26+1
        end
    end
end
puts(total)
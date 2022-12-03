arr = []
File.readlines('input').each do |line|
    arr.append(line)
end

lower = "abcdefghijklmnopqrstuvwxyz" #1-26
upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" #27-52
total = 0

arr.each_with_index do |line, index|
    if index % 3 == 0
        in_group_one = line.strip
        in_group_two = (arr[index+1]).strip
        in_group_three = (arr[index+2]).strip

        found = []
        in_group_one.each_char do |char_one|
            in_group_two.each_char do |char_two|
                in_group_three.each_char do |char_three|
                    if char_one == char_two && char_one == char_three
                        if !found.include?(char_one)
                            found.append(char_one)
                        end
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
end
puts(total)
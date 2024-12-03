use std::fs::File;
use std::io::{BufRead, BufReader};
use std::collections::HashMap;

fn main() {
    let (mut left_nums, mut right_nums) = (Vec::new(), Vec::new());

    BufReader::new(File::open("input").unwrap()).lines().for_each(|line| {
        let current_line: Vec<i32> = line.unwrap()
            .split_whitespace()
            .map(|num| num.parse().unwrap())
            .collect();
        left_nums.push(current_line[0]); 
        right_nums.push(current_line[1]);
    });

    let mut right_counts = HashMap::new();
    for &num in &right_nums {
        *right_counts.entry(num).or_insert(0) += 1;
    }

    let similarity_score: i32 = left_nums.iter()
        .map(|&num| num * right_counts.get(&num).unwrap_or(&0))
        .sum();

    println!("{}", similarity_score);
}

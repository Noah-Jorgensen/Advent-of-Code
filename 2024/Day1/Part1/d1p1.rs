use std::fs::File;
use std::io::{BufRead, BufReader};

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

    left_nums.sort();
    right_nums.sort();

    let total_distance: i32 = left_nums.iter()
        .zip(right_nums.iter())
        .map(|(left, right)| (left - right).abs())
        .sum();

    println!("{}", total_distance);
}

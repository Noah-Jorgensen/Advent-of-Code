use std::fs::File;
use std::io::{BufRead, BufReader};

fn is_safe(levels: &Vec<i32>) -> bool {
    let mut is_increasing = true;
    let mut is_decreasing = true;
    let mut is_safe = true;

    for i in 0..levels.len() - 1 {
        let diff = (levels[i] - levels[i + 1]).abs();
        if diff < 1 || diff > 3 {
            is_safe = false;
            break;
        }

        if levels[i] < levels[i + 1] {
            is_decreasing = false;
        }
        if levels[i] > levels[i + 1] {
            is_increasing = false;
        }
    }

    is_safe && (is_increasing || is_decreasing)
}

fn main() {
    let mut safe_reports = 0;

    BufReader::new(File::open("input").unwrap()).lines().for_each(|line| {
        let levels: Vec<i32> = line.unwrap()
            .split_whitespace()
            .map(|num| num.parse().unwrap())
            .collect();

        if is_safe(&levels) {
            safe_reports += 1;
        }
    });

    println!("{}", safe_reports);
}

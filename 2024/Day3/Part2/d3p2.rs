use std::fs::File;
use std::io::{BufRead, BufReader};
use regex::Regex;

pub fn run() {
    let mut total = 0;
    let mut enabled = true;

    let re = Regex::new(r"(mul\((\d{1,3}),(\d{1,3})\))|(do\(\))|(don't\(\))").unwrap();

    BufReader::new(File::open("src/input").unwrap()).lines().for_each(|line| {
        let line = line.unwrap();

        for cap in re.captures_iter(&line) {
            if let Some(_mul_match) = cap.get(1){ // Check for mul() match
                if enabled {
                    let x: i32 = cap[2].parse().unwrap();
                    let y: i32 = cap[3].parse().unwrap();

                    total += x * y;
                }
            } else if let Some(_do_match) = cap.get(4) { // Check for do() match
                enabled = true;
            } else if let Some(_dont_match) = cap.get(5) { // Check for don't() match
                enabled = false;
            }
        }
    });

    println!("{}", total);
}

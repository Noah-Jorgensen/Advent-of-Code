use std::fs::File;
use std::io::{BufRead, BufReader};
use regex::Regex;

pub fn run() {
    let mut total = 0;

    let re = Regex::new(r"mul\((\d{1,3}),(\d{1,3})\)").unwrap();

    BufReader::new(File::open("src/input").unwrap()).lines().for_each(|line| {
        let line = line.unwrap();
        
        for cap in re.captures_iter(&line) {
            let x: i32 = cap[1].parse().unwrap();
            let y: i32 = cap[2].parse().unwrap();
            
            total += x * y;
        }
    });

    println!("{}", total);
}

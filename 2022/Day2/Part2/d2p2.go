package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	inFile, _ := os.Open("input")
	scanner := bufio.NewScanner(inFile)

	lines := []string{}
	for scanner.Scan() {
		line := scanner.Text()
		lines = append(lines, line)
	}

	var X_Rock, Y_Paper, Z_Scissors int = 1, 2, 3
	var lose, draw, win int = 0, 3, 6
	var current_score int = 0
	var scores []int
	for _, rps := range lines {
		var their_choice = string(rps[0])
		var outcome_needed = string(rps[2])
		if their_choice == "A" {
			if outcome_needed == "X" {
				current_score = lose + Z_Scissors
				scores = append(scores, current_score)
				current_score = 0
			} else if outcome_needed == "Y" {
				current_score = draw + X_Rock
				scores = append(scores, current_score)
				current_score = 0
			} else if outcome_needed == "Z" {
				current_score = win + Y_Paper
				scores = append(scores, current_score)
				current_score = 0
			}
		} else if their_choice == "B" {
			if outcome_needed == "X" {
				current_score = lose + X_Rock
				scores = append(scores, current_score)
				current_score = 0
			} else if outcome_needed == "Y" {
				current_score = draw + Y_Paper
				scores = append(scores, current_score)
				current_score = 0
			} else if outcome_needed == "Z" {
				current_score = win + Z_Scissors
				scores = append(scores, current_score)
				current_score = 0
			}
		} else if their_choice == "C" {
			if outcome_needed == "X" {
				current_score = lose + Y_Paper
				scores = append(scores, current_score)
				current_score = 0
			} else if outcome_needed == "Y" {
				current_score = draw + Z_Scissors
				scores = append(scores, current_score)
				current_score = 0
			} else if outcome_needed == "Z" {
				current_score = win + X_Rock
				scores = append(scores, current_score)
				current_score = 0
			}
		}
	}

	var total int = 0
	for _, score := range scores {
		total += score
	}
	fmt.Println(total)
}

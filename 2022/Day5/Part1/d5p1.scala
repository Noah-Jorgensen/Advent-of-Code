import scala.io.Source
import scala.collection.mutable.ListBuffer

object d5p1 {
    def main(args: Array[String]) = {
        val startingStacks_file: String = "input_stacks_modified"
        val instructions_file: String = "input_instrs"

        var stack_one = ListBuffer[String]()
        var stack_two = ListBuffer[String]()
        var stack_three = ListBuffer[String]()
        var stack_four = ListBuffer[String]()
        var stack_five = ListBuffer[String]()
        var stack_six = ListBuffer[String]()
        var stack_seven = ListBuffer[String]()
        var stack_eight = ListBuffer[String]()
        var stack_nine = ListBuffer[String]()
        for ((stack_line, index) <- (Source.fromFile(startingStacks_file).getLines).zipWithIndex) {
            index match {
                case 0 => { for (crate_char <- stack_line) { stack_one ++= ListBuffer(stack_line) } }
                case 1 => { for (crate_char <- stack_line) { stack_two ++= ListBuffer(stack_line) } }
                case 2 => { for (crate_char <- stack_line) { stack_three ++= ListBuffer(stack_line) } }
                case 3 => { for (crate_char <- stack_line) { stack_four ++= ListBuffer(stack_line) } }
                case 4 => { for (crate_char <- stack_line) { stack_five ++= ListBuffer(stack_line) } }
                case 5 => { for (crate_char <- stack_line) { stack_six ++= ListBuffer(stack_line) } }
                case 6 => { for (crate_char <- stack_line) { stack_seven ++= ListBuffer(stack_line) } }
                case 7 => { for (crate_char <- stack_line) { stack_eight ++= ListBuffer(stack_line) } }
                case 8 => { for (crate_char <- stack_line) { stack_nine ++= ListBuffer(stack_line) } }
            }
        }

        var instruction_lines = ListBuffer[String]()
        for (instr_line <- Source.fromFile(instructions_file).getLines) {
            instruction_lines ++= ListBuffer(instr_line)
        }

        for (line <- instruction_lines) {
            val amount_to_move = (line.split(" ")(1)).toInt
            val move_from = (line.split(" ")(3)).toInt
            val move_to = (line.split(" ")(5)).toInt

            move_from match {
                case 1 => {
                    val move = stack_one(0).takeRight(amount_to_move)
                    move_to match {
                        case 2 => { stack_two(0) ++= move.reverse }
                        case 3 => { stack_three(0) ++= move.reverse }
                        case 4 => { stack_four(0) ++= move.reverse }
                        case 5 => { stack_five(0) ++= move.reverse }
                        case 6 => { stack_six(0) ++= move.reverse }
                        case 7 => { stack_seven(0) ++= move.reverse }
                        case 8 => { stack_eight(0) ++= move.reverse }
                        case 9 => { stack_nine(0) ++= move.reverse }
                    }
                    stack_one(0) = stack_one(0).dropRight(amount_to_move)
                }
                case 2 => {
                    val move = stack_two(0).takeRight(amount_to_move)
                    move_to match {
                        case 1 => { stack_one(0) ++= move.reverse }
                        case 3 => { stack_three(0) ++= move.reverse }
                        case 4 => { stack_four(0) ++= move.reverse }
                        case 5 => { stack_five(0) ++= move.reverse }
                        case 6 => { stack_six(0) ++= move.reverse }
                        case 7 => { stack_seven(0) ++= move.reverse }
                        case 8 => { stack_eight(0) ++= move.reverse }
                        case 9 => { stack_nine(0) ++= move.reverse }
                    }
                    stack_two(0) = stack_two(0).dropRight(amount_to_move)
                }
                case 3 => {
                    val move = stack_three(0).takeRight(amount_to_move)
                    move_to match {
                        case 1 => { stack_one(0) ++= move.reverse }
                        case 2 => { stack_two(0) ++= move.reverse }
                        case 4 => { stack_four(0) ++= move.reverse }
                        case 5 => { stack_five(0) ++= move.reverse }
                        case 6 => { stack_six(0) ++= move.reverse }
                        case 7 => { stack_seven(0) ++= move.reverse }
                        case 8 => { stack_eight(0) ++= move.reverse }
                        case 9 => { stack_nine(0) ++= move.reverse }
                    }
                    stack_three(0) = stack_three(0).dropRight(amount_to_move)
                }
                case 4 => {
                    val move = stack_four(0).takeRight(amount_to_move)
                    move_to match {
                        case 1 => { stack_one(0) ++= move.reverse }
                        case 2 => { stack_two(0) ++= move.reverse }
                        case 3 => { stack_three(0) ++= move.reverse }
                        case 5 => { stack_five(0) ++= move.reverse }
                        case 6 => { stack_six(0) ++= move.reverse }
                        case 7 => { stack_seven(0) ++= move.reverse }
                        case 8 => { stack_eight(0) ++= move.reverse }
                        case 9 => { stack_nine(0) ++= move.reverse }
                    }
                    stack_four(0) = stack_four(0).dropRight(amount_to_move)
                }
                case 5 => {
                    val move = stack_five(0).takeRight(amount_to_move)
                    move_to match {
                        case 1 => { stack_one(0) ++= move.reverse }
                        case 2 => { stack_two(0) ++= move.reverse }
                        case 3 => { stack_three(0) ++= move.reverse }
                        case 4 => { stack_four(0) ++= move.reverse }
                        case 6 => { stack_six(0) ++= move.reverse }
                        case 7 => { stack_seven(0) ++= move.reverse }
                        case 8 => { stack_eight(0) ++= move.reverse }
                        case 9 => { stack_nine(0) ++= move.reverse }
                    }
                    stack_five(0) = stack_five(0).dropRight(amount_to_move)
                }
                case 6 => {
                    val move = stack_six(0).takeRight(amount_to_move)
                    move_to match {
                        case 1 => { stack_one(0) ++= move.reverse }
                        case 2 => { stack_two(0) ++= move.reverse }
                        case 3 => { stack_three(0) ++= move.reverse }
                        case 4 => { stack_four(0) ++= move.reverse }
                        case 5 => { stack_five(0) ++= move.reverse }
                        case 7 => { stack_seven(0) ++= move.reverse }
                        case 8 => { stack_eight(0) ++= move.reverse }
                        case 9 => { stack_nine(0) ++= move.reverse }
                    }
                    stack_six(0) = stack_six(0).dropRight(amount_to_move)
                }
                case 7 => {
                    val move = stack_seven(0).takeRight(amount_to_move)
                    move_to match {
                        case 1 => { stack_one(0) ++= move.reverse }
                        case 2 => { stack_two(0) ++= move.reverse }
                        case 3 => { stack_three(0) ++= move.reverse }
                        case 4 => { stack_four(0) ++= move.reverse }
                        case 5 => { stack_five(0) ++= move.reverse }
                        case 6 => { stack_six(0) ++= move.reverse }
                        case 8 => { stack_eight(0) ++= move.reverse }
                        case 9 => { stack_nine(0) ++= move.reverse }
                    }
                    stack_seven(0) = stack_seven(0).dropRight(amount_to_move)
                }
                case 8 => {
                    val move = stack_eight(0).takeRight(amount_to_move)
                    move_to match {
                        case 1 => { stack_one(0) ++= move.reverse }
                        case 2 => { stack_two(0) ++= move.reverse }
                        case 3 => { stack_three(0) ++= move.reverse }
                        case 4 => { stack_four(0) ++= move.reverse }
                        case 5 => { stack_five(0) ++= move.reverse }
                        case 6 => { stack_six(0) ++= move.reverse }
                        case 7 => { stack_seven(0) ++= move.reverse }
                        case 9 => { stack_nine(0) ++= move.reverse }
                    }
                    stack_eight(0) = stack_eight(0).dropRight(amount_to_move)
                }
                case 9 => {
                    val move = stack_nine(0).takeRight(amount_to_move)
                    move_to match {
                        case 1 => { stack_one(0) ++= move.reverse }
                        case 2 => { stack_two(0) ++= move.reverse }
                        case 3 => { stack_three(0) ++= move.reverse }
                        case 4 => { stack_four(0) ++= move.reverse }
                        case 5 => { stack_five(0) ++= move.reverse }
                        case 6 => { stack_six(0) ++= move.reverse }
                        case 7 => { stack_seven(0) ++= move.reverse }
                        case 8 => { stack_eight(0) ++= move.reverse }
                    }
                    stack_nine(0) = stack_nine(0).dropRight(amount_to_move)
                }
            }
        }

        println("  Stack one: " + stack_one(0))
        println("  Stack two: " + stack_two(0))
        println("Stack three: " + stack_three(0))
        println(" Stack four: " + stack_four(0))
        println(" Stack five: " + stack_five(0))
        println("  Stack six: " + stack_six(0))
        println("Stack seven: " + stack_seven(0))
        println("Stack eight: " + stack_eight(0))
        println(" Stack nine: " + stack_nine(0))
        println("\nSolution: " + stack_one(0).takeRight(1) + 
                                stack_two(0).takeRight(1) + 
                                stack_three(0).takeRight(1) + 
                                stack_four(0).takeRight(1) + 
                                stack_five(0).takeRight(1) + 
                                stack_six(0).takeRight(1) + 
                                stack_seven(0).takeRight(1) + 
                                stack_eight(0).takeRight(1) + 
                                stack_nine(0).takeRight(1))
    }
}

package _2015

import com.example.Solver

object Day1 extends Solver {
  private def input: String =
    scala.io.Source
      .fromFile("src/main/scala/_2015/inputs/day1.txt")
      .getLines()
      .next()

  def solve(): Unit = {
    println(s"Day 1-1: ${part1()}")
    println(s"Day 1-2: ${part2()}")
  }

  def part1(): Int =
    input.foldLeft(0) {
      case (acc, '(') => acc + 1
      case (acc, ')') => acc - 1
      case (acc, _)   => acc
    }

  def part2(): Int =
    input
      .scanLeft(0) {
        case (floor, '(') => floor + 1
        case (floor, ')') => floor - 1
        case (floor, _)   => floor
      }
      .indexWhere(_ == -1)
}

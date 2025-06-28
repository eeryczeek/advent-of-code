package _2015

import scala.math.min
import com.example.Solver

object Day5 extends Solver {
  private def input =
    scala.io.Source
      .fromFile("src/main/scala/_2015/inputs/day5.txt")
      .getLines()
      .toList

  def solve(): Unit = {
    println(s"Day 5-1: ${part1()}")
    println(s"Day 5-2: ${part2()}")
  }

  private def isNice1(string: String) = {
    val hasThreeVowels = string.count("aeiou".contains(_)) >= 3
    val hasDoubleLetter = string.sliding(2).exists(pair => pair(0) == pair(1))
    val forbidden = Set("ab", "cd", "pq", "xy")
    val hasNoForbiddenStrings = !string.sliding(2).exists(forbidden.contains)

    hasThreeVowels && hasDoubleLetter && hasNoForbiddenStrings
  }

  private def isNice2(string: String) = {
    val hasTwoPairs = string
      .sliding(2)
      .zipWithIndex
      .exists { case (pair, idx) =>
        string.indexOf(pair, idx + 2) != -1
      }
    val hasRepeatWithGap = string
      .sliding(3)
      .exists(triplet => triplet(0) == triplet(2))

    hasTwoPairs && hasRepeatWithGap
  }

  def part1(): Int = input.count(isNice1(_))
  def part2(): Int = input.count(isNice2(_))
}

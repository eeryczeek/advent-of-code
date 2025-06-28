package _2015

import scala.math.min
import com.example.Solver

object Day2 extends Solver {
  private def input =
    scala.io.Source
      .fromFile("src/main/scala/_2015/inputs/day2.txt")
      .getLines()
      .toList
      .map { line =>
        line.split("x").map(_.toInt) match {
          case Array(l, w, h) => (l, w, h)
          case _              => throw new IllegalArgumentException
        }
      }

  def solve(): Unit = {
    println(s"Day 1-1: ${part1()}")
    println(s"Day 1-2: ${part2()}")
  }

  def part1(): Int = input.foldLeft(0) { case (acc, (l, w, h)) =>
    acc + 2 * l * w + 2 * w * h + 2 * l * h + Seq(l * w, w * h, l * h).min
  }

  def part2(): Int = input.foldLeft(0) { case (acc, (l, w, h)) =>
    acc + 2 * Seq(l + w, w + h, l + h).min + l * w * h
  }
}

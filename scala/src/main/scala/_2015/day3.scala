package _2015

import com.example.Solver

object Day3 extends Solver {
  private def input: String =
    scala.io.Source
      .fromFile("src/main/scala/_2015/inputs/day3.txt")
      .getLines()
      .next()

  def solve(): Unit = {
    println(s"Day 3-1: ${part1()}")
    println(s"Day 3-2: ${part2()}")
  }

  private def move(pos: (Int, Int), dir: Char): (Int, Int) = dir match {
    case '^' => (pos._1, pos._2 + 1)
    case 'v' => (pos._1, pos._2 - 1)
    case '>' => (pos._1 + 1, pos._2)
    case '<' => (pos._1 - 1, pos._2)
    case _   => pos
  }

  private def visitedHouses(directions: Seq[Char]): Set[(Int, Int)] =
    directions
      .foldLeft((0, 0), Set((0, 0))) { case ((pos, visited), dir) =>
        val newPos = move(pos, dir)
        (newPos, visited + newPos)
      }
      ._2

  def part1(): Int = visitedHouses(input).size

  def part2(): Int = {
    val (santaMoves, roboMoves) = input.zipWithIndex.partition {
      case (_, idx) => idx % 2 == 0
    }
    val santaVisited = visitedHouses(santaMoves.map(_._1))
    val roboVisited = visitedHouses(roboMoves.map(_._1))
    (santaVisited ++ roboVisited).size
  }
}

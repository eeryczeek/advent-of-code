package _2015

import com.example.Solver
import java.security.MessageDigest
import scala.annotation.tailrec

object Day4 extends Solver {
  private lazy val input: String =
    scala.io.Source
      .fromFile("src/main/scala/_2015/inputs/day4.txt")
      .getLines()
      .next()

  def solve(): Unit = {
    println(s"Day 4-1: ${part1(input)}")
    println(s"Day 4-2: ${part2(input)}")
  }

  private val messageDigest = MessageDigest
    .getInstance("MD5")

  private def md5Hex(s: String): String =
    messageDigest
      .digest(s.getBytes)
      .map("%02x".format(_))
      .mkString

  @tailrec
  private def findWithPrefix(key: String, prefix: String, i: Long = 1): Long =
    if (md5Hex(key + i).startsWith(prefix)) i
    else findWithPrefix(key, prefix, i + 1)

  def part1(key: String): Long = findWithPrefix(key, "00000")
  def part2(key: String): Long = findWithPrefix(key, "000000")
}

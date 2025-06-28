package com.example

import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

object Main extends App {
  val solutions: List[Solver] = List(
    _root_._2015.Day1,
    _root_._2015.Day2,
    _root_._2015.Day3,
    _root_._2015.Day4,
    _root_._2015.Day5
  )

  val futures = solutions.map(solver => Future { solver.solve() })
  Await.result(Future.sequence(futures), Duration.Inf)
}

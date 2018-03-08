package chapter03

object ForPattern {

  def gameResults(): Seq[(String, Int)] = ("Raina", 10) :: ("Dhoni", 13) :: ("Kohli", 18) :: Nil

  def hallOfFame = for{
    (name, score) <- gameResults()

    if score>10
  } yield name

  def printName() = println(hallOfFame)
}

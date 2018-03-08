package chapter02

object MultipleNameExctractor {
  def unapplySeq(name: String): Option[(String, String, Seq[String])] = {
    val names = name.trim.split(" ")
    if(names.size < 2)
      None
    else
      Some((names.last, names.head, names.drop(1).dropRight(1)))
  }
}

import chapter01.MainHelperForChapter01._
import chapter02.MainHelperForChapter02.callForChapter02
import chapter03.MainHelperForChapter03.callForChapter03

object Main {
  def main(args: Array[String]): Unit = {
    //CHAPTER-01
    callForChapter01()
    println("-------------")
    callForChapter02()
    println("-------------")
    callForChapter03()
  }
}

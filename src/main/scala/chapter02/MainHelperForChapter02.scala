package chapter02

object MainHelperForChapter02 {
 def greetWithFirstName(name: String) = name match {
   case GivenNamesExtractor(firstname, _*) => "Good Morning " + firstname + "!!"
   case _ => "Fill full name"
 }

  def greetWithFullName(name: String) = name match {
    case MultipleNameExctractor(lastname, firstName, _*) => "Welcome " + firstName + " " + lastname + " :D"
    case _ => "enter full name"
  }

  def callForChapter02():Unit = {
    val name1 = "Varun Kumar"
    val name2 = "Rinku bhabhi urf Gutthi"

    println("greetWithFirstName : "+ greetWithFirstName(name1))

    println("greetWithFullName : "+ greetWithFullName(name2))
  }
}

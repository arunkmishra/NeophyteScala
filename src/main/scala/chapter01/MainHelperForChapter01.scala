package chapter01

object MainHelperForChapter01 {
 def callForChapter01():Unit = {
   //--- Simple User ---
   val free_User = new FreeUser("Arun")
   println("free User : " + FreeUser.unapply(free_User))
   val preUser = free_User match {
     case FreeUser(name) => "Hii friend "+ name
     case PremiumUser(name) => "Hi Sir "+ name
   }
   println(">> Msg : " + preUser)

   //--- Several Extractor user ---
   val freeUserE = new FreeUserE("Arun k", 3000, 0.7d)
   val x =freeUserE match {
     case FreeUserE(name, _,p) => if(p>0.75) name + ", what can we do for u today?" else " hello "+name + p
     case PremiumUserE(name, _) => "Welcome back "+ name
   }
   println(">> Msg1 : "+ x)

   //--- List Extractor ---
   val ls = 58 #:: 43 #:: 44 #:: Stream.empty

   ls match {
     case @::(f,@::(s, _)) => println(s"f: $f && s : $s ")
   }
 }
}

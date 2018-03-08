package chapter01

trait SimpleUser {
  def name: String
}

class FreeUser(val name: String) extends SimpleUser
class PremiumUser(val name: String) extends SimpleUser

object FreeUser{
  def unapply(user: FreeUser): Option[String] = Some(user.name)
}

object PremiumUser{
  def unapply(user: PremiumUser): Option[String] = Some(user.name)
}
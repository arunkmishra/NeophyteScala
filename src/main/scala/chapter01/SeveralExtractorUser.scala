package chapter01

trait SeveralExtractorUser {
  def name: String
  def score: Int
}

class FreeUserE(val name: String, val score: Int, val upgradeProb: Double) extends SeveralExtractorUser

class PremiumUserE(val name: String, val score: Int) extends SeveralExtractorUser

object FreeUserE{
  def unapply(user: FreeUserE): Option[(String, Int, Double)] =  Some((user.name,user.score,user.upgradeProb))
}

object PremiumUserE{
  def unapply(user: PremiumUserE): Option[(String, Int)] = Some((user.name,user.score))
}


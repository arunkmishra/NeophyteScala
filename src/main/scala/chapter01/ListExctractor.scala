package chapter01

/*First, the extractor is called for the intitial stream xs that is passed to the pattern matching block.
The extractor returns Some((xs.head, xs.tail)), so first is bound to 58, while the tail of xs is passed to
the extractor again, which is used again inside of the first one. Again, it returns the head and and tail
as a Tuple2 wrapped in a Some, so that second is bound to the value 43, while the tail is bound to the
wildcard _ and thus thrown away.*/

object @::{
  def unapply[A](ls : Stream[A]): Option[(A, Stream[A])] =
    if(ls.isEmpty)
      None
    else
      Some((ls.head,ls.tail))
}


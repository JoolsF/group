//
// Make this an actor and write a message handler for at least the
// set method.
//

import akka.actor.{Props, ActorSystem, Actor}

object Coordinator {

    def init(im: Image, of: String) = {
    image = im
    outfile = of
    waiting = im.width * im.height
  }

  var waiting = 0   // Number of pixels we're waiting for to be set.
  var outfile: String = null
  var image: Image = null
  

  def set(x: Int, y: Int, c: Colour) = {
    image(x, y) = c
    waiting -= 1
    if (waiting == 0) print
  }

  def print = {
    assert(waiting == 0)
    image.print(outfile)
    println("Complete. Shutting down...")
    Scene.ACTOR_SYSTEM.shutdown() // Shutdown Actor System
  }
}

class  Coordinator extends Actor {

  override def receive = {  
  	case (x: Int, y: Int, colour:Colour)  => Coordinator.set(x, y, colour)
  	case (im: Image, of: String) => Coordinator.init(im, of)  

  }
}


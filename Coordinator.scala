// TODO
//
// Make this an actor and write a message handler for at least the
// set method.
//

import akka.actor.{Props, ActorSystem, Actor}

object Coordinator {
////  
////  var waiting = 0
////  var outfile: String = null
////  var image: Image = null
//////
////  def props(im: Image, of: String): Props = {
////    var waiting = im.width * im.height
////    val system = ActorSystem("System")
////   
//    def init(im: Image, of: String) = {
//   
//    println("******************************INIT called****************************************************************************")
//     import akka.actor.{Props, ActorSystem, Actor}
//     val system = ActorSystem("MySystem")
//     val actorRef = system.actorOf(Props[Coordinator], name = "ActorRay")
//     actorRef ! (im, of)
//     }
    def init(im: Image, of: String) = {
    
  //  println("******************************INIT called****************************************************************************")
    image = im
    outfile = of
    waiting = im.width * im.height
    
  }

  // Number of pixels we're waiting for to be set.
  var waiting = 0
  var outfile: String = null
  var image: Image = null
  
  // TODO: make set - a message
  //requires a message handler
  def set(x: Int, y: Int, c: Colour) = {
 //   println("***DEBUG*** image: " + image)
    image(x, y) = c
    waiting -= 1
    if (waiting == 0) print
  }

  def print = {
    assert(waiting == 0)
    image.print(outfile)
  }
    
  
  
}
//case class Counter(var image: Image, var outfile: String, var waiting: Int)


class  Coordinator extends Actor {

  
  override def receive = {  
  	case (x: Int, y: Int, colour:Colour)  => Coordinator.set(x, y, colour)
  	case (im: Image, of: String) => Coordinator.init(im, of)  
  //	case "Test" => println(outfile)
  }
  
//  def init(im: Image, of: String) = {
//    
//    println("******************************INIT called****************************************************************************")
//    image = im
//    outfile = of
//    waiting = im.width * im.height
//    
//  }
//
//  // Number of pixels we're waiting for to be set.
//  var waiting = 0
//  var outfile: String = null
//  var image: Image = null
//  
//  // TODO: make set - a message
//  //requires a message handler
//  def set(x: Int, y: Int, c: Colour) = {
//    println("***DEBUG*** image: " + image)
//    image(x, y) = c
//    waiting -= 1
//    if (waiting == 0) print
//  }
//
//  def print = {
//    assert(waiting == 0)
//    image.print(outfile)
//  }
}
















//object Coordinator {
//  def init(im: Image, of: String) = {
//    image = im
//    outfile = of
//    waiting = im.width * im.height
//  }
//
//  // Number of pixels we're waiting for to be set.
//  var waiting = 0
//  var outfile: String = null
//  var image: Image = null
//
//  // TODO: make set - a message
//  //requires a message handler
//  def set(x: Int, y: Int, c: Colour) = {
//    image(x, y) = c
//    waiting -= 1
//  }
//
//  def print = {
//    assert(waiting == 0)
//    image.print(outfile)
//  }
//}

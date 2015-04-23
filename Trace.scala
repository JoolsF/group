object Trace {

  val AntiAliasingFactor = 4
  val Width = 800
  val Height = 600

  var rayCount = 0
  var hitCount = 0
  var lightCount = 0
  var darkCount = 0

//   import akka.actor.{Props, ActorSystem, Actor}
//   val system = ActorSystem("SystemRay")
//   val COORDINATOR_ACTOR_NAME = "coordinatorActor"
//   val coordinatorActor = system.actorOf(Props[Coordinator], name = COORDINATOR_ACTOR_NAME)
  
  
  
  def main(args: Array[String]): Unit = {
    if (args.length != 2) {
      println("usage: scala Trace input.dat output.png")
      System.exit(-1)
    }

    val (infile, outfile) = (args(0), args(1))
    val scene = Scene.fromFile(infile)

    render(scene, outfile, Width, Height)

    println("rays cast " + rayCount)
    println("rays hit " + hitCount)
    println("light " + lightCount)
    println("dark " + darkCount)
  }

  def render(scene: Scene, outfile: String, width: Int, height: Int) = {
    val image = new Image(width, height)

    // Init the coordinator -- must be done before starting it.
//     import akka.actor.{Props, ActorSystem, Actor}
//     val system = ActorSystem("MySystem")
//     val actorRef = system.actorOf(Props[Coordinator], name = "ActorRay")
     
     
     Coordinator.init(image, outfile)
//     
//     val system2 = ActorSystem("SystemRay")
//     val actorRef2Path = system2./("ActorRay")
//     val actorRef2 = system2.actorSelection(actorRef2Path)
//     actorRef ! "Test"
//      actorRef2 ! "Test"

     
     //actorRef2 ! "Test"
     
     // Coordinator.init(image, outfile)

    //   ! init(image, outfile)
    // TODO: Start the Coordinator actor.

    scene.traceImage(width, height)

    // TODO:
    // This one is tricky--we can't simply send a message here to print
    // the image, since the actors started by traceImage haven't necessarily
    // finished yet.  Maybe print should be called elsewhere?
    
    // Coordinator.print
  }
}

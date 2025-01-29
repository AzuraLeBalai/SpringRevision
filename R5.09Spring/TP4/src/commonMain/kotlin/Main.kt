class Main {

}fun main(){
    //Q1
    val someFunction = SomeClass();
    someFunction.a()
    someFunction.b()
    someFunction.c()

    //Q2
    val giraffe1 = Giraffe()
    val giraffe2 = Giraffe()
    val giraffe3 = Giraffe()
    giraffe1.displayID()
    giraffe2.displayID()
    giraffe3.displayID()

    //Q3
    val robot = Robot()
    robot.right(10)
    robot.left(5)
    robot.down(8)
    robot.up(3)

    //Q4
    val x = X()
    println(x.add())

    //Q5
    val robot2 = Robot2()
    robot2.right(1)
    robot2.down(1)
    println(robot2.getLocation())

    //Q6
    val robot3 = Robot3()
    robot3.up(1)
    println(robot3.getLocation()) // (0, 99)
    robot3.left(10)
    println(robot3.getLocation()) // (90,99)

    //Q7
    val floating = Floating(3.14159)
    println(floating)

    //Q8
    val robot4 = Robot4(0, 0, 100)
    robot4.right(10)
    robot4.down(15)
    println(robot4.getLocation())

    //Q9
    val robot5 = Robot5(1, 2, 100)
    println(robot5)

    //10
    val alien1 = Alien("Arthricia", "Cat Person", "PurgePlanet")
    val alien2 = Alien("Dale", "Giant", "Gearworld")

    alien1.movePlanet("Earth C-137")
    alien2.movePlanet("Parblesnops")

    println(alien1)
    println(alien2)
}
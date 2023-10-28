import Benjamin.PlayerBenjamin

fun main(args: Array<String>) {
    val game = Game()

    val player1 = getPlayer(args[0])
    val player2 = getPlayer(args[1])

   game.runGame(player1,player2)
}

fun getPlayer(name:String):Player{

    when (name){
        "Tim" -> return PlayerTim()
        "Benjamin"-> return PlayerBenjamin()
        "Interactive"  -> return IntetactivePlayer()
    }
    return IntetactivePlayer()
}
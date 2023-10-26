import Benjamin.PlayerBenjamin
import Board.Board

class Game {

    val board = Board()

    val player1 : PlayerBenjamin = PlayerBenjamin()
    val player2 : PlayerTim = PlayerTim()

    fun runGame() {

        println("Starting game")
        while (!board.checkForWinner()) {
            try {
                player1.nextMove(this.board)
            }catch (e:Exception){
                println("Player 1 has lost because he triggered an error")
            }

            try {
                player2.nextMove(this.board)
            }catch (e:Exception){
                println("Player 2 has lost because he triggered an error")
            }

        }

    }
}
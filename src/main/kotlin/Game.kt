import Board.Board
import Board.PieceColor

class Game {

    val board = Board()

    fun runGame(player1: Player, player2: Player) {

        player1.setColor(PieceColor.black)
        player2.setColor(PieceColor.white)

        println("Starting game")
        board.printBoard()
        while (!board.checkForWinner()) {

            try {
                player1.nextMove(this.board)
            } catch (e: Exception) {
                println("Player 1 has lost because he triggered an error")
            }
            board.printBoard()
            println("Player2 ist am Zug")

            try {
                player2.nextMove(this.board)
            } catch (e: Exception) {
                println("Player 2 has lost because he triggered an error")
            }
            board.printBoard()
            println("Player1 ist am Zug")
        }

    }
}
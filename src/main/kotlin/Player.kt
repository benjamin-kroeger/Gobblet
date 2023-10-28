import Board.Board
import Board.PieceColor

interface Player {
    fun nextMove(board: Board)
    fun setColor(color: PieceColor)

}
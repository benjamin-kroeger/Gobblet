package Benjamin

import Board.Board
import Board.Piece
import Board.PieceColor
import Player

class PlayerBenjamin : Player {

    lateinit var myColor :PieceColor
    val myBoard : MiniBoard = MiniBoard()
    val pieceSizes = listOf(1, 2, 3, 4)
    val whitePieces = pieceSizes.flatMap { size -> List(3) { Piece(PieceColor.white, size) } }
    val blackPieces = pieceSizes.flatMap { size -> List(3) { Piece(PieceColor.black, size) } }

    override fun setColor(color: PieceColor) {
        myColor = color
    }

    override fun nextMove(board: Board) {
        myBoard.updateFromBoard(board.getBoardMatrix())





    }

}